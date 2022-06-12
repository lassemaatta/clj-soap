(ns clj-soap.api.soap.core
  (:require [clj-soap.entity.request :as request]
            [clj-soap.entity.measurement :as measurement])
  (:import [javax.jws WebMethod WebService]
           [javax.xml.ws Endpoint]))

(set! *warn-on-reflection* true)

(definterface MeasurementApi
  (^"[Lcljsoap.api.soap.Measurement;" getAllMeasurements [])
  (^"[Lcljsoap.api.soap.Measurement;" getMeasurements [^cljsoap.api.soap.Request req]))

(deftype
  ^{WebService {:targetNamespace "http://tempuri.org"}}
  MeasurementProducerImplementor [handler]
  MeasurementApi
  (^{WebMethod []} getAllMeasurements
    [_]
    (some-> (handler {})
            (measurement/->as-array)))

  (^{WebMethod []} getMeasurements
    [_ req]
    (some-> (handler (request/obj->request req))
            (measurement/->as-array))))

(defn publish!
  ^Endpoint [{:keys [uri handler]}]
  (Endpoint/publish uri (->MeasurementProducerImplementor handler)))
