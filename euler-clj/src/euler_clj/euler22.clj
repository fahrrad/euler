(ns euler-clj.euler22
  "Scoring names"
  (:require [clojure.string :as s]
            [clojure.java.io :as io]))

(defn score-char [c]
  (inc (- (int c) (int \a))))

(defn score-name [name]
  (apply + (map score-char name)))

(defn read-next-name [rdr]
  (->> (repeatedly #(.read rdr))
       (take-while #(and (>= % 0) (not (= % (int \,)))))
       (map char)
       (remove #{\" \newline \return})
       (apply str)
       (s/lower-case)))

(defn names-unsorted [rdr]
  (take-while
   (complement s/blank?)
   (repeatedly #(read-next-name rdr))))

(defn names [rdr]
  (sort (names-unsorted rdr)))

(defn score-names [names]
  (map score-name names))

(defn score-names-list [names]
  (apply + (map *
                (drop 1 (range)) ;; line number
                (score-names names))))

(defn score-file [filename]
  (let [f (io/resource filename)]
    (with-open [rdr (io/reader f)]
      (score-names-list (names rdr)))))


