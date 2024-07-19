package com.gorbunov.lesson12

class LoopRunner {
    static void main(String[] args) {
//        while / for
        def list = [1,2,3,4]
        //FOR
        //JAVA
//        for(int i = 0; i < list.size(); i++) {
//
//        }
        //GROOVY
//        for (i in 0..list.size()) { //<=
//            println i
//        }
//        for (i in 0..<list.size()) { //<
//            println i
//        }
//        FOREACH
        //JAVA
//        for(Integer i : list) {
//            println i
//        }
        //GROOVY
//        for(i in list) {
//            println i
//        }
        //Циклы через замыкание
        // По возрастающей
//        0.upto(list.size()) {
//            println it
//        }
        // По убывающей
//        list.size().downto(0) {
//            println it
//        }
        //От 0 до list.size() не включительно
//        list.size().times {
//            println it
//        }
        //step задает шаг (не включает верхнюю границу)
        0.step(5, 2) {
            println it
        }
    }
}
