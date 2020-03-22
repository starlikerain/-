package com.company;

import java.io.Serializable;

public class Person implements Serializable {
//    private static final long serialVersionUID = 1L;
//    private static final long  = 1L;

    String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
