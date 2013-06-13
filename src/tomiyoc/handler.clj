(ns tomiyoc.handler
  (:use [compojure.core]
        [ring.adapter.jetty :only (run-jetty)])
  (:require [compojure.handler :as handler]
            [compojure.route :as route])
  (:gen-class))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(defn -main [& args]
  (run-jetty #'app {:port 8080 :join? false}))

