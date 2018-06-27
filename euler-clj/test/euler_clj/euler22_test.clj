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

(t/deftest scan-next-name-test
  (t/testing "Reading reads till the next comma"
    (let [sr (java.io.StringReader. "\"MARIE\",\"PIERE\"")
          scanner (sut/comma-delimited-scanner sr)]
      (t/is (= "marie" (sut/scan-next-name scanner)))))
  (t/testing "Reading stops at the end of the file"
    (let [sr (java.io.StringReader. "\"PIERE\"")
          scanner (sut/comma-delimited-scanner sr)]
      (t/is (= "piere" (sut/scan-next-name scanner)))
      (t/is (nil? (sut/scan-next-name scanner))))))

(t/deftest names-usorted-test
  (t/testing "returns all the names"
    (let [s "piere,marie,louise,anna"
          sr (java.io.StringReader. s)
          scanner (sut/comma-delimited-scanner sr)
          names (sut/names-unsorted scanner)]
      (t/is (= 4 (count names))))))

(t/deftest names-test
  (t/testing "returns all the names, sorted"
    (let [s "piere,marie,louise,anna"
          names-sorted ["anna" "louise" "marie" "piere"]
          reader (java.io.StringReader. s)
          scanner (sut/comma-delimited-scanner reader)
          names (sut/names scanner)]
      (t/is (= names-sorted names)))))

(t/deftest score-names-list-test
  (t/testing "scoring multiplies individula score with index"
    (let [names ["colin" "ward" "anna"]
          [s1 s2 s3] (map sut/score-name names)
          total-score (+ s1 s2 s2 s3 s3 s3)]
      (t/is total-score (sut/score-names names)))))
