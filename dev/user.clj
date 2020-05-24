(ns user
  (:require [taoensso.timbre :as timbre]))

(set! *warn-on-reflection* true)

(timbre/merge-config! {:level :info})

