(ns storefront.components.forgot-password
  (:require [om.core :as om]
            [sablono.core :refer-macros [html]]
            [storefront.components.utils :as utils]
            [storefront.events :as events]
            [storefront.keypaths :as keypaths]))

(defn forgot-password-component [data owner]
  (om/component
   (html
    [:div
     [:h2.header-bar-heading "Reset Your Forgotten Password"]
     [:div#forgot-password
      [:form.new_spree_user
       {:on-submit (utils/enqueue-event data events/control-forgot-password-submit)}
       [:label {:for "spree_user_email"} "Enter your email:"]
       [:br]
       [:input
        (merge
         (utils/change-text data keypaths/forgot-password-email)
         {:type "email"
          :name "email"})]
       [:p
        [:input.button.primary {:type "submit" :value "Reset my password"}]]]]])))
