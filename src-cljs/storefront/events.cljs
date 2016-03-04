(ns storefront.events)

(def app [:app])
(def app-start (conj app :start))
(def app-stop (conj app :stop))

(def domain [:domain])
(def order-completed (conj domain :order-completed))

(def external-redirect [:external-redirect])
(def external-redirect-community (conj external-redirect [:community]))
(def external-redirect-paypal-setup (conj external-redirect [:paypal-setup]))

(def navigate [:navigation])
(def navigate-home (conj navigate :home))
(def navigate-category (conj navigate :category))
(def navigate-categories (conj navigate :categories))
(def navigate-product (conj navigate :product))
(def navigate-guarantee (conj navigate :guarantee))
(def navigate-help (conj navigate :help))
(def navigate-privacy (conj navigate :privacy))
(def navigate-tos (conj navigate :tos))
(def navigate-sign-in (conj navigate :sign-in))
(def navigate-sign-in-getsat (conj navigate [:sign-in-getsat]))
(def navigate-sign-up (conj navigate :sign-up))
(def navigate-forgot-password (conj navigate :forgot-password))
(def navigate-reset-password (conj navigate :reset-password))
(def navigate-cart (conj navigate :cart))
(def navigate-order (conj navigate :order))

(def navigate-order-complete (conj navigate :order-complete))
(def navigate-not-found (conj navigate :not-found))

(def navigate-stylist (conj navigate :stylist))
(def navigate-stylist-commissions (conj navigate-stylist :commissions))
(def navigate-stylist-referrals (conj navigate-stylist :referrals))
(def navigate-stylist-bonus-credit (conj navigate-stylist :bonus-credit))
(def navigate-stylist-manage-account (conj navigate-stylist :manage-account))

(def navigate-account (conj navigate :account))
(def navigate-account-manage (conj navigate-account :manage))
(def navigate-account-referrals (conj navigate-account :referrals))

(def navigate-talkable (conj navigate :talkable))
(def navigate-friend-referrals (conj navigate-talkable :referrals))

(def navigate-checkout (conj navigate :checkout))
(def navigate-checkout-sign-in (conj navigate-checkout :sign-in))
(def navigate-checkout-address (conj navigate-checkout :address))
(def navigate-checkout-delivery (conj navigate-checkout :delivery))
(def navigate-checkout-payment (conj navigate-checkout :payment))
(def navigate-checkout-confirmation (conj navigate-checkout :confirmation))

(def stripe-success-create-token [:stripe-success-create-token])
(def stripe-failure-create-token [:stripe-failure-create-token])

(def control [:control])
(def control-change-state (conj control :change-state))

(def control-carousel-move (conj control :carousel-move))

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

(def control-facebook (conj control :facebook))
(def control-facebook-sign-in (conj control-facebook :sign-in))
(def control-facebook-reset (conj control-facebook :reset))

(def control-bundle-option-select (conj control :bundle :option-select))

(def control-browse (conj control :browse))
(def control-browse-variant (conj control-browse :variant))
(def control-browse-variant-select (conj control-browse-variant :select))
(def control-browse-add-to-bag (conj control-browse :add-to-bag))

(def control-build (conj control :build))
(def control-build-add-to-bag (conj control-build :add-to-bag))

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
(def control-checkout-as-guest-submit (conj control-checkout :guest-checkout-submit))
(def control-checkout-cart-submit (conj control-checkout :cart-submit))
(def control-checkout-cart-paypal-setup (conj control-checkout :cart-paypal-setup))
(def control-checkout-update-addresses-submit (conj control-checkout :update-addresses))
(def control-checkout-shipping-method-select (conj control-checkout :shipping-method-select))
(def control-checkout-shipping-method-submit (conj control-checkout :shipping-method-submit))
(def control-checkout-payment-method-submit (conj control-checkout :payment-method-submit))
(def control-checkout-remove-promotion (conj control-checkout :remove-promotion))
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
(def api-success-taxon-products (conj api-success :taxon-products))
(def api-success-product (conj api-success :product))
(def api-success-order-products (conj api-success :order-products))
(def api-success-states (conj api-success :states))
(def api-success-sign-in (conj api-success :sign-in))
(def api-success-sign-up (conj api-success :sign-up))
(def api-success-forgot-password (conj api-success :forgot-password))
(def api-success-reset-password (conj api-success :reset-password))

