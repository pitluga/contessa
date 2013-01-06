(ns contessa.core-test
  (:use clojure.test
        contessa.core))

(deftest lookup-finds-information-for-ip
  (let [db (build-database "GeoLiteCity.dat")]
    (testing "can find a location by ip address"
      (let [location (lookup-ip db "98.101.166.2")]
        (is (= "US" (:country-code location)))
        (is (= "United States" (:country-name location)))
        (is (= "NC" (:region location)))
        (is (= "Morrisville" (:city location)))
        (is (= "27560" (:postal-code location)))
        (is (= (float 35.860107) (:latitude location)))
        (is (= (float -78.8326) (:longitude location)))
        (is (= 560 (:dma-code location)))
        (is (= 919 (:area-code location)))
        (is (= 560 (:metro-code location)))))
    (testing "empty map if location is not found"
      (is (= {} (lookup-ip db "127.0.0.1"))))))
