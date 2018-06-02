(ns euler-clj.euler22-test
  (:require [euler-clj.euler22 :as sut]
            [clojure.test :as t]))

(t/deftest score-char-test
  (t/testing "scoring an a: 1"
    (t/is (= 1 (sut/score-char \a))))
  (t/testing "scoring a z: 26"
    (t/is (= 26 (sut/score-char \z)))))

(t/deftest score-name-test
  (t/testing "scoring the example from euler"
    (t/is (= 53 (sut/score-name "colin")))))

(t/deftest read-next-name-test
  (t/testing "Reading reads till the next comma"
    (let [sr (java.io.StringReader. "\"MARIE\",\"PIERE\"")]
      (t/is (= "marie" (sut/read-next-name sr)))))
  (t/testing "Reading stops at the end of the file"
    (let [sr (java.io.StringReader. "\"PIERE\"")]
      (t/is (= "piere" (sut/read-next-name sr))))))

(t/deftest names-usorted-test
  (t/testing "returns all the names"
    (let [s "piere,marie,louise,anna"
          sr (java.io.StringReader. s)
          names (sut/names-unsorted sr)]
      (t/is (= 4 (count names))))))

(t/deftest names-test
  (t/testing "returns all the names, sorted"
    (let [s "piere,marie,louise,anna"
          names-sorted ["anna" "louise" "marie" "piere"]
          sr (java.io.StringReader. s)
          names (sut/names sr)]
      (t/is (= names-sorted names)))))

(t/deftest score-names-list-test
  (t/testing "scoring multiplies individula score with index"
    (let [names ["colin" "ward" "anna"]
          [s1 s2 s3] (map sut/score-name names)
          total-score (+ s1 s2 s2 s3 s3 s3)]
      (t/is total-score (sut/score-names names)))))
