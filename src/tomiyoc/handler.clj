(ns tomiyoc.handler
  (:use [compojure.core]
        [tomiyoc.view]
        [tomiyoc.database]
        [tomiyoc.options]
        [ring.adapter.jetty :only (run-jetty)]
        [ring.util.response :only (resource-response)])
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [clojure.data.json :as json])
  (:gen-class ))

(defn save-vote-handler [option karte]
  (do (save-vote option karte)
    "SUCCESS"))

(defn resultdata [request]
  (let [values (get-summary)]
    (json/write-str {:data (for [o (keys voting-options)] {:data [[o,(get values o)]] :bars {:show true :barWidth 0.5}})
                     :ticks (for [k (keys voting-options)] [k (voting-options k)])
                     :max (max (vals values))
                     })))

;; Compojure Routes
(defroutes app-routes
  (GET "/voting" [] voting-screen)
  (GET "/optionslist" [] options-as-json-response)
  (GET "/savevote" {{option :option karte :karte} :params} (save-vote-handler option karte))
  (GET "/resultdata" [] resultdata)
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

;; Damit wird gestartet
(defn -main [& args]
  (do
    (init-db)
    (run-jetty #'app {:port 8080 :join? false})))

