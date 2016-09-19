(ns storefront.components.svg
  (:require #?(:clj [storefront.component-shim :as component]
               :cljs [storefront.component :as component])))

;; OPTIMIZATION TOOLS:
;; hiccup -> xml:           Let the browser do it... then delete the data-reactid's
;; svg -> optimized svg:    https://github.com/svg/svgo
;; xml -> hiccup:           http://html2hiccup.buttercloud.com/
;;                              WARNING: this tool works, but converts 'viewBox'
;;                              into 'viewbox', which is invalid SVG. Your SVG
;;                              will render, but will be the wrong size.
;; manual cleanup           remove title, if warranted
;;                          remove xmlns, assuming SVG will be rendered inline
;;                          remove width and height, if SVG will have adjustable size
;;                          use .stroke-x and .fill-x color classes, so SVGs
;;                            change with palette

(def micro-dollar-sign
  (component/html
   [:svg {:width "14" :height "13" :viewBox "0 0 14 13"}
    [:g.stroke-light-gray {:fill "none"}
     [:path {:d "M13 6.5c0 3.3-2.7 6-6 6s-6-2.7-6-6 2.7-6 6-6 6 2.7 6 6z"}]
     [:path {:d "M5.7 7.8c0 .72.58 1.3 1.3 1.3.72 0 1.3-.58 1.3-1.3 0-.72-.58-1.3-1.3-1.3-.72 0-1.3-.58-1.3-1.3 0-.72.58-1.3 1.3-1.3.72 0 1.3.58 1.3 1.3M7 3.1v6.8"}]]]))

(def large-dollar
  (component/html
   [:svg {:width "72" :height "72" :viewBox "0 0 72 72"}
    [:g.stroke-pure-white {:fill "none"}
     [:circle {:r "35" :cy "36" :cx "36"}]
     [:path {:d "M28.391 43.609A7.608 7.608 0 0 0 36 51.217 7.609 7.609 0 1 0 36 36a7.609 7.609 0 1 1 7.609-7.609M36 16.217v39.566"}]]]))

(def large-percent
  (component/html
   [:svg {:width "72" :height "72" :viewBox "0 0 72 72"}
    [:g.stroke-pure-white {:fill "none"}
     [:path {:d "M23.826 48.174l24.348-24.348M31.435 26.87a4.566 4.566 0 1 1-9.132-.002 4.566 4.566 0 0 1 9.132.002zM49.696 45.13a4.566 4.566 0 1 1-9.132 0 4.566 4.566 0 0 1 9.132 0z"}]
     [:path {:d "M71 36c0 19.33-15.67 35-35 35C16.672 71 1 55.33 1 36S16.672 1 36 1c19.33 0 35 15.67 35 35z"}]]]))

(def large-payout
  (component/html
   [:svg {:width "62" :height "60" :viewBox "0 0 62 60"}
    [:g.stroke-pure-white {:fill "none"}
     [:path {:d "M1 55.045h10.609V35.272H1v19.773zM11.609 52.41C39.457 61.635 30.174 61.635 62 45.817c-2.82-2.8-5.046-3.463-7.957-2.636l-11.76 3.878"}]
     [:path {:d "M11.609 37.91h7.956c6.24 0 10.609 3.954 11.935 5.272h7.957c4.226 0 4.226 5.273 0 5.273H24.87M36.804 8.91c0 4.368 3.562 7.908 7.957 7.908s7.956-3.54 7.956-7.909C52.717 4.541 49.156 1 44.761 1c-4.395 0-7.957 3.54-7.957 7.91zM24.87 27.364c0 4.368 3.561 7.909 7.956 7.909 4.395 0 7.957-3.54 7.957-7.91 0-4.368-3.562-7.908-7.957-7.908s-7.956 3.54-7.956 7.909zM32.371 24.727V30M44.571 6.273v5.272"}]]]))

