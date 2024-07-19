package com.gorbunov.lesson6;

public class Men {
   public int age;

    public Men(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Men men = (Men) o;
        return age == men.age;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(age);
//    }
}