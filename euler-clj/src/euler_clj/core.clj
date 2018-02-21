(ns euler-clj.core
  (:gen-class))

(defn divisors-fast [x]
  (loop [d 2
         acc #{}]
    (if (< x (* d d))
      acc
      (recur (+ 2 d)
             (if (= 0 (rem x d)) (conj (conj acc (/ x d)) d) acc)))))

(defn count-divisors [x]
  (let [dc (count (divisors-fast x))]
    (+ 2 (if (= 0 (rem x 2)) (* 2 dc) dc))))

(defn next-triangle-number [[n t]]
  [(inc n) (+ (inc n) t)])

(defn triangle-numbers []
  (map #(nth % 1) (iterate next-triangle-number [0 0])))

(defn triangle-numbers-with-divisors-count []
  (pmap (fn [triangle-num] (list (count-divisors triangle-num) triangle-num))  
       (triangle-numbers)))

(defn euler12 [d]
  (nth 
   (first (filter (fn [[dc tn]] (> dc d)) (triangle-numbers-with-divisors-count)))
   1))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))



