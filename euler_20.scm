(define (factorial x)
	(cond [(= 1.0 x) x]
				[else (* x (factorial (- x 1)))]))

(define (log10 n)
	(floor (/ (log n)
							 (log 10))))


(define (sum-digits n)
	(if (<= n 9)
			n
			(let* ([pow-of-10 (log10 n)]
						[biggest-10-div (expt 10 pow-of-10)]
						[digit (floor (/ n biggest-10-div))]
						[rem (- n (* digit biggest-10-div))])
				(+ digit (sum-digits rem)))))


(sum-digits (factorial 100))
