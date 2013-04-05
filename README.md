# contessa

[![Build Status](https://travis-ci.org/pitluga/contessa.png?branch=master)](https://travis-ci.org/pitluga/contessa)

A Clojure library to interact with the MaxMind free GeoLite City databases. That's a fancy way of saying that if you pass it an IP address, it will give you location data back.

This product includes GeoLite data created by MaxMind, available from http://www.maxmind.com

## Usage

To use this library, you first need to download a copy of the [GeoLite City](http://dev.maxmind.com/geoip/geolite) database from MaxMind. It is currently being updated once a month, so you may periodicly want to fetch a new version. A code sample should tell the rest of the story.

``` clojure
(ns my.ns
  (:require [contessa.core :as geo]))

(defn lookup-ip-address []
  (let [db (geo/build-database "/path/to/GeoLiteCity.dat")]
    (prn (geo/lookup-ip db "98.101.166.2"))))

(lookup-ip-address)
; {:country-code "US"
;  :country-name "United States"
;  :region "NC"
;  :city "Morrisville"
;  :postal-code "27560"
;  :latitude 35.860107
;  :longitude -78.8326
;  :dma-code 560
;  :area-code 919
;  :metro-code 560}
```

## License

Copyright © 2013 Tony Pitluga

Distributed under the Creative Commons Attribution-ShareAlike 3.0 Unported License
