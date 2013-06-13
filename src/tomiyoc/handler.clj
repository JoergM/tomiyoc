(ns tomiyoc.handler
  (:use [compojure.core]
        [ring.adapter.jetty :only (run-jetty)]
        [ring.util.response :only (resource-response)])
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [net.cgrand.enlive-html :as h])
  (:gen-class ))

(defn opt-snippet [o]
  {:tag :div, :attrs {:class "span12"},
   :content [{:tag :button, :attrs {:class "btn btn-danger btn-large btn-block"},
              :content o}]})

(h/deftemplate voting "templates/voting.html" [options]
  [:.opt ] (h/clone-for [o options]
             (h/content (opt-snippet o))))

(defn voting-screen [request]
  (voting ["Option 1" "Touch me if you can" "bLubberwasserprojekt" "Nummer 5 lebt"]))

(defroutes app-routes
  (GET "/voting" [] voting-screen)
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(defn -main [& args]
  (run-jetty #'app {:port 8080 :join? false}))

