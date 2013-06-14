(ns tomiyoc.handler
  (:use [compojure.core]
        [tomiyoc.view]
        [tomiyoc.database]
        [tomiyoc.options]
        [ring.adapter.jetty :only (run-jetty)]
        [ring.util.response :only (resource-response)])
  (:require [compojure.handler :as handler]
            [compojure.route :as route])
  (:gen-class ))

;; Compojure Routes
(defroutes app-routes
  (GET "/voting" [] voting-screen)
  (GET "/optionslist" [] options-as-json-response)
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

;; Damit wird gestartet
(defn -main [& args]
  (do
    (init-db)
    (run-jetty #'app {:port 8080 :join? false})))

