#lang racket
(display "Вариант 1. Написать программу, реализующую метод сортировки пузырька\n")
(display "Введите список в виде (1 2 3 ...)\n")
(define list1 (read))
(define (sort list1)
  (if (= (length list1) 1)
      list1
       (if (<= (car list1) (car (cdr list1)))
          (cons (car list1) (sort (cdr list1)))
          (cons (car (cdr list1)) (sort (cons (car list1) (cdr (cdr list1))))))))

(define (sortnum list1 num)
  (if (= num 0)
      list1
      (sortnum (sort list1) (- num 1))))

(define (bubblesort list1) (sortnum list1 (length list1)))
(display "\nОтсортированный список:")
(display (bubblesort list1))