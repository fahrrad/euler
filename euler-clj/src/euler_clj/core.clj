(ns euler-clj.core
  (:gen-class))

(defn divisors [x]
  (filter #(= 0 (mod x %)) (range 1 (Math/sqrt (inc x)))))

(defn divisors-fast [x]
  (loop [d 1
         acc #{}]
    (if (< x (* d d))
      acc
      (recur (inc d)
             (if (= 0 (rem x d)) (conj (conj acc (/ x d)) d) acc)))))

(defn count-divisors [x]
  (count (divisors-fast x)))

(defn euler12 [triangle-num n d]
  (if (>= (count-divisors triangle-num) d)
    (list triangle-num n)
    (recur (+ (inc n) triangle-num) (inc n) d)))

(defn next-triangle-number [[n t]]
  [(inc n) (+ (inc n) t)])

(defn triangle-numbers []
  (map #(nth % 1) (iterate next-triangle-number [0 0])))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

