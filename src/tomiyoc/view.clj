(ns tomiyoc.view
  (:use tomiyoc.options)
  (:require [net.cgrand.enlive-html :as h])
  )

;; Template etc. für das Voting
(defn opt-snippet [o]
  {:tag :div, :attrs {:class "span12"},
   :content [{:tag :button, :attrs {:class "btn btn-danger btn-large btn-block"},
              :content o}]})

(h/deftemplate voting "templates/voting.html" []
  [:.opt ] (h/clone-for [o (vals voting-options)]
             (h/content (opt-snippet o))))

(defn voting-screen [request]
  (voting))
