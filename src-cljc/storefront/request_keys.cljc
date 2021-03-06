(ns storefront.request-keys)

(def get-promotions [:get-promotions])
(def get-products [:get-products])
(def get-states [:get-states])
(def get-saved-cards [:get-saved-cards])
(def get-static-content [:get-static-content])
(def search-v2-products [:search-v2-products])
(def search-v2-skus [:search-v2-skus])

(def sign-out [:sign-out])
(def sign-in [:sign-in])
(def one-time-sign-in [:one-time-sign-in])
(def sign-up [:sign-up])
(def facebook-sign-in [:facebook-sign-in])
(def reset-facebook [:reset-facebook])
(def forgot-password [:forgot-password])
(def reset-password [:reset-password])
(def get-account [:get-account])
(def update-account [:update-account])
(def update-account-profile [:update-account-profile])

(def get-stylist-account [:get-stylist-account])
(def refresh-stylist-portrait [:refresh-stylist-portrait])
(def update-stylist-account [:update-stylist-account])
(def update-stylist-account-profile [:update-stylist-account-profile])
(def update-stylist-account-password [:update-stylist-account-password])
(def update-stylist-account-commission [:update-stylist-account-commission])
(def update-stylist-account-social [:update-stylist-account-social])
(def update-stylist-account-portrait [:update-stylist-account-portrait])
(def append-gallery [:append-gallery])
(def get-stylist-stats [:get-stylist-stats])
(def get-stylist-earnings [:get-stylist-earnings])
(def get-stylist-balance-transfers [:get-stylist-balance-tranfers])
(def get-stylist-balance-transfer [:get-stylist-balance-tranfer])
(def get-stylist-next-payout [:get-stylist-next-payout])
(def get-stylist-commission [:get-stylist-commission])
(def get-stylist-bonus-credits [:get-stylist-bonus-credits])
(def get-stylist-referral-program [:get-stylist-referral-program])
(def cash-out-now [:cash-out-now])
(def cash-out-status [:cash-out-status])
(def get-gallery [:get-gallery])
(def delete-gallery-image [:delete-gallery-image])

(def get-shipping-methods [:shipping-methods])

(def update-cart [:update-cart])
(def update-line-item [:update-line-item])
(def delete-line-item [:delete-line-item])
(def update-order [:update-order])
(def update-addresses [:update-addresses])
(def update-shipping-method [:update-shipping-method])
(def update-cart-payments [:update-cart-payments])
(def add-promotion-code [:add-promo-code])
(def remove-promotion-code [:remove-promo-code])
(def get-order [:get-order])
(def add-to-bag [:add-to-bag])
(def place-order [:place-order])
(def affirm-place-order [:affirm-place-order])
(def checkout [:checkout])
(def send-referrals [:send-referrals])
(def create-shared-cart [:create-shared-cart])
(def fetch-shared-cart [:fetch-shared-cart])
(def create-order-from-shared-cart [:create-order-from-shared-cart])

(def stripe-create-token [:stripe-create-token])
(def stripe-apple-pay-availability [:stripe-apple-pay-availability])

(def login-telligent [:login-telligent])

(def create-lead [:create-lead])
(def advance-lead [:advance-lead])
