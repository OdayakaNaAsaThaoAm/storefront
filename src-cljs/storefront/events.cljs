(ns storefront.events)

(def app [:app])
(def app-start (conj app :start))
(def app-stop (conj app :stop))

(def navigate [:navigation])
(def navigate-home (conj navigate :home))
(def navigate-category (conj navigate :category))
(def navigate-product (conj navigate :product))
(def navigate-guarantee (conj navigate :guarantee))
(def navigate-help (conj navigate :help))
(def navigate-privacy (conj navigate :privacy))
(def navigate-tos (conj navigate :tos))
(def navigate-sign-in (conj navigate :sign-in))
(def navigate-sign-up (conj navigate :sign-up))
(def navigate-forgot-password (conj navigate :forgot-password))
(def navigate-reset-password (conj navigate :reset-password))
(def navigate-manage-account (conj navigate :manage-account))
(def navigate-account-addresses (conj navigate :account-addresses))
(def navigate-cart (conj navigate :cart))
(def navigate-order (conj navigate :order))
(def navigate-order-complete (conj navigate :order-complete))
(def navigate-my-orders (conj navigate :my-orders))
(def navigate-not-found (conj navigate :not-found))

(def navigate-stylist (conj navigate :stylist))
(def navigate-stylist-commissions (conj navigate-stylist :commissions))
(def navigate-stylist-referrals (conj navigate-stylist :referrals))
(def navigate-stylist-bonus-credit (conj navigate-stylist :bonus-credit))
(def navigate-stylist-manage-account (conj navigate-stylist :manage-account))

(def navigate-checkout (conj navigate :checkout))
(def navigate-checkout-address (conj navigate-checkout :address))
(def navigate-checkout-delivery (conj navigate-checkout :delivery))
(def navigate-checkout-payment (conj navigate-checkout :payment))
(def navigate-checkout-confirmation (conj navigate-checkout :confirmation))

(def stripe-success-create-token [:stripe-success-create-token])
(def stripe-failure-create-token [:stripe-failure-create-token])

(def control [:control])
(def control-change-state (conj control :change-state))

(def control-menu (conj control :menu))
(def control-menu-expand (conj control-menu :expand))
(def control-menu-collapse (conj control-menu :collapse))

(def control-sign-in (conj control :sign-in))
(def control-sign-in-submit (conj control-sign-in :submit))
(def control-sign-out (conj control :sign-out))
(def control-sign-up (conj control :sign-up))
(def control-sign-up-submit (conj control-sign-up :submit))
(def control-forgot-password (conj control :forgot-password))
(def control-forgot-password-submit (conj control-forgot-password :submit))
(def control-reset-password (conj control :reset-password))
(def control-reset-password-submit (conj control-reset-password :submit))
(def control-manage-account (conj control :manage-account))
(def control-manage-account-submit (conj control-manage-account :submit))

(def control-click (conj control :click))
(def control-click-category-product (conj control-click :category-product))

(def control-browse (conj control :browse))
(def control-browse-variant (conj control-browse :variant))
(def control-browse-variant-select (conj control-browse-variant :select))
(def control-browse-add-to-bag (conj control-browse :add-to-bag))

(def control-cart (conj control :cart))
(def control-cart-update-coupon (conj control-cart :update-coupon))
(def control-cart-line-item-inc (conj control-cart :line-item-inc))
(def control-cart-line-item-dec (conj control-cart :line-item-dec))
(def control-cart-line-item-set (conj control-cart :line-item-set))
(def control-cart-remove (conj control-cart :remove))

(def control-counter (conj control :counter))
(def control-counter-inc (conj control-browse-variant :inc))
(def control-counter-dec (conj control-browse-variant :dec))
(def control-counter-set (conj control-browse-variant :set))

