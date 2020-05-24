(ns clj-soap.entity.measurement
  (:import (cljsoap.api.soap Measurement)))

(defn ^Measurement make-measurement
  "Given a map returns an instance of cljsoap.api.soap.Measurement"
  [{:keys [water_temp location beach]}]
  (Measurement. water_temp location beach))

(defn ^"[Lcljsoap.api.soap.Measurement;" ->as-array
  [xs]
  (->> xs
       (mapv make-measurement)
       (into-array)))