(def large-mail
  (component/html
   [:svg {:width "44" :height "44" :viewBox "0 0 44 44"}
    [:path {:d "M15.148 20.519h15.437a.482.482 0 0 0 0-.963H15.148a.482.482 0 0 0 0 .963z"}]
    [:path {:d "M22 43.036c-6.36 0-12.066-2.841-15.927-7.317V25.626l15.61 13.658a.481.481 0 0 0 .634 0l15.609-13.658v10.095c-3.86 4.474-9.566 7.315-15.926 7.315zM.964 22C.964 10.4 10.4.964 22 .964 33.6.964 43.036 10.4 43.036 22c0 4.69-1.543 9.024-4.146 12.526v-9.961c0-.03-.008-.056-.012-.083a.475.475 0 0 0-.153-.418l-5.233-4.579a.472.472 0 0 0-.19-.098v-8.543c0-.58-.475-1.054-1.055-1.054H11.753c-.58 0-1.054.473-1.054 1.054v8.553a.474.474 0 0 0-.155.089L5.31 24.065a.476.476 0 0 0-.156.302l-.01.031a.466.466 0 0 0-.034.167v9.96A20.925 20.925 0 0 1 .964 22zM33.3 25.047h3.824l-3.824 3.346v-3.346zm0-4.449l3.983 3.486H33.3v-3.486zm-21.639 8.54V10.843c0-.048.042-.09.09-.09h20.494c.049 0 .091.042.091.09v18.06c0 .097.035.182.085.258L22 38.28l-10.355-9.06c.006-.028.017-.054.017-.084zm-.963-4.091v3.347l-3.825-3.347H10.7zm0-.963H6.752l3.947-3.454v3.454zm28.188 11.998A21.9 21.9 0 0 0 44 22C44 9.869 34.13 0 22 0S0 9.869 0 22a21.9 21.9 0 0 0 5.11 14.078v.08c0 .266.215.481.482.481h.004C9.627 41.151 15.486 44 22 44c6.564 0 12.462-2.894 16.496-7.467a.474.474 0 0 0 .39-.451z"}]
    [:path {:d "M31.066 27.86a.481.481 0 0 0-.481-.482H15.148a.481.481 0 1 0 0 .963h15.437a.482.482 0 0 0 .481-.482M15.148 24.43h15.437a.481.481 0 1 0 0-.963H15.148a.482.482 0 0 0 0 .963M15.63 16.279h9.205v-1.626H15.63v1.626zm-.072.963h9.348c.492 0 .891-.4.891-.892v-1.77c0-.49-.4-.891-.891-.891h-9.348c-.491 0-.891.4-.891.891v1.77c0 .492.4.892.891.892z"}]]))

(def phone-ringing
  (component/html
   [:svg {:width "30" :height "30" :viewBox "0 0 29 29"}
    [:g {:fill "none" :fill-rule "evenodd"}
     [:g.stroke-dark-black {:stroke-width "1.2"}
      [:path {:d "M18.754 18.161a.582.582 0 0 0-.807-.014s-1.652 1.605-1.762 1.705a.353.353 0 0 1-.09.065c-1.718.864-7.918-5.728-6.736-6.968l1.768-1.72a.572.572 0 0 0 .008-.812L5.35 4.559a.578.578 0 0 0-.818-.007c-2.897 2.824-7.54 5.664 3.308 16.652 10.706 10.843 13.775 6.734 16.73 3.578a.573.573 0 0 0-.01-.796l-5.806-5.825zM23.778 13.878c.157-4.717-3.706-8.545-8.448-8.39M27.874 13.878c.154-6.96-5.53-12.61-12.544-12.458M15.33 9.555c2.477-.162 4.516 1.864 4.353 4.323"}]]
     [:path {:d "M0 .266h29v28.8H0z"}]]]))

(def mail-envelope
  (component/html
   [:svg {:width "30" :height "30" :viewBox "0 0 30 24"}
    [:g {:fill "none" :fill-rule "evenodd"}
     [:g.stroke-dark-black {:stroke-width "1.25"}
      [:path {:d "M26.114 4.393l-9.909 8.91a2.037 2.037 0 0 1-2.687 0l-9.909-8.91M19.476 14.225l6.638 5.521M10.247 14.225L3.61 19.746"}]
      [:path {:d "M.625 4.306v15.527c0 1.58 1.281 2.86 2.928 2.86h22.885c1.646 0 2.937-1.28 2.937-2.86V4.306c0-1.58-1.29-2.863-2.937-2.863H3.553C1.906 1.443.625 2.726.625 4.306z"}]]
     [:path {:d "M0-2.932h30v30H0z"}]]]))