(def control-checkout (conj control :checkout))
(def control-checkout-cart-submit (conj control-checkout :cart-submit))
(def control-checkout-update-addresses-submit (conj control-checkout :update-addresses))
(def control-checkout-shipping-method-select (conj control-checkout :shipping-method-select))
(def control-checkout-shipping-method-submit (conj control-checkout :shipping-method-submit))
(def control-checkout-payment-method-submit (conj control-checkout :payment-method-submit))
(def control-checkout-confirmation-submit (conj control-checkout :confirmation-submit))

(def control-stylist-profile-picture (conj control :stylist :profile-picture))

(def control-stylist-manage-account (conj control :stylist :manage-account))
(def control-stylist-manage-account-change (conj control-stylist-manage-account :change))
(def control-stylist-manage-account-submit (conj control-stylist-manage-account :submit))

(def api [:api])
(def api-start (conj api :start))
(def api-end (conj api :end))
(def api-abort (conj api :abort))

(def api-success (conj api :success))
(def api-success-cache (conj api-success :cache))

(def api-success-taxons (conj api-success :taxons))
(def api-success-store (conj api-success :store))
(def api-success-category (conj api-success :category))
(def api-success-products (conj api-success :products))
(def api-success-product (conj api-success :product))
(def api-success-states (conj api-success :states))
(def api-success-payment-methods (conj api-success :payment-methods))
(def api-success-sign-in (conj api-success :sign-in))
(def api-success-sign-up (conj api-success :sign-up))
(def api-success-forgot-password (conj api-success :forgot-password))
(def api-success-reset-password (conj api-success :reset-password))
(def api-success-address (conj api-success :address))
(def api-success-account (conj api-success :account))
(def api-success-manage-account (conj api-success :manage-account))
(def api-success-stylist-manage-account (conj api-success :stylist-manage-account))
(def api-success-stylist-manage-account-profile-picture
  (conj api-success-stylist-manage-account :profile-picture))
(def api-success-stylist-commissions (conj api-success :stylist-commissions))
(def api-success-stylist-bonus-credits (conj api-success :stylist-bonus-credits))
(def api-success-stylist-referral-program (conj api-success :stylist-referral-program))
(def api-success-create-order (conj api-success :create-order))
(def api-success-add-to-bag (conj api-success :add-to-bag))
(def api-success-get-order (conj api-success :order))
(def api-success-get-past-order (conj api-success :past-order))
(def api-success-sms-number (conj api-success :sms-number))

(def api-success-cart (conj api-success :cart))
(def api-success-cart-update (conj api-success-cart :update))
(def api-success-cart-update-checkout (conj api-success-cart-update :checkout))
(def api-success-cart-update-coupon (conj api-success-cart-update :coupon))

(def api-success-update-order (conj api-success :update-order))
(def api-success-update-order-update-address (conj api-success-update-order :update-address))
(def api-success-update-order-update-cart-payments (conj api-success-update-order :update-cart-payments))
(def api-success-update-order-add-promotion-code (conj api-success-update-order :add-promotion-code))
(def api-success-promotions (conj api-success :promotions))
(def api-success-my-orders (conj api-success :my-orders))

(def api-success-shipping-methods (conj api-success :shipping-methods))


(def api-failure (conj api :failure))
(def api-failure-no-network-connectivity (conj api-failure :no-network-connectivity))
(def api-failure-bad-server-response (conj api-failure :bad-server-response))
(def api-failure-validation-errors (conj api-failure :validation-errors))

(def flash [:flash])
(def flash-show (conj flash :show))
(def flash-dismiss (conj flash :dismiss))
(def flash-show-success (conj flash-show :success))
(def flash-dismiss-success (conj flash-dismiss :success))
(def flash-show-failure (conj flash-show :failure))
(def flash-dismiss-failure (conj flash-dismiss :failure))

(def added-to-bag [:added-to-bag])

(def optimizely [:optimizely])

(def reviews [:reviews])
(def reviews-inserted (conj reviews :inserted))
(def reviews-component-mounted (conj reviews :component-mounted))
(def reviews-component-will-unmount (conj reviews :component-will-unmount))
