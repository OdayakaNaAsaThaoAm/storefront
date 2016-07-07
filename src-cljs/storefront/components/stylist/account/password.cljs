(ns storefront.components.stylist.account.password
  (:require [storefront.component :as component]
            [storefront.components.ui :as ui]
            [storefront.events :as events]
            [storefront.keypaths :as keypaths]
            [storefront.platform.component-utils :as utils]
            [storefront.request-keys :as request-keys]))

(defn component [{:keys [password
                         confirmation
                         errors
                         saving?]} owner opts]
  (component/create
   [:form {:on-submit
           (utils/send-event-callback events/control-stylist-account-password-submit)}
    [:h1.h2.light.my3.center.col.col-12.md-up-col-6 "Update your password"]

    [:div.col.col-12.md-up-col-6
     (ui/text-field "New Password"
                    (conj keypaths/stylist-manage-account :user :password)
                    password
                    {:type      "password"
                     :name      "account-password"
                     :id        "account-password"
                     :data-test "account-password"
                     :errors (get errors [:stylist :user :password])})

     (ui/text-field "Re-type New Password"
                    (conj keypaths/stylist-manage-account :user :password-confirmation)
                    confirmation
                    {:type      "password"
                     :name      "account-password-confirmation"
                     :id        "account-password-confirmation"
                     :data-test "account-password-confirmation"
                     :errors (get errors [:stylist :user :password-confirmation])})]

    [:div.my2.col-12.clearfix
     ui/nbsp
     [:div.border-dark-white.border-top.to-md-hide.mb3]
     [:div.col-12.md-up-col-5.mx-auto
      (ui/submit-button "Update" {:spinning? saving?
                                  :data-test "account-form-submit"})]]]))

(defn query [data]
  {:saving?      (utils/requesting? data request-keys/update-stylist-account-password)
   :password     (get-in data (conj keypaths/stylist-manage-account :user :password))
   :confirmation (get-in data (conj keypaths/stylist-manage-account :user :password-confirmation))
   :errors       (get-in data keypaths/errors)})
