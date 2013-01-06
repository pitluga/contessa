(ns contessa.core
  (:import [com.maxmind.geoip LookupService]))

(defn build-database [file-path & options]
  (LookupService. file-path (if (:cache (apply hash-map options))
                                LookupService/GEOIP_MEMORY_CACHE
                                LookupService/GEOIP_STANDARD)))

(defn lookup-ip [db ip-address]
  (let [location (.getLocation db ip-address)]
    (if (nil? location)
      {}
      {:country-code (.countryCode location)
       :country-name (.countryName location)
       :region (.region location)
       :city (.city location)
       :postal-code (.postalCode location)
       :latitude (.latitude location)
       :longitude (.longitude location)
       :dma-code (.dma_code location)
       :area-code (.area_code location)
       :metro-code (.metro_code location)})))
