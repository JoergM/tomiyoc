(ns tomiyoc.view
  (:require [net.cgrand.enlive-html :as h])
  )


(def optionsliste
  ["Option 1" "Touch me if you can" "bLubberwasserprojekt" "Nummer 5 lebt"])

;; Template etc. für das Voting
(defn opt-snippet [o]
  {:tag :div, :attrs {:class "span12"},
   :content [{:tag :button, :attrs {:class "btn btn-danger btn-large btn-block"},
              :content o}]})

(h/deftemplate voting "templates/voting.html" [options]
  [:.opt ] (h/clone-for [o options]
             (h/content (opt-snippet o))))

(defn voting-screen [request]
  (voting optionsliste))