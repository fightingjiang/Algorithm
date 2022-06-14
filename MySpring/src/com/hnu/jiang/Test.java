package com.hnu.jiang;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println("four...获取对象实例");
        System.out.println(person.name);
    }
}
