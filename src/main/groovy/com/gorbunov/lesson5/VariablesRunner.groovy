package com.gorbunov.lesson5

import groovy.transform.CompileStatic

import java.sql.Date as SqlDate

class VariablesRunner {


//    static def main(String[] args) {
//    @CompileStatic // включает статическую компиляцию иначе ошибок не увидишь
    static void main(String[] args) {
       // def value = 5// тоже самое что и int value = 5 (def можно использовать и в любых местах, даже в типе возвращаемого метода) в скриптах def можно опустить
        int value = 5
        println value.class
        Integer val = 5
        println val.class
        BigDecimal value4 = 36
        println value4.class
        new SqlDate(12,12,12)
    }
}
