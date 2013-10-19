(ns tomiyoc.options
  (:require [clojure.data.json :as json]))

(def voting-options
  {
    1 "ShitAppens"
    2 "FunkyFX"
    3 "Team - Sunspot"
    4 "Team of Life"
    })


(defn options-as-json-response [request]
  (json/write-str
    (for [k (keys voting-options)] {"id" k, "description" (voting-options k)})))
