package com.hnu.jiang;


import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAno {
    public static void main(String[] args) {
        AbstractXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Teacher teacher = context.getBean("teacher", Teacher.class);
        teacher.teach();
    }

}


