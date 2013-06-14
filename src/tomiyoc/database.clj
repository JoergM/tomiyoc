(ns tomiyoc.database
  (:use [compojure.core]
        [ring.adapter.jetty :only (run-jetty)]
        [ring.util.response :only (resource-response)])
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [net.cgrand.enlive-html :as h])
  )

(defn init-db [optionen]
  false)

(defn save-vote [optionsnummer kartennummer]
  false)

(defn get-summary []
  {})