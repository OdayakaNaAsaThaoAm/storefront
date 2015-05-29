(ns storefront.components.sign-up
  (:require [om.core :as om]
            [sablono.core :refer-macros [html]]
            [storefront.components.utils :as utils]
            [storefront.events :as events]
            [storefront.keypaths :as keypaths]))

(defn sign-up-component [data owner]
  (om/component
   (html
    [:div.centered-content
     [:h1.center "Sign Up For An Account"]
     [:p.center "Already have an account? "
      [:a (utils/route-to data events/navigate-sign-in) "Log In"]]
     [:div#existing-customer
      [:form.new_spree_user.simple_form
       {:on-submit (utils/enqueue-event data events/control-sign-up-submit)}
       [:div#password-credentials
        [:div.input.email
         [:label.email "Email"]
         [:input.string.email
          (merge (utils/change-text data keypaths/sign-up-email)
                 {:autofocus "autofocus"
                  :type "email"
                  :name "email"})]]
        [:div.input.password
         [:label.password "Password"]
         [:input.string.password
          (merge (utils/change-text data keypaths/sign-up-password)
                 {:type "password"
                  :name "password"})]]
        [:div.input.password
         [:label.password "Password Confirmation"]
         [:input.string.password
          (merge (utils/change-text data keypaths/sign-up-password-confirmation)
                 {:type "password"
                  :name "password-confirmation"})]]]
       [:p
        [:input.btn.button.primary {:type "submit"
                                    :value "Create"}]]]]])))
