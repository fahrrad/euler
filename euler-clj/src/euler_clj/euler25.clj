(ns euler-clj.euler25
  (:require [clojure.java.io :as io]))


(defn next-fib [[fib previous]]
  (list (+ fib previous) fib))

(def fibs (iterate next-fib [1.0 1.0]))

(first (drop-while #(< (first  %) 10e1000) fibs))

(defn read-words-from-file [file-name]
  (with-open [f (-> file-name io/resource io/reader)]))
