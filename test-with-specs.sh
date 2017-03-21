#!/bin/sh

echo 'Disabling :lang on clojure.data.json\n'
perl -pi -e 's/:lang :core.typed/;:lang :core.typed/g' src/main/clojure/clojure/data/json.clj
lein test :only clojure.data.test-with-specs-json
perl -pi -e 's/;:lang :core.typed/:lang :core.typed/g' src/main/clojure/clojure/data/json.clj
