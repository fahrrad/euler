(ns euler-clj.euler25)


(defn next-fib [[fib previous]]
  (list (+ fib previous) fib))

(def fibs (iterate next-fib [1.0 1.0]))

(first (drop-while #(< (first  %) 10e1000) fibs))
