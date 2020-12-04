#lang racket
(display "Задание 1\nЕсть два списка. Если первый элемент списка есть натуральное число,
то возвратить второй список, иначе возвратить список из головы 
второго и хвоста первого.")
(define firstList (list 0 2 3 4 5))
(define secondList (list 6 7 8 9 10))
(define (checkFirstArg arg)
  (if (and (= (remainder arg 1) 0)(> arg 0))
       (list secondList)
  (append secondList firstList)))
(display "\nОтвет:")
(display (checkFirstArg (first firstList)))


(display "\nЗадание 11.\nЕсть два списка. Написать функцию, формирующую список из трех
подсписков. Первый подсписок содержит голову первого списка и
третий элемент второго. Второй подсписок содержит второй элемент
второго списка и последний элемент первого.")
(define fList (list 1 2 3 4 5 6 "as" 8))
(define sList (list 1 2 3 4 5 6 "as" 8))
(define (makeLists fList sList)
  (list (list (first sList) (third sList))
  (list (second sList) (last fList))))
(display "\nОтвет:")
(display (makeLists fList sList))

(display "\n12 Задание.\nЕсть 2 списка, например, (1 2 3 4 5) и (7 6 5 7). Если произведение первых
элементов исходных списков есть положительное число, то объединить в
результирующий список последние элементы. В противном случае
построить список из последнего элемента первого списка и хвоста
второго.")
(display "\nВведите первый числовой список в формате (1 2 3)")
(define c (read))
(display "Введите второй числовой список в формате (-1 2 3)")
(define d (read))
(display "\nОтвет:")
(if (> (* (car c)(car d)) 0)
    (display (list (last c)(last d)))
       (display (cons (last c)(cdr d))))
(display  "\n")