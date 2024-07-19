package com.gorbunov.lesson8

import java.util.regex.Matcher
import java.util.regex.Pattern

class RegexRunner {
    static void main(String[] args) {
        String value = "one 1 two 22 three 333"
        String regexJava = "\\w+ \\d+"
        String regexJavaGroup = "(\\w+) (\\d+)"
        String regexGroovy = /\w+ \d+/

        Pattern patternJava = Pattern.compile(regexJava)
        Pattern patternJavaGroup = Pattern.compile(regexJavaGroup)
        Pattern patternGroovy = Pattern.compile(regexGroovy)
        // все 3 варианта выше можно записать через ~:
        patternJava = ~regexJava
        patternJavaGroup = ~regexJavaGroup
        patternGroovy = ~regexGroovy

        Matcher matcherJava = patternJava.matcher(value)
        Matcher matcherJavaGroup = patternJavaGroup.matcher(value)
        Matcher matcherGroovy = patternGroovy.matcher(value)
        //Matcher объекты можно создавать без объектов Pattern с помощью следующего синтаксиса:
        matcherJava = value =~ regexJava
        matcherJavaGroup = value =~ regexJavaGroup
        matcherGroovy = value =~ regexGroovy

        //1 matches используют для полного соответствия. Номер телефона или email и тд
        def matchesJava = matcherJava.matches()
        def matchesGroovy = matcherGroovy.matches()
        println matchesJava
        println matchesGroovy
        //Данный вариант можно упростить не используя ни объектов Matcher ни Pattern
        matchesJava = value ==~ regexJava
        matchesGroovy = value ==~ regexGroovy
        println matchesJava
        println matchesGroovy

        //2 Поиск подтекстов в тексте
        while (matcherJava.find()) {
            println matcherJava.group()
        }

        while (matcherJavaGroup.find()) {
            println '------------------'
            println matcherJavaGroup.group()
            println matcherJavaGroup.group(1)
            println matcherJavaGroup.group(2)
        }
        //Работу с группами тоже упростили. Можно работать через массив(вернет все подстроку и ее группы в масиве)
        println matcherJavaGroup[0]
        println matcherJavaGroup[1]
        println matcherJavaGroup[2]
        //Результат:
//        [one 1, one, 1]
//        [two 22, two, 22]
//        [three 333, three, 333]
        // Если я хочу получить например 22(то есть из первого массива второй элемент
        println matcherJavaGroup[1][2]
        //отображает 2 массива вхождений в еще одном массиве
        println matcherJavaGroup[1..2]

        matcherJavaGroup.each(group -> { println group })
        matcherJavaGroup.each((group, group1, group2) -> {
            println group
            println group1
            println group2
        })
    }
}
