package com.gorbunov.lesson7;

public class Test {

    public static void main(String[] args) {
        String value = """
                test
                123
                456
                ''
                ""
                """;

        System.out.println(value);

        String value1 = "Hello";
        String value2 = "Hello $value1";
    }
}
