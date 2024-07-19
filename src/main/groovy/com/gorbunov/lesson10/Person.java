package com.gorbunov.lesson10;

public class Person {

    private final Integer id;

    public Person(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public boolean asBoolean() {
        return id > 10;
    }

    public boolean isCase(Object switchValue) {
        System.out.println("Invoke isCase: " + switchValue);
        return false;
    }
}
