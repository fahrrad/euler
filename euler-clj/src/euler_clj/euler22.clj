(ns euler-clj.euler22
  "Scoring names"
  (:require [clojure.string :as s]
            [clojure.java.io :as io]))

(defn score-char [c]
  (inc (- (int c) (int \a))))

(defn score-name [name]
  (apply + (map score-char name)))

(defn remove-quotes [s]
  (apply str  (remove #{\" \newline \return} s)))

(defn scan-next-name
  "reads the next name from the scanner. removes quotes and lowercases. If scanner is exhausted, return nil"
  [scanner]
  (when (.hasNext scanner)
    (-> (.next scanner)
        remove-quotes
        s/lower-case)))

(defn names-unsorted [scanner]
  (take-while
   (complement s/blank?)
   (repeatedly #(scan-next-name scanner))))

(defn names [scanner]
  (sort (names-unsorted scanner)))

(defn score-names [names]
  (map score-name names))

(defn score-names-list [names]
  (apply +
         (map *
              (drop 1 (range)) ;; line number
              (score-names names))))

(defn comma-delimited-scanner [r]
  (-> r
      (java.util.Scanner.)
      (.useDelimiter ",")))

(defn score-file [filename]
  (let [f (io/resource filename)]
    (with-open [reader (io/reader f)
                scanner (comma-delimited-scanner reader)]
      (score-names-list (names scanner)))))


