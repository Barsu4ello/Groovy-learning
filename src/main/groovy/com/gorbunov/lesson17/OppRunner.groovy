package com.gorbunov.lesson17

class OppRunner {

    static void main(String[] args) {
        def student = new Student()
        student.firstName = "Vlad" // под капотом setFirstName("Vlad")
        println student.firstName  // под капотом getFirstName()
        println student['firstName']
        println student.'firstName'
        println student.@firstName  // Обращение на прямую к полю (не рекомендуется)

        //Даже без конструктора для всех полей можно передавать значения полей, как в Map
        //Сначала под капотом вызывается конструктор без параметров, далее вызываются соответствующие set методы
        def student1 = new Student(firstName: "Vlad", secondName: "Ivanov", age: 11, id: 22)
        println student1

        student1.properties.each { println it}

        // Это Coercion(Принуждение)
        Student student2 = ['Pal', 'Palish', 10] // но тут нужен конструктор на 3 параметра и явно указать в левой части тип данных
        println student2

        // Чтобы это работало, надо переопределить метод getAt(Integer index) чтобы Groovy понимал под каким индексом какое свойство класса находится
        def (fn, ln) = student2
        println fn
        println ln

        assert  [student1, student2].collect{it.firstName} == ['Vlad', 'Pal']
        assert [student1, student2]*.firstName == ['Vlad', 'Pal']

        // Mixin еще работают с классами для привнесения нового функционала через метод mixin. К классу String добавляются все статические методы OppRunner
        // Обычно используется при запуске приложения, потому что добавляет функционал в класс глобально по всему коду.
        String.mixin(OppRunner.class)
        "Vlad".printStr()
    }

    static def printStr(String self) {
        println "It's mixin $self"
    }
}
