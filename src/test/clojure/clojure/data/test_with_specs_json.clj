(ns clojure.data.test-with-specs-json
  (:require [clojure.data.json :as m]
            [clojure.data.json-test]
            [clojure.test :as test]
            [clojure.spec.test :as stest]))

(defn activate-specs []
  (stest/instrument 
    (filter (comp #{'clojure.data.json} symbol namespace)
            (stest/instrumentable-syms))))

(println "Activated specs:\n" (activate-specs))
(println "To prove specs are actually enabled, here is a bad call to (read-str nil)")
(println
  (try (m/read-str nil)
       (catch Throwable e e)))

(prn "The above lines should show a spec error from a bad call to (read-str nil)")

(test/run-tests 'clojure.data.json-test)
