(ns storefront.handler
  (:require [storefront.config :as config]
            [clojure.string :as string]
            [clojure.java.io :as io]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [clj-http.client :as http]
            [ring.middleware.defaults :refer :all]
            [ring.util.response :refer [redirect response status content-type header]]
            [noir-exception.core :refer [wrap-internal-error wrap-exceptions]]
            [ring.middleware.content-type :refer [wrap-content-type]]
            [ring.middleware.json :refer [wrap-json-params wrap-json-response]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring-logging.core :refer [make-logger-middleware]]
            [storefront.prerender :refer [wrap-prerender]]
            [hiccup.page :as page]
            [hiccup.element :as element]
            [storefront.assets :refer [asset-path]])
  (:import [java.util Date Locale TimeZone Calendar GregorianCalendar]
           [java.text SimpleDateFormat]))

(defn storefront-site-defaults
  [env]
  (if (config/development? env)
    site-defaults
    (-> secure-site-defaults
        (assoc :proxy true)
        (assoc-in [:security :hsts] false)
        (assoc-in [:static :resources] false))))

(defn fetch-store [storeback-config store-slug]
  (when (seq store-slug)
    (try
      (->
       (http/get (str (:endpoint storeback-config) "/store")
                 {:query-params {:store_slug store-slug}
                  :throw-exceptions false
                  :socket-timeout 10000
                  :conn-timeout 10000
                  :as :json})
       :body)
      (catch java.io.IOException e
        ::storeback-unavailable))))

(defn parse-subdomains [server-name]
  (->> (string/split server-name #"\.")
       (drop-last 2)))

(defn parse-tld [server-name]
  (->> (string/split server-name #"\.")
       (take-last 2)
       (string/join ".")))

(defn query-string [req]
  (let [query-str (:query-string req)]
    (when (seq query-str)
      (str "?" query-str))))

(defn wrap-redirect [h storeback-config]
  (fn [req]
    (let [subdomains (parse-subdomains (:server-name req))
          subdomain (first subdomains)
          domain (str (parse-tld (:server-name req)) ":"
                      (:server-port req))
          store (fetch-store storeback-config (last subdomains))]
      (cond
        (= "jobs" subdomain)
        (redirect "http://jobs.lever.co/mayvenn")

        (= "vistaprint" subdomain)
        (redirect "http://www.vistaprint.com/vp/gateway.aspx?sr=no&s=6797900262")

        (#{[] ["www"]} subdomains)
        (redirect (str "http://welcome." domain "/hello" (query-string req)))

        (= "www" subdomain)
        (redirect (str "http://" (:store_slug store) "." domain (query-string req)))

        (= store ::storeback-unavailable) (h req)
        (:store_slug store) (h req)
        :else (redirect (str "http://store." domain (query-string req)))))))

(defn robots [req]
  (let [subdomain (first (parse-subdomains (:server-name req)))]
    (if (or (= subdomain "shop")(= subdomain "www")(= subdomain nil))
      (string/join "\n" ["User-agent: *"
                         "Disallow: /account"
                         "Disallow: /checkout"
                         "Disallow: /orders"
                         "Disallow: /stylist"
                         "Disallow: /cart"
                         "Disallow: /m/"
                         "Disallow: /admin"])
      (string/join "\n" ["User-agent: googlebot"
                         "Disallow: /"]))))

(defn index [storeback-config env]
  (page/html5
   [:head
    [:meta {:name "fragment" :content "!"}]
    [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0, maximum-scale=1.0"}]
    [:meta {:property "og:type" :content "website"}]
    [:meta {:property "og:title" :content "Shop Mayvenn"}]
    [:meta {:property "og:image" :content (asset-path "/images/home_image.jpg")}]
    [:meta {:property "og:description" :content "Mayvenn sells 100% natural hair extensions backed by a 30-day Quality Guarantee."}]
    [:meta {:property "og:site_name" :content "Mayvenn"}]
    [:link {:href (asset-path "/images/favicon.png") :rel "shortcut icon" :type "image/vnd.microsoft.icon"}]
    (page/include-css (asset-path "/css/all.css"))]
   [:body
    [:div#content]
    (element/javascript-tag (str "var environment=\"" env "\";"))
    [:script {:src (asset-path "/js/out/main.js")}]]))

(defn- ^SimpleDateFormat make-http-format
  "Formats or parses dates into HTTP date format (RFC 822/1123).
  From ring"
  []
  ;; SimpleDateFormat is not threadsafe, so return a new instance each time
  (doto (SimpleDateFormat. "EEE, dd MMM yyyy HH:mm:ss ZZZ" Locale/US)
    (.setTimeZone (TimeZone/getTimeZone "UTC"))))

(defn years-from-now []
  (.getTime (doto (GregorianCalendar.)
              (.add Calendar/YEAR 10))))

(defn wrap-cdn [f]
  (fn [req]
    (let [resp (f req)]
      (if (.startsWith (:uri req) "/cdn/")
        (-> resp
            (header "Content-Encoding" "gzip")
            (header "Access-Control-Allow-Origin" "*")
            (header "Access-Control-Allow-Methods" "GET")
            (header "Cache-Control" (str "max-age=" (* 10 365 24 60 60)))
            (header "Expires" (.format (make-http-format) (years-from-now))))
        resp))))

(defn request-scheme [req]
  (if-let [forwarded-proto (get-in req [:headers "x-forwarded-proto"])]
    (keyword forwarded-proto)
    (:scheme req)))

(defn prerender-original-request-url [development? req]
  (str (name (request-scheme req)) "://shop."
       (parse-tld (:server-name req))
       ":" (if development? (:server-port req) 443) (:uri req)))

(defn site-routes
  [logger storeback-config environment prerender-token]
  (->
   (routes
    (GET "*" req (->
                  (index storeback-config environment)
                  response
                  (content-type "text/html"))))
   (wrap-prerender (config/development? environment)
                   prerender-token
                   (partial prerender-original-request-url
                            (config/development? environment)))
   (make-logger-middleware logger)
   (wrap-defaults (storefront-site-defaults environment))
   (wrap-redirect storeback-config)
   (wrap-resource "public")
   (wrap-content-type)
   (wrap-cdn)))

(defn create-handler
  ([] (create-handler {}))
  ([{:keys [logger exception-handler storeback-config environment prerender-token]}]
   (-> (routes (GET "/healthcheck" [] "cool beans")
               (GET "/robots.txt" req (content-type (response (robots req))
                                                "text/plain"))
               (GET "/categories" req (redirect "/categories/hair/straight"))
               (site-routes logger storeback-config environment prerender-token)
               (route/not-found "Not found"))
       (#(if (config/development? environment)
           (wrap-exceptions %)
           (wrap-internal-error %
                                :log (comp (partial logger :error) exception-handler)
                                :error-response "{\"error\": \"something went wrong\"}"))))))
