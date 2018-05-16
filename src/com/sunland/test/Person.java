package com.sunland.test;

import java.io.Serializable;

public class Person implements Cloneable,Serializable{
    static int age;
    String name;
    protected String sex;
    static Person person = new Person("wangzn");
    static {
        System.out.println("person init");
    }

    public class Man{

    }

    public static Man crateMan(){
        return new Person().new Man();
    }

    public static void testStatic(){
        System.out.println("test static");
    }

    public Person(String name) {
        this.name = name;
        System.out.println("static test init constusor");
    }

    public Person() {
    }


    @Override
    protected Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }
}
