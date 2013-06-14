(ns tomiyoc.database
  (use tomiyoc.options)
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.java.jdbc.sql :as sql]))

(def hsql-db {:subprotocol "hsqldb"
              :subname "file:votedb"
              :user "SA"
              :password ""})

(defn init-db []
  (jdbc/with-connection hsql-db
    (do
      (jdbc/create-table :votes [:kartennr "varchar(16)"]
        [:optionid "INTEGER"]))))

;;todo doppelte Eintragung verhindern
(defn save-vote [optionsnummer kartennummer]
  (jdbc/with-connection hsql-db
    (jdbc/insert-record :votes {:kartennr kartennummer
                                :optionid optionsnummer})))

(defn get-summary []
  {})