(def message
  (component/html
   [:svg {:width "30" :height "30" :viewBox "0 0 28 30"}
    [:g {:fill "none" :fill-rule "evenodd"}
     [:g.stroke-dark-black {:transform "translate(0 .268)" :stroke-width "1.184"}
      [:path {:d "M7.717 21.018C4.287 20.19.803 16.09.803 10.828c0-5.494 4.113-10.23 8.9-10.23h8.775c4.788 0 8.67 4.705 8.67 10.2 0 5.437-3.882 10.2-8.67 10.2h-2.764l-7.997 6.936v-6.916z"}]
      [:ellipse {:cx "7.915" :cy "10.69" :rx "1.851" :ry "1.943"}]
      [:ellipse {:cx "13.726" :cy "10.69" :rx "1.851" :ry "1.943"}]
      [:ellipse {:cx "19.537" :cy "10.69" :rx "1.851" :ry "1.943"}]]
     [:path {:d "M0 .266h28v28.8H0z"}]]]))

(defn adjustable-check [svg-options]
  [:svg (merge {:viewBox "0 0 14 14"} svg-options)
   [:g {:fill "none"
        :stroke-width ".5"
        :stroke-linecap "round"}
    [:path {:d "M9.61 5.17L5.7 8.83 4.39 7.52"}]
    [:circle {:r "6" :cx "7" :cy "7"}]]])

(defn bag [opts quantity]
  [:svg (merge {:width "25" :height "28" :viewBox "0 0 24 28"} opts)
   [:path {:class (if (pos? quantity) "fill-navy" "fill-black")
           :d "M17.31 9.772c.26 0 .498.216.498.498a.504.504 0 0 1-.498.498.49.49 0 0 1-.498-.498.49.49 0 0 1 .498-.498m-10.357 0a.49.49 0 0 1 .499.498.49.49 0 0 1-.499.498.504.504 0 0 1-.498-.498c0-.282.238-.498.498-.498M5.025 6.717h1.647V9.23c-.455.13-.78.542-.78 1.04 0 .585.476 1.083 1.061 1.083.607 0 1.084-.498 1.084-1.083 0-.498-.325-.91-.78-1.04V6.717h9.75V9.23c-.455.13-.78.542-.78 1.04 0 .585.476 1.083 1.083 1.083.585 0 1.062-.498 1.062-1.083 0-.498-.325-.91-.78-1.04V6.717h1.646c1.409 0 2.687 1.17 2.839 2.556l1.581 13.65c.173 1.408-.78 2.492-2.188 2.492H2.793c-1.408 0-2.361-1.084-2.21-2.492l1.582-13.65c.173-1.386 1.452-2.556 2.86-2.556M12.132.585a4.873 4.873 0 0 1 4.875 4.897v.671h-9.75v-.671A4.873 4.873 0 0 1 12.132.585m0-.585c-3.012 0-5.46 2.448-5.46 5.482v.671H5.025c-1.712 0-3.228 1.344-3.423 3.055L.02 22.858C-.175 24.57 1.082 26 2.793 26H21.47c1.711 0 2.968-1.43 2.773-3.142l-1.581-13.65c-.195-1.711-1.712-3.055-3.424-3.055h-1.646v-.671c0-3.034-2.449-5.482-5.46-5.482"}]])

(def counter-inc
  (component/html
   [:svg {:width "1.2em" :height "1.2em" :viewBox "0 0 49 49" :title "Increment cart item count"}
    [:circle {:r "24" :cy "24" :cx "24"}]
    [:g.stroke-pure-white {:stroke-width "4"} [:path {:d "M24 8v32M8 24h32"}]]]))

(def counter-dec
  (component/html
   [:svg.stroke-pure-white {:width "1.2em" :height "1.2em" :viewBox "0 0 49 49" :title "Decrement cart item count"}
    [:circle {:r "24" :cy "24" :cx "24"}]
    [:path {:stroke-width "4" :d "M9 24h30"}]]))

