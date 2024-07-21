package com.gorbunov.lesson16

import com.gorbunov.lesson10.Person

class IteratesRunner {

    static void main(String[] args) {
        assert [1, 4, 7, 9].any { it % 2 == 0 }
        assert [1, 4, 7, 9].find { it % 2 == 0 } == 4
        assert [1, 4, 7, 9].findAll() { it % 2 != 0 } == [1, 7, 9]
        assert (2..4).collect() == [2, 3, 4]

        def person = new Person(25)
        person.each { println it}

        // в grep() должно выполняться условие isCase (switch, in, grep)
        assert ["asd", "sda", "12", "454", "2134dc"].grep(~/\d+/) == ["12", "454"]
        assert ["asd", "sda", "12", "454", "2134dc"].grep {it.length() > 4 } == ["2134dc"]
    }
}
