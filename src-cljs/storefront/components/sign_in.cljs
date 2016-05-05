(ns storefront.components.sign-in
  (:require [om.core :as om]
            [sablono.core :refer-macros [html]]
            [storefront.components.utils :as utils]
            [storefront.components.ui :as ui]
            [storefront.components.facebook :as facebook]
            [storefront.events :as events]
            [storefront.hooks.experiments :as experiments]
            [storefront.keypaths :as keypaths]))

(defn redesigned-sign-in-form-component [{:keys [facebook-loaded? email password remember-me? get-satisfaction-login?]}]
  (om/component
   (html
    [:.flex.flex-column.items-center.black.sans-serif.col-12.mt1
     (facebook/redesigned-sign-in-button facebook-loaded?)
     [:.h4.gray.extra-light.my2 "OR"]

     [:form.col-12.flex.flex-column.items-center
      {:on-submit (utils/send-event-callback events/control-sign-in-submit)}
      [:input.hide {:type "submit"}]

      (ui/text-field "Email" keypaths/sign-in-email email
                     {:autofocus "autofocus"
                      :type "email"
                      :name "email"
                      :required true})

      (ui/text-field "Password" keypaths/sign-in-password password
                     {:type "password"
                      :name "password"
                      :required true})
      [ui/large-button
       {:on-click (utils/send-event-callback events/control-sign-in-submit)}
       [ui/large-button-text "Sign In"]]

      [:.mt2.col-10.mb3
       [:label.col.col-6.left-align.gray
        [:input#remember-me.align-middle
         (merge (utils/toggle-checkbox keypaths/sign-in-remember remember-me?)
                {:type "checkbox" :name "remember-me"})]
        [:.inline.ml1 "Remember me"]]
       [:a.col.col-6.right-align.gray
        (utils/route-to events/navigate-forgot-password) "Forgot Password?"]]]

     (when-not get-satisfaction-login?
       [:.clearfix.center.gray.mb2 "Don't have an account? "
        [:a.teal (utils/route-to events/navigate-sign-up) "Register Here"]])])))

(defn redesigned-sign-in-component [{:keys [get-satisfaction-login?] :as form-data} owner]
  (om/component
   (html
    [:.bg-white
     [:.flex.flex-column.items-center.black.sans-serif.col-12.md-col-9.lg-col-6.m-auto
      (when-not get-satisfaction-login?
        [:.h2.mb1.mt3 "Sign in to your account"])
      (om/build redesigned-sign-in-form-component form-data)]])))

(defn old-sign-in-component [data owner]
  (om/component
   (html
    [:div.centered-content
     (when-not (get-in data keypaths/get-satisfaction-login?)
       [:div.page-heading.center "Sign In to Your Account"])
     [:div#existing-customer.new_spree_user
      (facebook/sign-in-button (get-in data keypaths/loaded-facebook))
      [:div.or-divider [:span "or"]]
      [:form.simple_form
       {:on-submit (utils/send-event-callback events/control-sign-in-submit)}
       [:div#password-credentials
        [:div.input.email
         [:label.email "Email"]
         [:input.string.email
          (merge (utils/change-text data owner keypaths/sign-in-email)
                 {:autofocus "autofocus"
                  :type "email"
                  :name "email"})]]
        [:div.input.password
         [:label.password "Password"]
         [:input.string.password
          (merge (utils/change-text data owner keypaths/sign-in-password)
                 {:type "password"
                  :name "password"})]]]
       [:p
        [:input#remember-me
         (merge (utils/change-checkbox data keypaths/sign-in-remember)
                {:type "checkbox"
                 :name "remember-me"})]
        [:label {:for "remember-me"} "Remember me"]]
       [:a.forgot-password (utils/route-to events/navigate-forgot-password) "Forgot Password?"]
       [:p
        [:input.button.primary {:type "submit"
                                :value "Login"}]]]]
     (when-not (get-in data keypaths/get-satisfaction-login?)
       [:p.center "Don't have an account? "
        [:a (utils/route-to events/navigate-sign-up) "Register Here"]])])))

(defn query [data]
  {:email (get-in data keypaths/sign-in-email)
   :password (get-in data keypaths/sign-in-password)
   :remember-me? (get-in data keypaths/sign-in-remember)
   :facebook-loaded? (get-in data keypaths/loaded-facebook)
   :get-satisfaction-login? (get-in data keypaths/get-satisfaction-login?)})

(defn sign-in-component [app-state owner]
  (om/component
   (html
    [:div
     (if (experiments/three-steps-redesign? app-state)
       (om/build redesigned-sign-in-component (query app-state))
       (om/build old-sign-in-component app-state))])))

(defn requires-sign-in [app-state authorized-component]
  (if (get-in app-state keypaths/user-id)
    authorized-component
    sign-in-component))

(defn redirect-getsat-component [data owner]
  (om/component
   (html
    [:div.centered-content
     ;; effects injects GetSat JS that will redirect / close this window as needed
     (if (or (nil? (get-in data keypaths/user))
             (get-in data keypaths/user-store-slug))
       [:div.page-heading.center "Signing in to the Mayvenn Stylist Community..."]
       [:div.flash.error
        "The Mayvenn Stylist Community is only for Mayvenn stylists. Become a stylist at welcome.mayvenn.com!"])])))
