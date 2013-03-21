(ns mining.3
  (:require [clojure.set :refer :all]))

(defn sim [s t]
  (double (/ (count (intersection s t))
             (count (union s t)))))

(defn multiset [& c]
  (frequencies c))

(defn multiset-union [s t]
  (merge-with + s t))

(defn multiset-intersection [s t]
  (merge-with min
              s
              (select-keys t
                           (keys s))))

(defn bag-sim [s t]
  (double (/ (apply + (vals (multiset-intersection s t)))
             (apply + (vals (multiset-union s t ))))))

;; n = 3 m = 2 U = {:a :b :c}

(for [s [#{:a :b} #{:a :c} #{:b :c}]
      t [#{:a :b} #{:a :c} #{:b :c}]]
  (sim s t))