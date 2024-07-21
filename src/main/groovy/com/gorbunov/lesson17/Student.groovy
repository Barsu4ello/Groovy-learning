package com.gorbunov.lesson17

import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode
import groovy.transform.Immutable
import groovy.transform.ToString
import groovy.transform.TupleConstructor
import groovy.transform.builder.Builder
import groovy.util.logging.Slf4j

//Аннотации  groovy.transform.* очень похожи на Lombok
@ToString
// Создает конструкторы на любое количество параметров (То есть будет 3 конструктора на первый параметр, первый и второй, первый и второй и третий
// Но не создаст конструктора, чтобы передать только возраст или secondName
//@TupleConstructor
//@Mixin(WithId.class) то же самое что Trait но уже Deprecated
@EqualsAndHashCode
//@Canonical  // вкл в себя: @ToString @TupleConstructor @EqualsAndHashCode
@Immutable // Делает все поля final. Перетирает @TupleConstructor и оставляет только конструктор по молчанию, со всеми аргументами и мапой.
@Builder
//@Slf4j // Но надо подключить логер в зависимостях
class Student implements WithId{
    String firstName
    String secondName
    Integer age

    def getAt(Integer index) {
        index == 0 ? firstName : secondName
    }

    static void main(String[] args) {
//        Student.builder()
//        .firstName("V")
//        .secondName("V2")
//        .build()
    }
}
