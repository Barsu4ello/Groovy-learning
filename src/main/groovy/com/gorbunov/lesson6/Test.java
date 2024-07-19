package com.gorbunov.lesson6;

public class Test {
    public static void main(String[] args) {
        Men men1 = new Men(5);
        Men men2 = new Men(5);
        System.out.println(men1 == men2);

        boolean b = !false;
        System.out.println(b);
    }
}
