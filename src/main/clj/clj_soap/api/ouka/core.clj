(ns clj-soap.api.ouka.core
  (:require [clj-http.client :as client]
            [clj-soap.entity.request :as request]
            [taoensso.timbre :as log]))

(def api-url "https://api.ouka.fi/v1/swimming_water_quality_stats")

(def default-args {:as :json})

(defn- water-type->id
  [water-type]
  (case water-type
    :inland-waters 1
    :coastland-waters 2))

(defn- is-equal
  [x]
  (str "eq." x))

(defn- req->params
  [req]
  (let [wt-id (some-> req
                      (request/water-type)
                      (water-type->id))]
    (cond-> {}
            (some? wt-id) (assoc :water_type_id (is-equal wt-id)))))

(defn perform-request!
  [req]
  (log/info "Querying api.ouka.fi with arguments:" req)
  (let [{:keys [status body]} (client/get api-url
                                          (merge default-args
                                                 {:query-params (req->params req)}))]
    (when (<= 200 status 299)
      (log/info "Fetched" (count body) "measurements")
      body)))
