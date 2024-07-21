package com.gorbunov.lesson14

class MapRunner {

    static void main(String[] args) {
        def map = [one: 1, "two": 2] // скобки можно опустить для ключей строк, но не для значений
        println map
        assert map.getClass() == LinkedHashMap

        def emptyMap = [:] //пустая мапа вместо new LinkedHashMap

        //read
        assert map.get("one") == 1
        assert map["one"] == 1
        assert map."one" == 1
        assert map.one == 1 // скобки можно опустить только для строки
        assert map.getOrDefault("three", 10) == 10 // Java
        // Groovy (тут просто метод перегружен) Но надо понимать, что в Java getOrDefault вернет просто defaultVal и не вставится в карту,
        // а в Groovy это значение вставится в карту
        assert map.get("default", 10) == 10

        //write
        map.one = 111
        map."one" = 112
        map["one"] = 113
        assert map.one == 113

        // new method
        map["three"] = 3
        assert map.subMap("one", "two") == [one: 113, "two": 2]

        //new operator Spread
        def newMap = ["i": 5, "j": 6, *: map]// Удобнее чем putAll() в Map в Java
        println newMap
        // Перезапишет значение под ключом three на 6.
        def newMap2 = ["i": 5, *: map, "three": 6]
        println newMap2
        //Если  "three":6 будет до *:map, то значение перезапишется значением из map
        def newMap3 = ["i": 5, "three": 6, *: map]
        println newMap3
    }
}
