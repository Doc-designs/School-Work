(defun add-3 (x)
  (+ x 3))

(defun square (x)
  (* x x))

(defun my-abs (x)
  (cond ((>= x 0) x)
        ((< x 0) (*  x -1))))
  
(defun largest (x y)
  (cond ((<= x y) y) 
        ((> x y) x)))

(defun dep (b a)
  (cond ((< a 10000) (+ b a))
        ((>= a 10000) NIL)))

(defun wdr (b a)
  (if (and
      (>= b a)
      (< a 10000))
      (- b a)
      (+ b a)))

(defvar *balance* 100)

(defun withdraw (amount)
  (cond ((< amount 0) (print "Negative amount"))
        ((>= amount 10000) (print "Exceeds maximum withdrawal amount"))
        ((< *balance* amount) (print "Insufficient funds"))
        ((/= (rem amount 20) 0) (print "Must be a Multiple of 20"))
        (t (:= *balance* (- *balance* amount))))
  *balance*)

(defun deposit (amount)
  (cond ((>= amount 50000) (print "Exceeds 50000$ Deposit Limit"))
        ((< amount 0) (print "Negative Amount"))
        (t (:= *balance* (+ *balance* amount))))
   *balance*)
