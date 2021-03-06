(ns storefront.browser.cookie-jar
  (:require [storefront.config :as config]
            [clojure.string :as string]
            [spice.core :as spice])
  (:import [goog.net Cookies]))

(defn ^:private root-domain []
  (-> js/window
      .-location
      .-hostname
      (string/split #"\.")
      (->> (take-last 2)
           (string/join ".")
           (str "."))))

(def week (* 60 60 24 7))
(def four-weeks (* week 4))
(def one-year (* week 52))

(defn make-cookie []
  (Cookies. js/document))

(def user
  {:domain        nil
   :max-age       four-weeks
   :optional-keys [:store-slug]
   :required-keys [:email :user-token :id]})

(def order
  {:domain        nil
   :max-age       four-weeks
   :optional-keys []
   :required-keys [:token :number]})

(def pending-promo
  {:domain        nil
   :max-age       four-weeks
   :optional-keys []
   :required-keys [:pending-promo-code]})

(def utm-params
  {:domain        (root-domain)
   :max-age       four-weeks
   :optional-keys [:storefront/utm-source :storefront/utm-medium :storefront/utm-campaign :storefront/utm-content :storefront/utm-term]
   :required-keys []})

(def leads-utm-params
  {:domain        (root-domain)
   :max-age       four-weeks
   :optional-keys ["leads.utm-source" "leads.utm-medium" "leads.utm-campaign" "leads.utm-content" "leads.utm-term"]
   :required-keys []})

(def lead
  {:domain        (root-domain)
   :max-age       four-weeks
   :optional-keys ["onboarding-status"]
   :required-keys ["lead-id"]})

(def email-capture-session
  {:domain        nil
   :max-age       1800
   :optional-keys []
   :required-keys [:popup-session]})

(def telligent-session
  {:domain        (root-domain)
   :max-age       nil ;; determined dynamically
   :secure        config/telligent-community-secured?
   :optional-keys []
   :required-keys ["AuthenticatedUser"]})

(def account-specs [user order pending-promo telligent-session])

(defn all-keys [spec]
  (concat (:optional-keys spec) (:required-keys spec)))

(defn clear-cookie [spec cookie]
  (doseq [key (all-keys spec)]
    (.remove cookie key "/" (:domain spec))
    (.remove cookie (spice/kw-name key) "/" (:domain spec))))

(defn has-required-attrs? [m req-attrs]
  (every? seq (vals (select-keys m req-attrs))))

(defn retrieve [spec cookie]
  (let [attr-keys (all-keys spec)
        m (zipmap attr-keys
                  (map #(or
                         (.get cookie %)
                         (.get cookie (spice/kw-name %)))
                       attr-keys))]
    (if (has-required-attrs? m (:required-keys spec))
      m
      (clear-cookie spec cookie))))

(defn save-cookie [{:keys [max-age domain] :as spec} cookie attrs]
  (doseq [attr (all-keys spec)]
    (if-let [val (get attrs attr)]
      (.set        cookie (spice/kw-name attr) (js/encodeURIComponent val) max-age "/" domain (get spec :secure config/secure?))
      (do (.remove cookie attr                 "/" domain)
          (.remove cookie (spice/kw-name attr) "/" domain)))))

(def clear-order (partial clear-cookie order))
(def clear-pending-promo-code (partial clear-cookie pending-promo))
(def clear-utm-params (partial clear-cookie utm-params))
(def clear-telligent-session (partial clear-cookie telligent-session))
(defn clear-account [cookie]
  (doseq [spec account-specs]
    (clear-cookie spec cookie)))
(def clear-email-capture-session (partial clear-cookie email-capture-session))
(def clear-lead (partial clear-cookie lead))
(def retrieve-login (partial retrieve user))
(def retrieve-current-order (partial retrieve order))
(def retrieve-pending-promo-code (partial retrieve pending-promo))
(def retrieve-utm-params (partial retrieve utm-params))
(def retrieve-leads-utm-params (partial retrieve leads-utm-params))
(def retrieve-lead (partial retrieve lead))

(def retrieve-email-capture-session (comp :popup-session (partial retrieve email-capture-session)))

(def ^:private session-id-length 24)

(defn- must-generate-session-id? [existing-session-id]
  (or (nil? existing-session-id)
      (> (count existing-session-id) session-id-length)))

(defn- random-id []
  (let [s (.toString (js/Math.random) 36)]
    (subs s 2 (+ 2 session-id-length))))

(defn force-session-id [cookie]
  (let [session-id (.get cookie :session-id)]
    (if (must-generate-session-id? session-id)
      (let [created-session-id (random-id)]
        (.set cookie :session-id created-session-id one-year "/" nil config/secure?)
        created-session-id)
      session-id)))

(def save-user (partial save-cookie user))
(def save-order (partial save-cookie order))

(defn save-email-capture-session [cookie value]
  (let [max-age (condp = value
                  "signed-in" four-weeks
                  "opted-in"  (* 200 one-year)
                  "dismissed" 1800)]
    (.set cookie :popup-session value max-age "/" (:domain email-capture-session) config/secure?)))

(defn save-pending-promo-code [cookie promo-code]
  (save-cookie pending-promo cookie {:pending-promo-code promo-code}))

(def save-utm-params (partial save-cookie utm-params))
(def save-leads-utm-params (partial save-cookie leads-utm-params))
(def save-lead (partial save-cookie lead))

(defn save-telligent-cookie [cookie contents max-age]
  (save-cookie (assoc telligent-session :max-age max-age) cookie {"AuthenticatedUser" contents}))
