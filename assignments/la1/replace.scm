;;prog
(define replace 
	(lambda (source target replacement) 
		(cond 
			((eqv? source target) replacement)
			((and (not (list? source)) (not (eqv? source target))) source)
			((null? source) '())
			((equal? target (car source)) (cons replacement (replace (cdr source) target replacement)))
			((not (list? (car source))) (cons (car source) (replace (cdr source) target replacement)))
			(else (cons (replace (car source) target replacement) (replace (cdr source) target replacement)))
		)
	)
)

;;tests
(replace 'x 'x 'y)
(replace 1111 2222 2222)
(replace 'string 'string 'there-are-no-strings)
(replace 1 1 2)
(replace 1111 1111 2222)
(replace '(a (b c) (d (b c (b c) (d (b c (b c)(d (b c))))))) '(b c) '(x y))
(replace '(a (b c) (d (b c))) '(b c) '(x y))
(replace '(a (b c) d (b c)) '(b c) '(x y))
(replace '(a (b c) d (b c)) '(x y) '(b c))	
(replace '(a '() b) '() '(x y))