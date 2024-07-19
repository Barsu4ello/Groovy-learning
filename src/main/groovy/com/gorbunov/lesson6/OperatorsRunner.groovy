package com.gorbunov.lesson6

assert 1 + 2 == 3
assert 4 - 3 == 1
assert 3 * 5 == 15
assert 3 / 2 == 1.5 // в java было бы целое число. Если хочешь результат как в java используй intdiv() как в строке 10
assert 10 % 3 == 1
assert 2**3 == 8 // возведение в степень

assert 3.intdiv(2) == 1

//java вариант. Будет работать в Groovy тоже
def result = (int) (3/2)
assert result == 1

// groovy вариант через алиасы
def result2 = (3/2) as int //или (Integer)
assert result2 == 1

// Объекты можно сравнивать через > >= < <= если они реализовали интерфейс Comparable
// В джаве это можно было бы сделать только через obj1.compareTo(obj2) объектов, которые также реализую интерфейс Comparable

// ===  !== сравнение по ссылке а == это сравнение по значению(equals())

def val = 130
println val === 130 // false
val = 1
println val * 130 == 130 // true
println val <=> 100 // вызывает функцию compareTo() и возвращает 1 -1 или 0 (в данном случае -1 так как val = 1 < 130)

Men men1 = new Men(5)
Men men2 = new Men(5)

println men1 == men2
