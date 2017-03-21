(defproject org.clojure/data.json "0.2.7-SNAPSHOT"
  :parent [org.clojure/pom.contrib "0.1.2"]
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :source-paths ["src/main/clojure"]
  :test-paths ["src/test/clojure"]
  :monkeypatch-clojure-test false
  :dependencies [[org.clojure/clojure "1.9.0-alpha15"]
                 [org.clojure/core.typed "0.3.33-SNAPSHOT"]
                 ]
  :injections [(require 'clojure.core.typed)
               (clojure.core.typed/install
                 #{:load})]
  :repl-options {:timeout 300000}
  :repositories {"sonatype-oss-public" "https://oss.sonatype.org/content/groups/public/"}
  :min-lein-version "2.0.0")
