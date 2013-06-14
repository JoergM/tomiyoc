(ns tomiyoc.options
  (:require [clojure.data.json :as json]))

(def voting-options
  {1 "Option 1"
   2 "Touch me if you can"
   3 "bLubberwasserprojekt"
   4 "Nummer 5 lebt"
   5 "Viel Spass"})

(defn options-as-json-response [request]
  (json/write-str
    (for [k (keys voting-options)] {"id" k, "description" (voting-options k)})))