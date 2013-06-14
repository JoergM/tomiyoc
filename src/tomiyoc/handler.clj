(ns tomiyoc.handler
  (:use [compojure.core]
        [tomiyoc.view]
        [ring.adapter.jetty :only (run-jetty)]
        [ring.util.response :only (resource-response)])
  (:require [compojure.handler :as handler]
            [compojure.route :as route])
  (:gen-class ))

;; Compojure Routes
(defroutes app-routes
  (GET "/voting" [] voting-screen)
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

;; Damit wird gestartet
(defn -main [& args]
  (run-jetty #'app {:port 80 :join? false}))

