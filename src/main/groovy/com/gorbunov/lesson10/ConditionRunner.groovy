package com.gorbunov.lesson10

class ConditionRunner {
    /**
     *
     * boolean  is true
     * Collection/Map  is empty
     * Matcher  Если есть хоть одно вхождение, то будет true
     * String/GString  is empty
     * Number/Char  != 0 && != null
     * reference  != null
     *
     * Это работает за счет определения функции asBoolean()
     */
    static void main(String[] args) {
        def x = 10
        boolean booleanResult = x > 0
        if(booleanResult) {
            println x
        }
        if(x){
            println 'Number != 0'
        }

        Person person = new Person(11)
        if(person) {
            println "Person id: ${person.getId()}"
        }

        //Новый оператор для защиты от NullPointerException
        Person person2 = null
        //Обычно писали так:
        if(person2 != null) {
            person2.getId()
        }
        // В Groovy проще:
        println person2?.getId() // Это вернет null если person2 = null

        //Оператор Элвиса ?:   Проверяет на null. Если выражение или объект возвращает false то будет использовано дефолтное значение, указанное после ?:
        def y = 0
        println y ?: 2
    }
}
