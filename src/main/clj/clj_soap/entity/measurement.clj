(ns clj-soap.entity.measurement
  (:import [cljsoap.api.soap Measurement]))

(set! *warn-on-reflection* true)

(defn make-measurement
  "Given a map returns an instance of cljsoap.api.soap.Measurement"
  ^Measurement [{:keys [water_temp location beach]}]
  (Measurement. water_temp location beach))

(defn ^"[Lcljsoap.api.soap.Measurement;" ->as-array
  [xs]
  (->> xs
       (mapv make-measurement)
       (into-array)))
