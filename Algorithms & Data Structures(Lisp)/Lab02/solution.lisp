(defun a-sum (a b)
  (do ((i a (+ i 1))
       (sum 0 (+ i sum)))
      ((> i b) sum)))

(defun sum-odd (a b)
    (do ((i a (+ i 1))
         (sum 0 (if (oddp i)
                    (+ i sum)
                    (+ 0 sum))))
        ((> i b) sum)))

(defun my-function (f)
  (funcall f 1))

(defun sigma (f n p)
  (do ((i n (+ i 1))
      (sum 0 (+ (funcall f i) sum)))
  ((> i p) sum)))
