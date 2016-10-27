(ns clojure.data.infer-json
  (:use clojure.test)
  (:require [clojure.core.typed :as t]
            [clojure.core.typed.runtime-infer :as infer]))

(def ^:dynamic *infer-fn* t/runtime-infer)

(defn delete-anns [nss]
  (doseq [ns nss]
    (infer/delete-generated-annotations
      ns
      {:ns ns})))

(defn infer-anns [nss]
  (doseq [ns nss]
    (*infer-fn* :ns ns)))

(def infer-files
  '[clojure.data.json
    ])

(defn infer [spec-or-type]
  (binding [*infer-fn* (case spec-or-type
                         :type t/runtime-infer
                         :spec t/spec-infer)]
    ;; FIXME shouldn't need this, but some types
    ;; don't compile
    (delete-anns infer-files)

    (def tests 
      '[clojure.data.json-test
        ])

    (apply require tests)
    (apply run-tests tests)

    (infer-anns infer-files)))
