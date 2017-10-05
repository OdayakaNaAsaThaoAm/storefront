(ns storefront.browser.scroll
  (:require [goog.object :as object]
            [goog.dom.classlist :as classlist]))

(def scroll-target (.. js/document -body -parentElement))

(defn animate [el end-event start-fn end-fn]
  (letfn [(listener [e]
            (end-fn e)
            (classlist/remove scroll-target "animating")
            (.removeEventListener el end-event listener))]
    (classlist/add scroll-target "animating")
    (start-fn)
    (.addEventListener el end-event listener)))

(defn set-scroll-top
  [elem y] (set! (.. elem -scrollTop) y))

(defn scroll-to-y
  [elem y] (set-scroll-top elem y))

(defn snap-to [y]
  ;; NodeList is not seqable
  (let [elements (js/document.querySelectorAll "[data-snap-to=top]")]
    (dotimes [i (.-length elements)]
      (set-scroll-top (aget elements i) y))))

(defn snap-to-top []
  (snap-to 0))

(defn scroll-to [dest]
  (let [current-y (.. scroll-target -scrollTop)
        dy (- dest current-y)]
    (prn "y" current-y "dest" dest)
    (animate
     scroll-target
     "transitionend"
     #(do
        (set! (.. scroll-target -style -marginTop) (str dy "px"))
        (scroll-to-y scroll-target dest)
        (set! (.. scroll-target -style -transition) "margin-top 1s ease")
        (set! (.. scroll-target -style -marginTop) 0)
        )
     #(when (= (.-target %) (.-currentTarget %))
        (set! (.. scroll-target -style -transition) "none")))))

(def scroll-padding 35.0)
;; TODO: rename
(defn scroll-to-elem [el]
  (let [scroll-top (.. scroll-target -scrollTop)
        el-bottom (object/get (.getBoundingClientRect el) "bottom")
        window-height js/window.innerHeight]
    (when (> el-bottom window-height)
      (scroll-to (- (+ scroll-top el-bottom scroll-padding)
                    window-height)))))

(defn scroll-elem-to-top [el]
  (let [el-top (object/get (.getBoundingClientRect el) "top")
        scroll-top     (.. scroll-target -scrollTop)]
    (scroll-to (+ scroll-top el-top (- scroll-padding)))))

(defn scroll-selector-to-top [selector]
  (when-let [el (.querySelector js/document selector)]
    (scroll-elem-to-top el)))

