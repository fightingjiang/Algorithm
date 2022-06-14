package com.hnu.jiang;

import org.springframework.stereotype.Component;

@Component(value = "stu")
public class Student {
    String name = "ahdiuwa";

    public void fun(){
        System.out.println("student....");
    }
}
