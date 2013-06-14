(ns tomiyoc.options
  (:require [clojure.data.json :as json]))

(def voting-options
  {
    1 "Customizing Twitter Feed -- Sponsor:Martin Klewitz"
    2 "\"Digital Signage\" -- Sponsor: Ansgar Konermann"
    3 "Responsive EP2 Vorgangsmanagement -- Sponsor:Tobias Gesellchen"
    4 "Kenne den Markt  -- Sponsor: Volker Kultermann"
    5 "Voting-Terminal  -- Sponsor: Oliver Otzen"
    6 "Git Patch  -- Sponsor: Martin Kirst"
    7 "Integrator  -- Sponsor:Michael Grabow"
    8 "iKlo  -- Sponsor: René Häusler"
    })


(defn options-as-json-response [request]
  (json/write-str
    (for [k (keys voting-options)] {"id" k, "description" (voting-options k)})))