(def api-success-account (conj api-success :account))
(def api-success-manage-account (conj api-success :manage-account))
(def api-success-stylist-manage-account (conj api-success :stylist-manage-account))
(def api-success-stylist-manage-account-profile-picture
  (conj api-success-stylist-manage-account :profile-picture))
(def api-success-stylist-commissions (conj api-success :stylist-commissions))
(def api-success-stylist-bonus-credits (conj api-success :stylist-bonus-credits))
(def api-success-stylist-referral-program (conj api-success :stylist-referral-program))

(def api-success-add-to-bag (conj api-success :add-to-bag))
(def api-success-remove-from-bag (conj api-success :remove-from-bag))
(def api-success-get-order (conj api-success :order))
(def api-success-get-completed-order (conj api-success :completed-order))
(def api-success-get-past-order (conj api-success :past-order))
(def api-success-sms-number (conj api-success :sms-number))

(def api-success-update-order (conj api-success :update-order))
(def api-success-update-order-update-address (conj api-success-update-order :update-address))
(def api-success-update-order-update-cart-payments (conj api-success-update-order :update-cart-payments))
(def api-success-update-order-update-shipping-method (conj api-success-update-order :update-shipping-method))
(def api-success-update-order-modify-promotion-code (conj api-success-update-order :promotion-code))
(def api-success-update-order-add-promotion-code (conj api-success-update-order-modify-promotion-code :add))
(def api-success-update-order-remove-promotion-code (conj api-success-update-order-modify-promotion-code :remove))
(def api-success-update-order-place-order (conj api-success-update-order :place-order))
(def api-success-promotions (conj api-success :promotions))
(def api-success-my-orders (conj api-success :my-orders))

(def api-success-shipping-methods (conj api-success :shipping-methods))

(def api-failure (conj api :failure))
(def api-failure-no-network-connectivity (conj api-failure :no-network-connectivity))
(def api-failure-bad-server-response (conj api-failure :bad-server-response))
(def api-failure-validation-errors (conj api-failure :validation-errors))
(def api-failure-pending-promo-code (conj api-failure :pending-promo-code))

(def api-handle (conj api :handle))
(def api-handle-order-not-found (conj api-handle :order-not-found))

(def flash [:flash])
(def flash-show (conj flash :show))
(def flash-dismiss (conj flash :dismiss))
(def flash-show-success (conj flash-show :success))
(def flash-dismiss-success (conj flash-dismiss :success))
(def flash-show-failure (conj flash-show :failure))
(def flash-dismiss-failure (conj flash-dismiss :failure))

(def added-to-bag [:added-to-bag])

(def facebook [:facebook])
(def facebook-success-sign-in (conj facebook :success-sign-in))
(def facebook-success-reset (conj facebook :success-reset))
(def facebook-failure-sign-in (conj facebook :failure-sign-in))
(def facebook-email-denied (conj facebook :email-denied))

(def optimizely [:optimizely])

(def reviews [:reviews])
(def reviews-component-mounted (conj reviews :component-mounted))
(def reviews-component-will-unmount (conj reviews :component-will-unmount))

(def talkable [:talkable])
(def talkable-offer-shown (conj talkable [:offer-shown]))

(def inserted [:inserted])
(def inserted-places (conj inserted :places))
(def inserted-facebook (conj inserted :facebook))
(def inserted-stripe (conj inserted :stripe))
(def inserted-reviews (conj inserted :reviews))
(def inserted-fastpass (conj inserted :fastpass))
(def inserted-talkable (conj inserted :talkable))

(def autocomplete-update-address [:autocomplete-update-address])

(def checkout-address [:checkout-address])
(def checkout-address-place-changed (conj checkout-address :place-changed))
(def checkout-address-component-mounted (conj checkout-address :component-mounted))
(def checkout-address-component-updated (conj checkout-address :component-updated))
