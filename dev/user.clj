(ns user
  (:require [taoensso.timbre :as timbre]))

(timbre/merge-config! {:level :info})
