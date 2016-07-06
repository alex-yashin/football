(ns football.core-test
  (:require [clojure.test :refer :all]
            [football.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 2 (score "1:2" "1:2")))
    (is (= 1 (score "1:2" "3:4")))
    (is (= 0 (score "5:1" "1:2")))
    ))
