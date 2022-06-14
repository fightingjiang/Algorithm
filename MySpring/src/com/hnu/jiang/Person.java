package com.hnu.jiang;

public class Person {
    String name ;

    public Person() {
        System.out.println("one...无参构造");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("two...set方法");
    }

    public void fun(){
        System.out.println("three...执行初始化方法");
    }

    public void fun1(){
        System.out.println("three...执行初始化方法");
    }

    public Person(String name) {
        this.name = name;
    }
}
