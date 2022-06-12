(ns clj-soap.core
  (:gen-class)
  (:require [clj-soap.api.ouka.core :as ouka-api]
            [clj-soap.api.soap.core :as soap-api])
  (:import [javax.xml.ws Endpoint]))

(def uri "http://localhost:8080/oukaApi")

(defn publish!
  ^Endpoint []
  (soap-api/publish! {:uri     uri
                      :handler ouka-api/perform-request!}))

(defn -main
  [& _args]
  (println "Publishing SOAP forwarder at " uri)
  (publish!))

;; When running through REPL

(defonce ep (atom nil))

(defn stop!
  []
  (when-let [^Endpoint endpoint @ep]
    (.stop endpoint)))

(defn start!
  []
  (stop!)
  (reset! ep (publish!)))
