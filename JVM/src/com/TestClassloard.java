package com;

import java.lang.reflect.Field;

public class TestClassloard {
    public static void main(String[] args) throws Exception {
        System.out.println(TestClassloard.class.getClassLoader().loadClass("com.Person"));
    }
}
