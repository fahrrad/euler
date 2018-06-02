;; Starting in the top left corner of a 2×2 grid,
;; and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
(ns euler-clj.euler15
  (:gen-class))

(defn right [[x y]]
  (list (inc x) y))

(defn down [[x y]]
  (list x (inc y)))

(defn next-moves [coordinates]
  (list (right coordinates) (down coordinates)))

(defn valid-move [[x y] grid-size]
  (and (<= x grid-size)
       (<= y grid-size)))

(defn walk [grid-size coordinates]
  (let [[step-right step-down] (next-moves coordinates)]))

(defn pow-on-speed [n p]
  (reduce * (repeat p (bigint n))))

(defn digits [n]
  (if (< n 10)
    (list n)
    (cons (rem n 10) (digits (quot n 10)))))

(defn sum-digits-of [n]
  (reduce + (digits n)))