(def instagram
  (component/html
   [:svg {:viewBox "0 0 512 512"}
    [:path {:d "M256 49.471c67.266 0 75.233.257 101.8 1.469 24.562 1.121 37.9 5.224 46.778 8.674a78.052 78.052 0 0 1 28.966 18.845 78.052 78.052 0 0 1 18.845 28.966c3.45 8.877 7.554 22.216 8.674 46.778 1.212 26.565 1.469 34.532 1.469 101.8s-.257 75.233-1.469 101.8c-1.121 24.562-5.225 37.9-8.674 46.778a83.427 83.427 0 0 1-47.811 47.811c-8.877 3.45-22.216 7.554-46.778 8.674-26.56 1.212-34.527 1.469-101.8 1.469s-75.237-.257-101.8-1.469c-24.562-1.121-37.9-5.225-46.778-8.674a78.051 78.051 0 0 1-28.966-18.845 78.053 78.053 0 0 1-18.845-28.966c-3.45-8.877-7.554-22.216-8.674-46.778-1.212-26.564-1.469-34.532-1.469-101.8s.257-75.233 1.469-101.8c1.121-24.562 5.224-37.9 8.674-46.778a78.052 78.052 0 0 1 18.847-28.967 78.053 78.053 0 0 1 28.966-18.845c8.877-3.45 22.216-7.554 46.778-8.674 26.565-1.212 34.532-1.469 101.8-1.469m0-45.391c-68.418 0-77 .29-103.866 1.516-26.815 1.224-45.127 5.482-61.151 11.71a123.488 123.488 0 0 0-44.62 29.057A123.488 123.488 0 0 0 17.3 90.982c-6.223 16.025-10.481 34.337-11.7 61.152C4.369 179 4.079 187.582 4.079 256s.29 77 1.521 103.866c1.224 26.815 5.482 45.127 11.71 61.151a123.489 123.489 0 0 0 29.057 44.62 123.486 123.486 0 0 0 44.62 29.057c16.025 6.228 34.337 10.486 61.151 11.71 26.87 1.226 35.449 1.516 103.866 1.516s77-.29 103.866-1.516c26.815-1.224 45.127-5.482 61.151-11.71a128.817 128.817 0 0 0 73.677-73.677c6.228-16.025 10.486-34.337 11.71-61.151 1.226-26.87 1.516-35.449 1.516-103.866s-.29-77-1.516-103.866c-1.224-26.815-5.482-45.127-11.71-61.151a123.486 123.486 0 0 0-29.057-44.62A123.487 123.487 0 0 0 421.018 17.3c-16.025-6.223-34.337-10.481-61.152-11.7C333 4.369 324.418 4.079 256 4.079z"}]
    [:path {:d "M256 126.635A129.365 129.365 0 1 0 385.365 256 129.365 129.365 0 0 0 256 126.635zm0 213.338A83.973 83.973 0 1 1 339.974 256 83.974 83.974 0 0 1 256 339.973z"}]
    [:circle {:cx "390.476" :cy "121.524" :r "30.23"}]]))

(def styleseat
  (component/html
   [:svg {:viewBox "0 0 102 91"}
    [:path {:d "M49.586 90.024C44.198 67.636 24.042 51 0 51 0 22.833 22.833 0 51 0s51 22.833 51 51c-24.042 0-44.198 16.636-49.586 39.024a41.787 41.787 0 0 0-2.828 0z" :fill-rule "evenodd"}]]))

(def facebook
  (component/html
   [:svg {:width "11" :height "23" :viewBox "0 0 11 23"}
    [:path.fill-dark-black {:d "M2.355 4.692v3.27H0v4h2.355v10.974h4.837V11.962h3.246s.304-1.918.452-4.015H7.21V5.213c0-.408.53-.957 1.05-.957h2.636V.09H7.31c-5.076 0-4.956 4.004-4.956 4.6" :fill-rule "evenodd"}]]))

(def twitter
  (component/html
   [:svg {:width "25" :height "21" :viewBox "0 0 25 21"}
    [:path.fill-dark-black {:d "M22.088 3.258A5.064 5.064 0 0 0 24.305.46a10.087 10.087 0 0 1-3.203 1.227A5.038 5.038 0 0 0 17.42.091 5.053 5.053 0 0 0 12.505 6.3a14.319 14.319 0 0 1-10.4-5.283 5.048 5.048 0 0 0-.684 2.542c0 1.754.892 3.3 2.246 4.209a5.017 5.017 0 0 1-2.286-.633v.063c0 2.45 1.74 4.493 4.048 4.959a5.05 5.05 0 0 1-2.28.085 5.054 5.054 0 0 0 4.714 3.512 10.118 10.118 0 0 1-6.266 2.164c-.407 0-.81-.024-1.204-.07a14.268 14.268 0 0 0 7.734 2.271c9.28 0 14.355-7.703 14.355-14.385 0-.219-.004-.438-.014-.654a10.252 10.252 0 0 0 2.517-2.619 9.999 9.999 0 0 1-2.897.797z" :fill-rule "evenodd"}]]))

