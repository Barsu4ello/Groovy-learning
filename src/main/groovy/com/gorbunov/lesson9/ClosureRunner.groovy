package com.gorbunov.lesson9

import com.gorbunov.lesson6.Men
import org.apache.tools.ant.taskdefs.optional.sos.SOS

import java.util.stream.Stream
import java.util.function.Function

class ClosureRunner {

    static void main(String[] args) {
        Function<Integer, Integer> function = value -> value + value

        def result = function.apply(5)
        println result
        Closure closure = { value ->
            println value
            value + value // не нужен return для более 2 строк
        }
        Closure closure2 = {
            println it   // ключевое слово it если один параметр на вход в замыкании то it = параметр на вход
            it + it // не нужен return для более 2 строк
        }
        Closure closure3 = { ->
            //если параметров нет, то нужна стрелочка. Она указывает на то, что мы не можем в это замыкание передать параметров
            println it
            it + it
        }
        Closure closure4 = { value = 78, val2 -> // дефолтные параметры, если параметр не передадут, то используется это значение
//            println it
            value + value
        }
        def call = closure.call(5)
        def call2 = closure(5) // сокращенный вариант записи closure.call(5)
        println call
        println call2
        println closure4(12, 12)

        Stream.of(1, 2, 3, 4)
                .map(function)
                .map(closure)
//        .map(String::valueOf)
                .map(String.&valueOf) // этот метод уже возвращает Closure
                .forEach(System.out::println)
        int x = 10
        check(x > 0, { println (++x) })
        // если последний параметр метода типа Closure, можно передать список первых аргументов в скобках а потом в {} записать Closure
        check(x > 0, 12) {
            println (++x)
        }

        println x
    }

    static def check(boolean condition, Closure closure) {
        if (condition) {
            closure()
        }

    }
}
