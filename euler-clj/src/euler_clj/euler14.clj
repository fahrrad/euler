(ns euler-clj.euler14)

(defn next-collatz-term [n]
  (if (odd? n)
    (inc (* 3 n))
    (/ n 2)))

(defn collatz-terms [n]
  (conj
   (take-while #(not (= 1 %))
               (iterate next-collatz-term n))
   1))

(defn collatz-term-length [to]
  (map #(count (collatz-terms %)) (range 1 (inc to))))

(defn find-element [element col i]
  (if (= (first col) element)
    i
    (recur element (rest col) (inc i))))

(defn euler14 [upto]
  (let [collatzs (collatz-term-length upto)
        max-length (apply max collatzs)]
    (println (format "max length %d" max-length))
    (find-element max-length collatzs 1)))