(def pinterest
  (component/html
   [:svg {:width "18" :height "23" :viewBox "0 0 18 23"}
    [:path.fill-dark-black {:d "M9.402.068C3.198.068.068 4.526.068 8.242c0 2.251.85 4.253 2.674 5 .3.123.568.004.654-.328.06-.23.204-.81.267-1.05.088-.328.054-.443-.188-.73-.526-.62-.862-1.427-.862-2.566 0-3.307 2.468-6.267 6.43-6.267 3.506 0 5.433 2.147 5.433 5.015 0 3.774-1.665 6.958-4.14 6.958-1.366 0-2.387-1.132-2.06-2.521.392-1.658 1.15-3.447 1.15-4.644 0-1.071-.571-1.964-1.758-1.964-1.398 0-2.52 1.447-2.52 3.388 0 1.233.417 2.07.417 2.07l-1.68 7.13c-.498 2.117-.075 4.711-.039 4.974.021.155.22.19.31.074.13-.168 1.791-2.226 2.359-4.282.159-.582.917-3.597.917-3.597.455.867 1.78 1.631 3.191 1.631 4.198 0 7.046-3.836 7.046-8.969 0-3.881-3.28-7.496-8.267-7.496" :fill-rule "evenodd"}]]))

(defn missing-profile-picture [svg-options]
  [:svg (merge {:viewBox "0 0 96 96"} svg-options)
   [:g {:fill "none" :fill-rule "evenodd"}
    [:circle.fill-white {:cx "48" :cy "48" :r "48"}]
    [:path.fill-teal {:d "M60.536 15.412c3.41 18.953-45.664 28.4-25.533 63.116-11.835-33.441 35.824-45.056 25.533-63.116m-1.672-5.616c8.554 5.425 8.104 13.847 2.25 21.506-6.495 8.615-16.207 15.444-21.352 24.953-6.11 11.296-6.174 29.93 12.285 29.612-6.56-.128-10.162-3.893-11.705-7.786-6.69-17.358 17.943-33.185 24.76-46.27 4.503-8.677 5.789-15.888-6.238-22.015M28.636 59.638c-.58-6.957 2.894-12.827 7.396-17.421 6.626-6.831 15.757-13.021 18.651-17.679-12.412 10.401-31.384 13.21-26.047 35.1"}]]])

(def play-video
  (component/html
   [:svg {:width "64" :height "64" :viewBox "0 0 64 64"}
    [:g {:fill "none" :fill-rule "evenodd"}
     [:circle.fill-light-silver {:cx "32" :cy "32" :r "32"}]
     [:path.fill-dark-silver {:d "M22 44V20l24 12z"}]]]))

