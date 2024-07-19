package com.gorbunov.lesson5;

import java.math.BigDecimal;
import java.util.Objects;

import static org.codehaus.groovy.runtime.ScriptBytecodeAdapter.compareTo;


public class Test {
    public static void main(String[] args) {
        int val = 5;
        Integer val2 = 5;
        Long val3 = 7L;
        BigDecimal val4;
        System.out.println(val2.getClass());
        Integer i = 130;
        Integer i2 = 130;
        System.out.println(i == i2);
    }
}

