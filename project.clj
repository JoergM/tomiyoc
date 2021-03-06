(defproject tomiyoc "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 [ring/ring-jetty-adapter "1.1.8"]
                 [enlive "1.1.1"]
                 [org.hsqldb/hsqldb "2.2.8"]
                 [org.clojure/java.jdbc "0.3.0-alpha4"]
                 [org.clojure/data.json "0.2.2"]]
  :plugins [[lein-ring "0.8.5"]]
  :ring {:handler tomiyoc.handler/app}
  :main tomiyoc.handler
  :profiles {:dev {:dependencies [[ring-mock "0.1.5"]]}})
