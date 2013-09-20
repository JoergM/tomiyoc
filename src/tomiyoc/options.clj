(ns tomiyoc.options
  (:require [clojure.data.json :as json]))

(def voting-options
  {
    1 "Customizing Twitter Feed -- Martin Klewitz"
    2 "\"Digital Signage\" -- Ansgar Konermann"
    3 "Responsive EP2 VM -- Tobias Gesellchen"
    4 "Kenne den Markt -- Volker Kultermann"
    5 "Voting-Terminal -- Oliver Otzen"
    6 "Git Patch -- Martin Kirst"
    7 "Integrator -- Michael Grabow"
    8 "iKlo -- René Häusler"
    })


(defn options-as-json-response [request]
  (json/write-str
    (for [k (keys voting-options)] {"id" k, "description" (voting-options k)})))

