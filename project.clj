(defproject clj-soap "0.1.0-SNAPSHOT"
  :description "Testing how to implement JAX-WS api with clojure"
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/java.data "1.0.95"]
                 [camel-snake-kebab "0.4.3"]
                 ;; Soap + wsdl
                 [jakarta.xml.ws/jakarta.xml.ws-api "2.3.3"]
                 [com.sun.xml.ws/jaxws-rt "2.3.3"]
                 ;; Http + json
                 [org.martinklepsch/clj-http-lite "0.4.3"]
                 [cheshire "5.11.0"]
                 ;; Logging
                 [com.fzakaria/slf4j-timbre "0.3.21"]
                 [org.slf4j/log4j-over-slf4j "1.7.36"]
                 [org.slf4j/jul-to-slf4j "1.7.36"]]

  :java-source-paths ["src/main/java"]
  :source-paths ["src/main/clj"]
  :target-path "target/%s"

  :main ^:skip-aot clj-soap.core

  :profiles {:uberjar {:aot      :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}
             :dev     {:source-paths ["dev"]}})
