(ns clojure.data.infer-types-json
  (:use clojure.test)
  (:require [clojure.core.typed :as t]
            [clojure.core.typed.runtime-infer :as infer]))

(defn delete-anns [nss]
  (doseq [ns nss]
    (infer/delete-generated-annotations
      ns
      {:ns ns})))

(defn infer-anns [nss]
  (doseq [ns nss]
    (t/runtime-infer :ns ns)))

(def infer-files
  '[clojure.data.json
    ])

;; FIXME shouldn't need this, but some types
;; don't compile
(delete-anns infer-files)

(def tests 
  '[clojure.data.json-test
    ])

(apply require tests)
(apply run-tests tests)

(infer-anns infer-files)
