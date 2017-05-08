(ns euler-clj.core-test
  (:require [clojure.test :refer :all]
            [euler-clj.core :refer :all]
            [euler-clj.euler14 :refer :all :as e14]))

(deftest Collatz-sequence
  (testing "next term if term is even"
    (is (= 5 (e14/next-collatz-term 10))))
  (testing "next term if term is odd"
    (is (= 16 (e14/next-collatz-term 5))))
  (testing "Collatz sequence starting with 13 has 10 terms"
    (is (= 10 (count (e14/collatz-terms 13))))))
