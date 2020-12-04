#lang racket
(display "\n--------Задание 1--------\n")
(display "Вычисление площади кольца.\n")
(display "Введите исходные данные:\n")
(display "Радиус кольца (см)\n")
(define R(read))
(display "Радиус отверстия (см)\n")
(define r(read))
(define pi 3.14)
(define (sq a)
  (* a a))
(if (<= R r)
    (display "Ошибка! Радиус отверстия не может быть больше радиуса кольца.")
    (display(format "Площадь кольца: ~a"(* pi (- (sq R) (sq r))))))

(display "\n--------Задание 3--------\n")
(display "Написать программу, которая проверяет, является ли год високосным.\n")
(display "Введите год:\n")
(define year(read))
(if (=(remainder year 4) 0)
    (display(format "~a год високосный" year))
    (display(format "~a год не високосный" year)))

(display "\n--------Задание 6--------\n")
(display "Написать программу вычисления стоимости покупки с учетом скидки.\n")
(display "Введите сумму покупки\n")
(define cost(read))
(if (> cost 1000)
    (display(format "Вам предоставляется скидка 10%\nСумма покупки с учетом скидки: ~a"(* cost 0.9)))
    (display(format "Вам не предоставляется скидка 10%\nСумма покупки: ~a" cost)))



