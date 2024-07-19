package com.gorbunov.lesson11

import com.gorbunov.lesson10.Person

class SwitchRunner {
    static void main(String[] args) {
        int x = 2
        //В Java switch принимал только char, byte, short, int, Character, Byte, Short, Integer, String, enum
        //в Groove switch принимает любой тип данных
        switch (x) {
            case String: // Можно без .class //выполняется isInstance
                println 0
                break  //нужен обязательно как в старых версиях Java
            case 5:
                println 1
                break
            case new Person(12):  // вызывается person.isCase(x)
                println 5
                break
            case ~/\d+/:
                println 2
                break
            case {
                if (it > 10) {
                    it % 5 == 0
                    false // Тут Closure  должно возвращать boolean иначе условие будет всегда выполняться
                }
            }:
                println 3
                break
            case [1, 5, 8, 12]: //Проверяет есть ли в массиве данное число // вызывается list.isCase(x)
                println 4
                break
            default:
                println "None"
                break
        }

        if (x in [1,2,3,4,5]){  // также используется метод list.isCase(x)
            println x
        }
    }
}
