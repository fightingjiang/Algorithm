package com;

import java.lang.reflect.Constructor;

public class Class {
    public static void main(String[] args) throws NoSuchMethodException {
        Person person = new Person();
        java.lang.Class<? extends Person> aClass = person.getClass();
        try {
            Person person1 = aClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Constructor<? extends Person> constructor = aClass.getConstructor();


    }
}
