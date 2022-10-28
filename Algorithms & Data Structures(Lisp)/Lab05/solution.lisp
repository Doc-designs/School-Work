(defun arith-eval (expr)
  "EXPR is a list of symbols that may include:
square brackets, arithmetic operations, and numbers."
  (let ((ops ())
        (vals ())
        (op nil)
        (val nil)
        (bal-brac 0))
    (dolist (item expr)
      (case item
        ([ (incf bal-brac)) ; do nothing
        ((+ - * / ^ sdiv maxf fact) (push item ops))
        (] (decf bal-brac)
         (setf op (pop ops) val (pop vals))
         (case op
           (+ (setf val (+ val (pop vals))))
           (- (setf val (- (pop vals)  val)))
           (* (setf val (* val (pop vals))))
           (/ (setf val (/ (pop vals)  val)))
           (^ (setf val (expt (pop vals)  val)))
           (sdiv (setf val ((lambda (x y z) (/ (- y x) z)) (pop vals) (pop vals) val)))
           (maxf (setf val (max (max (pop vals) (pop vals)) val)))
           (fact (setf val (factorial val))))
         (push val vals))
        (otherwise (push item vals))))
    (when (/= bal-brac 0)
      (return-from arith-eval "Error"))
      (pop vals)))

(defun factorial (n)
  (if (= n 0) 1
      (* n (factorial (- n 1))))
  )
