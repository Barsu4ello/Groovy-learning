package com.gorbunov.lesson13

import com.gorbunov.lesson6.Men

import java.lang.reflect.Array

class ListRunner {
    static void main(String[] args) {
        def list = [1, 2, 3, 4]
        def arr = [1, 2, 3, 4] as int[]

        assert list.getClass() == ArrayList
        assert arr.getClass().isArray()

        //read
        assert list.get(2) == 3 // Java
        assert list[2] == 3 // Groovy

        assert list.get(list.size() - 1) == 4 // Java
        assert list[-1] == 4 // Groovy

        assert list[1..3] == [2, 3, 4] //Подсписок. Под капотом тип данных Range

        assert list[8] == null
        // В Java был Exception по выходу за пределы массива. В старых версиях Groovy это записывалось: list?[]

        //write
        list += 9 // Добавление в конец списка
        list << 11 << 13 << 13// Добавление нескольких элементов в конец списка
        assert list == [1, 2, 3, 4, 9, 11, 13, 13]
        list -= 13 // Удалит все элементы с данным значением
        assert list == [1, 2, 3, 4, 9, 11]
        list -= [1, 3] // Удалит все единицы и тройки
        assert list == [2, 4, 9, 11]
        list *= 2 // Умножит как строки. То есть будет вдвое больше размером с теми же значением, что и исходный
        assert list == [2, 4, 9, 11, 2, 4, 9, 11]

        // метод из queue
        list.push(1) // добавит элемент в начало
        assert list == [1, 2, 4, 9, 11, 2, 4, 9, 11]
        println list.pop() // Вернет элемент с начала
        assert list == [2, 4, 9, 11, 2, 4, 9, 11]
        assert list.head() == 2
        assert list.tail() == [4, 9, 11, 2, 4, 9, 11]
        assert list.last() == 11

        //flatten, reverse, intersect, disjoint
        assert [1, 2, [3, 4], 5].flatten() == [1, 2, 3, 4, 5] // развернет внутренние списки(массивы в один)
        assert [1, 2, 3].reverse() == [3, 2, 1]
        assert [1, 2, 3].intersect([2,3]) == [2,3]
        assert [1, 2, 3].disjoint([4,5,6]) // true пересечений нет
//        assert [1, 2, 3].disjoint([1,5,6]) // false пересечения есть

        // new operators
        //Multiple assignment
        def (a, b, c) = [1, 's', new Men(5)]
        assert a == 1
        assert b == 's'
        assert c == new Men(5)

        // Spread operator
        def y = new Men(5)
        def z = new Men(10)
        def yz = [y,z]
        println yz*.age //  Выведет только массив полей возраст

        func(*[3,4])
    }

    static def func(def a, def b) {
        println a
        println b
    }
}
