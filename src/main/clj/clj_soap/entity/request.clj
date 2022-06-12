(ns clj-soap.entity.request
  (:require [clojure.java.data :as j]
            [camel-snake-kebab.core :as csk])
  (:import [cljsoap.api.soap Request]))

(defn obj->request
  [req]
  (let [m (j/from-java req)]
    {::water-type (-> m
                      :waterType
                      csk/->kebab-case-keyword)}))

(defn water-type
  [r]
  (::water-type r))
