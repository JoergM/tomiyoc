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

(defn save-vote [optionsnummer kartennummer]
  (jdbc/with-connection hsql-db
    (jdbc/update-or-insert-values
      :votes (sql/where {:kartennr kartennummer})
      {:optionid optionsnummer, :kartennr kartennummer})))

(defn get-summary []
  (let [votes (jdbc/query hsql-db (sql/select * :votes ))]
    (frequencies (map #(:optionid %) votes))))