package com.gorbunov

import groovy.transform.PackageScope

class HelloWorld { // по умолчанию public классы и методы

    Integer value // по умолчанию private все поля
//    @PackageScope
    static void main(String[] args) {
        String val = "HEl"
        Class<String> clazz = val.getClass();
        println "Hello world" // можно со скобками, можно без скобок
        println clazz.getClassLoader()
        println HelloWorld.class.getClassLoader()
    }
}
