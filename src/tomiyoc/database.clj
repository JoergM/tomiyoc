(ns tomiyoc.database
  (use tomiyoc.options)
  (:require [clojure.java.jdbc :as sql]))

(def hsql-db {:subprotocol "hsqldb"
              :subname "file:votedb"
              :user "SA"
              :password ""})

(defn init-db []
  (sql/with-connection hsql-db
    (do
      (sql/create-table :votes [:kartennr "varchar(16)"]
        [:optionid "INTEGER"]))))

(defn save-vote [optionsnummer kartennummer]
  (sql/with-connection hsql-db
    (sql/insert-record :votes {:kartennr kartennummer
                               :optionid optionsnummer})))

(defn get-summary []
  {})