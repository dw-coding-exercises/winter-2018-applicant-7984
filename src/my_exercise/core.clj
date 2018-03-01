(ns my-exercise.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.reload :refer [wrap-reload]]
            [my-exercise.home :as home]))

;;REST API lives here
;;Create the missing search route below using Compojure syntax
;;The search route will accept all parameters and need to be normalized with a built-in lowercased method
;;Compojure handlers in this case will not receive the entire map request as an argument, but extract all form parameters


;;Functionality 
(defn get-params [request] ;;defining the function get-params that accepts the request body of the form's post route
  (let [post value (get-in request [:form-params :get-params])] 
    (lower-case str)))  ;;need to lowercase the state to standardized inputs
                        ;;create copy of state 
                        ;;append to uri
                        ;;need to lowercase the city to standardized inputs
                        ;;create copy of city 
                        ;;append to uri

;;Routing
(defroutes app
    (GET "/" [] home/page)
    ;;(POST "/search" [] get-params
      (POST "/search" request
        (str (:form-params request)))
    (GET "/search" {params : params} []
      (get params :street)
      (get params :street-2)
      (get params :city)
      (get params :state)
      (get params :zip))
    (route/resources "/")
    (route/not-found "Not found"))

 

(def handler
  (-> app
      (wrap-defaults site-defaults)
      wrap-reload
      wrap-params)) ;;using wrap-params middleware to grab params from request
