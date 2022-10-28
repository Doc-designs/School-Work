(defstruct movie
     title  director year type)

(defparameter *size* 3) 

(defvar *db*)

(setf *db* (make-array *size*  :initial-element nil))

(defun in-db? (title)
  "Returns *db* if movie title is in the database; otherwise returns NIL"
  (dotimes (i *size*)
    (when (and (typep (aref *db* i) 'movie)
               (equal (movie-title (aref *db* i)) title))
      (return *db*))))

(defun num-movies ()
  (let ((used-data '0))
    (dotimes (i *size*)
      (when (and (typep (aref *db* i) 'movie) (movie-title (aref *db* i)))
        (setq used-data (+ 1 used-data))))
    used-data))

(defun add-movie (m)
  "Adds a movie to *db* and returns *db*"
  (cond ((= (num-movies) *size*)
         NIL)
        ((in-db? (movie-title m))
         NIL))
  (dotimes (i *size*)
    (when (null (aref *db* i))
      (setf (aref *db* i) m)
      (return *db*))))

(defun replace-movie (m nm)
  (cond ((null (in-db? (movie-title m)))
         NIL)
        ((in-db? (movie-title nm))
         NIL))
  (dotimes (i *size*)
    (when (equalp (aref *db* i) m)
      (setf (aref *db* i) nm)
      (return T))))

(defun delete-movie (title)
  ;FIX SECOND LOOP
  (when (null (in-db? title))
    NIL ; (return-from delete-movie NIL)
    )
  (dotimes (i *size*)
    (when (equalp (movie-title (aref *db* i)) title)
      (do (j i (+ j 1))
          (setq (aref *db* j) (aref *db* (+ j 1))))
      (return (delete (aref *db* i) *db*)))))
