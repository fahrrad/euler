(ns euler-clj.euler54
  (:require [clojure.string :as string])
  (:require [clojure.java.io :as io]))

(defn parse-value [value]
  (condp = value
    \T 10
    \J 11
    \Q 12
    \K 13
    \A 14
    (Integer/parseInt (str value))))

(defn parse-card [card]
  (let [[value suit] (seq card)
        num-value (parse-value value)]
    {:value num-value :suit (-> suit str keyword )}))

(defn flush? [hand]
  (apply = (map :suit hand)))

(defn royal-flush? [hand]
  (and (flush? hand)
       (straight? hand)
       (= 14 (max (map :value )))))

(defn- straight?
  [hand]
  (let [sorted-values (sort (map :value hand))]
     (= 4
        (- (last sorted-values)
           (first sorted-values)))))

(defn straight-flush? [hand]
  (and
   (flush? hand)
   (straight? hand)))

(defn n-of-a-kind [n]
  (fn [hand]
    (some (fn [[k v]] (= n v))
          (frequencies (map :value hand)))))

(def four-of-a-kind? (n-of-a-kind 4))
(def three-of-a-kind? (n-of-a-kind 3))
(def pair? (n-of-a-kind 2))

(defn full-house? [hand]
  (and (three-of-a-kind? hand)
       (pair? hand)))

(defn highest-card [hand]
  (max (map :value hand)))

(defn score-hand [hand]
  (condp #(%1 %2) hand
    royal-flush? 1000
    straight-flush? 900
    four-of-a-kind? 800
    full-house? 700
    flush? 600
    straight? 500
    three-of-a-kind? 400
    pair? 200
    :else (highest-card hand)))

(defn parse-hand [hand]
 (as-> hand p 
   (string/split p #" ")
   (map parse-card p)))

(defn parse-hands [hands]
  (as-> hands p
   (string/split p #"\n")
   (map string/trim p)
   (map parse-hand p)
   (map #(split-at 5 %) p)))

(def straight-flush (parse-hand "2D 3D 4D 6D 5D"))
(def four-of-a-kind (parse-hand "2D 2S 2C 2H 5H"))
