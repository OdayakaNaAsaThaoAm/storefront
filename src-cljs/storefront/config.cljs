(ns storefront.config)

(def environment js/environment)
(def development? (= js/environment "development"))

(def api-base-url js/apiUrl)

(def send-sonar-base-url "https://www.sendsonar.com/api/v1")
(def send-sonar-publishable-key "d7d8f2d0-9f91-4507-bc82-137586d41ab8")

(def review-tag-url (case js/environment
                      "production" "//staticw2.yotpo.com/ZmvkoIuVo61VsbHVPaqDPZpkfGm6Ce2kjVmSqFw9/widget.js"
                      "//staticw2.yotpo.com/2UyuTzecYoIe4JECHCuqP6ClAOzjnodSFMc7GEuT/widget.js"))

(def honeybadger-api-key "b0a4a070")

(def optimizely-app-id (case js/environment
                         "production" 592210561
                         3156430062))

(def canonical-image (if development?
                       js/canonicalImage
                       (str "http:" js/canonicalImage)))

(def google-analytics-property (case js/environment
                                 "production" "UA-36226630-1"
                                 "UA-36226630-2"))

(def stripe-publishable-key (case js/environment
                              "production" "pk_live_S8NS2f14rDQz9USq5Gu9qBnR"
                              "pk_test_cc749q2i3rIK5Kvhbtesy1Iu"))

(def facebook-app-id (case js/environment
                       "production" 1536288310021691
                       1536578859992636))