(defn guarantee [svg-options]
  [:svg (merge {:viewBox "0 0 154 155"}
               svg-options)
   [:defs
    [:path {:id "a" :d "M152.733 153.983V.566H0v153.417z"}]
    [:path {:id "c" :d "M12.197.708c-1.716.473-3.3 1.17-4.75 2.093a14.717 14.717 0 0 0-3.77 3.449c-1.062 1.375-1.859 2.985-2.39 4.831l9.561 2.217c.328-1.478 1.032-2.658 2.115-3.54 1.083-.882 2.36-1.324 3.831-1.324 1.43 0 2.697.413 3.8 1.238 1.104.827 1.655 2.025 1.655 3.593 0 1.074-.215 1.942-.642 2.602a4.72 4.72 0 0 1-1.718 1.58c-.715.393-1.522.66-2.42.806-.9.144-1.84.215-2.82.215h-3.003v7.51h2.758c1.062 0 2.124.094 3.187.278 1.062.184 2.012.492 2.85.923a5.453 5.453 0 0 1 2.023 1.755c.51.739.766 1.662.766 2.77 0 1.026-.194 1.888-.582 2.586a5.178 5.178 0 0 1-1.471 1.693 6.116 6.116 0 0 1-2.023.953 8.47 8.47 0 0 1-2.238.309c-1.961 0-3.575-.544-4.841-1.632-1.267-1.088-2.105-2.349-2.513-3.785L0 34.35c.572 2.053 1.43 3.807 2.574 5.263a14.788 14.788 0 0 0 4.016 3.571c1.532.923 3.227 1.61 5.086 2.062 1.859.45 3.77.678 5.732.678 2.001 0 3.972-.278 5.913-.83 1.94-.553 3.688-1.393 5.241-2.52 1.553-1.128 2.81-2.562 3.77-4.304.96-1.742 1.44-3.8 1.44-6.178 0-1.23-.205-2.388-.613-3.473a10.15 10.15 0 0 0-1.716-2.951 10.915 10.915 0 0 0-2.635-2.275 11.164 11.164 0 0 0-3.371-1.384v-.184c2.123-.575 3.87-1.696 5.24-3.36 1.368-1.665 2.052-3.71 2.052-6.135 0-2.096-.439-3.915-1.316-5.455a12.033 12.033 0 0 0-3.464-3.854C26.52 1.994 24.893 1.234 23.076.74A21.323 21.323 0 0 0 17.468 0c-1.798 0-3.554.237-5.271.708z"}]
    [:path {:id "e" :d "M9.194 1.847a15.364 15.364 0 0 0-5.303 4.956C2.522 8.876 1.533 11.297.92 14.068.306 16.838 0 19.76 0 22.838c0 3.08.306 6.014.92 8.804.613 2.791 1.602 5.243 2.971 7.356a15.424 15.424 0 0 0 5.303 5.049c2.165 1.251 4.78 1.878 7.845 1.878 3.065 0 5.67-.627 7.815-1.878a15.241 15.241 0 0 0 5.24-5.049c1.35-2.113 2.33-4.565 2.943-7.356.612-2.79.919-5.724.919-8.803 0-3.078-.307-6.002-.919-8.771-.613-2.771-1.594-5.192-2.942-7.265a15.177 15.177 0 0 0-5.241-4.956C22.708.616 20.104 0 17.039 0c-3.065 0-5.68.616-7.845 1.847zm4.536 33.766c-.858-.963-1.524-2.155-1.993-3.57-.47-1.417-.787-2.955-.95-4.618a46.737 46.737 0 0 1-.244-4.586c0-1.354.08-2.852.245-4.493.162-1.642.48-3.171.949-4.587.47-1.416 1.135-2.606 1.993-3.57.857-.964 1.96-1.447 3.31-1.447 1.348 0 2.44.483 3.279 1.447.836.964 1.48 2.154 1.93 3.57.45 1.416.755 2.945.92 4.587.162 1.641.245 3.14.245 4.493a47.35 47.35 0 0 1-.246 4.586c-.164 1.663-.47 3.201-.919 4.618-.45 1.415-1.094 2.607-1.93 3.57-.839.965-1.931 1.446-3.28 1.446-1.348 0-2.452-.481-3.309-1.446z"}]]
   [:g {:fill "none" :fill-rule "evenodd"}
    [:path.fill-teal {:d "M76.516 25.11c-28.92 0-52.446 23.634-52.446 52.684 0 29.05 23.527 52.683 52.446 52.683 28.921 0 52.449-23.633 52.449-52.683S105.437 25.11 76.515 25.11m0 107.092c-29.866 0-54.162-24.407-54.162-54.408 0-30 24.296-54.409 54.163-54.409 29.867 0 54.165 24.408 54.165 54.409 0 30.001-24.298 54.408-54.165 54.408"}]
    [:g {:transform "translate(.353 .385)"}
     [:mask.fill-pure-white {:id "b"}
      [:use {:xlinkHref "#a"}]]
     [:path.fill-teal {:mask "url(#b)" :d "M76.367 2.371c-41.118 0-74.57 33.601-74.57 74.903 0 41.302 33.452 74.904 74.57 74.904 41.117 0 74.57-33.602 74.57-74.904S117.483 2.371 76.366 2.371m0 151.612C34.258 153.983 0 119.572 0 77.274 0 34.977 34.258.566 76.367.566c42.108 0 76.366 34.411 76.366 76.708 0 42.298-34.258 76.709-76.366 76.709"}]]
    [:path.fill-teal {:d "M24.36 114.793l.087-.073c2.309-1.96 5.312-1.745 7.226.532 1.4 1.666 1.887 3.79.206 5.57l-1.218-1.449c.884-1.047.742-2.121-.108-3.135-1.283-1.524-3.152-1.45-4.854-.006l-.087.073c-1.66 1.407-2.148 3.146-.775 4.78 1.227 1.46 2.61 1.314 3.72.447l-1.649-1.961 1.085-.92 2.847 3.388-.715.607c-2.149 1.82-4.584 1.573-6.434-.627-2.097-2.494-1.62-5.286.668-7.226M35.306 128.486l3.703-5.101 1.537 1.125-3.62 4.987c-1.096 1.508-1.065 2.483.15 3.373 1.181.865 2.161.772 3.4-.932l3.544-4.883 1.536 1.124-3.637 5.01c-1.563 2.153-3.583 2.492-5.749.904-2.052-1.502-2.403-3.488-.864-5.607M49.66 137.008l2.752 1.194.502-4.943-3.253 3.75zm2.836-5.623l2.27.985-.95 10.699-1.8-.78.254-2.641-3.56-1.545-1.726 2.002-1.631-.707 7.143-8.013zM64.699 140.649c1.241.233 1.996-.178 2.193-1.242l.01-.056c.214-1.149-.425-1.674-1.61-1.897l-1.493-.28-.593 3.195 1.493.28zm-2.487-5.264l3.347.626c2.19.41 3.558 1.594 3.18 3.64l-.012.056c-.291 1.57-1.415 2.184-2.717 2.275l2.001 4.854-2.008-.377-1.858-4.536-1.186-.223-.751 4.05-1.855-.348 1.859-10.017zM77.225 142.765l2.992-.104-1.652-4.677-1.34 4.78zm.167-6.294l2.466-.086 3.698 10.067-1.957.068-.895-2.493-3.872.134-.706 2.55-1.773.061 3.039-10.301zM88.353 135.584l2.177-.601 6.069 5.969-1.949-7.109 1.656-.458 2.696 9.831-1.89.522-6.474-6.315 2.066 7.534-1.656.459zM104.548 131.93l-2.498 1.328-.697-1.323 6.677-3.55.696 1.324-2.497 1.327 4.053 7.689-1.683.894zM111.353 125.405l4.925-4.02.94 1.162-3.46 2.823 1.755 2.17 2.777-2.266.895 1.106-2.776 2.266 1.87 2.313 3.648-2.977.94 1.163-5.112 4.172zM120.353 117.286l4.053-4.901 1.146.956-2.847 3.443 2.14 1.785 2.285-2.763 1.091.91-2.284 2.764 2.281 1.903 3.001-3.629 1.147.957-4.207 5.087zM24.634 43.485l1.089-1.461c.895.512 1.823.694 2.852-.687.672-.902.65-1.917-.101-2.481-.75-.564-1.316-.401-2.518.761-1.715 1.755-2.996 2.236-4.518 1.09-1.33-.998-1.48-2.892-.212-4.592 1.31-1.758 2.887-2.21 4.564-1.2l-1.038 1.393c-.964-.493-1.692-.275-2.39.661-.689.924-.603 1.737.022 2.207.659.495 1.193.469 2.452-.792 1.69-1.722 2.975-2.305 4.601-1.083 1.41 1.06 1.619 3.086.275 4.89-1.66 2.225-3.458 2.333-5.078 1.294M33.333 31.94l2.192-2.047-4.298-2.448 2.106 4.496zm-3.98-4.867l1.809-1.688 9.361 5.176-1.435 1.34-2.303-1.296-2.838 2.65 1.128 2.39-1.3 1.214-4.422-9.786zM38.529 21.247l-2.355 1.562-.821-1.25 6.3-4.174.82 1.249-2.357 1.562 4.766 7.254-1.587 1.051zM46.353 15.211l1.715-.826 4.387 9.188-1.714.826zM54.462 19.637l1.734-.548c.428.941 1.077 1.633 2.715 1.115 1.07-.337 1.642-1.176 1.361-2.074-.28-.897-.835-1.097-2.487-.858-2.414.418-3.733.058-4.304-1.765-.498-1.592.482-3.218 2.5-3.855 2.086-.66 3.63-.1 4.404 1.704l-1.653.521c-.496-.964-1.214-1.215-2.325-.865-1.097.347-1.5 1.057-1.266 1.805.248.79.696 1.081 2.453.796 2.372-.406 3.755-.125 4.365 1.82.528 1.687-.481 3.456-2.622 4.132-2.641.834-4.165-.135-4.875-1.928M64.353 9.22l6.23-.835.2 1.498-4.36.585.4 3.008 3.43-.46.194 1.455-3.432.46.55 4.14-1.87.25zM77.485 14.66l2.995.095-1.341-4.78-1.654 4.685zm.58-6.275l2.47.078 3.03 10.3-1.959-.062-.729-2.55-3.876-.122-.874 2.499-1.774-.056 3.713-10.087zM86.533 13.618l.025-.111c.67-2.99 3.188-4.613 5.944-3.99 2.271.514 3.774 2.052 3.472 4.44l-1.87-.424c.09-1.369-.493-2.216-1.919-2.539-1.745-.394-3.186.711-3.685 2.937l-.025.112c-.502 2.24.268 3.802 2.096 4.215 1.37.31 2.496-.166 3.004-1.527l1.801.407c-.827 2.326-2.789 3.154-5.142 2.622-3.102-.702-4.388-3.083-3.7-6.142M102.779 14.883l-2.595-1.123.59-1.375 6.937 3.002-.59 1.375-2.594-1.123-3.427 7.989-1.747-.756zM111.599 17.385l1.63.988-5.246 8.731-1.63-.988zM120.009 30.755l.073-.087c1.353-1.597 1.468-3.539-.046-4.832-1.514-1.294-3.36-.941-4.776.732l-.074.086c-1.434 1.695-1.336 3.67.07 4.87 1.46 1.248 3.327.914 4.753-.77m-6.334-5.374l.072-.086c1.923-2.27 4.972-2.568 7.265-.61 2.303 1.968 2.504 4.966.572 7.247l-.073.088c-1.923 2.27-4.913 2.655-7.261.65-2.369-2.024-2.471-5.05-.575-7.289M129.407 32.385l1.373 1.798-3.224 7.89 5.823-4.484 1.045 1.369-8.053 6.2-1.193-1.56 3.393-8.396-6.172 4.753-1.046-1.369z"}]
    [:g {:transform "translate(41.1 47.856)"}
     [:mask.fill-pure-white {:id "d"}
      [:use {:xlinkHref "#c"}]]
     [:path.fill-teal {:mask "url(#d)" :d "M-3 49.026h38.852V-2H-3z"}]]
    [:g {:transform "translate(78.956 47.856)"}
     [:mask.fill-pure-white {:id "f"}
      [:use {:xlinkHref "#e"}]]
     [:path.fill-teal {:mask "url(#f)" :d "M-3 49.026h39.036V-2H-3z"}]]
    [:g.fill-teal
     [:path {:d "M60.28 110.642c3.178 0 4.767-1.909 4.767-4.944v-.139c0-2.862-1.382-4.874-4.785-4.874h-1.674v9.957h1.692zM57.085 99.47h3.264c4.248 0 6.253 2.637 6.253 6.09v.155c0 3.434-1.97 6.159-6.288 6.159h-3.23V99.47zM75.107 107.103h4.283l-2.142-6.384-2.141 6.384zm1.226-7.633h1.969l4.18 12.404h-1.485l-1.21-3.574h-5.094l-1.192 3.574h-1.416l4.248-12.404zM92.212 106.46l-4.127-6.99h1.692l3.23 5.759 3.108-5.759h1.503l-3.903 7.008v5.395h-1.503zM6.085 79.204l4.134-.838 1.656-3.896 2.071 3.69 4.201.379-2.854 3.118.94 4.13-3.835-1.763-3.62 2.174.484-4.208zM148.147 79.204l-4.133-.838-1.658-3.896-2.07 3.69-4.201.379 2.854 3.118-.94 4.13 3.835-1.763 3.62 2.174-.484-4.208z"}]]]])
