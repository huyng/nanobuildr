(ns nanobuildr.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [clojure.java.shell :as shell]))

(defn set-interval [callback ms] 
  (future (while true (do (Thread/sleep ms) (callback)))))

(def job (set-interval #(println "hello") 1000))

(defn build-api []
    (println (shell/sh "echo" "cat cat cat"))
    "E")

(defroutes app-routes
  (GET "/" [] (io/resource "public/index.html"))
  (GET "/build" [] (build-api))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
