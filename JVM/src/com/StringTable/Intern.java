package com.StringTable;

import com.Person;

import java.util.HashMap;

public class Intern {

    private static String s1 = "jiang";


    public static void main(String[] args) {

        int jiasi = 10;
        Person person = new Person();
        new Object();
        person.setName("zhihao");
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(1,person);

        sout();
    }

    public static void sout(){

        String s2 = new String("jiang");
        String s3 = s2.intern();
        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s2==s3);
        String s6 = "ab";
        String s4 = new String("a")+new String("b");
        String s5 = s4.intern();
        System.out.println(s6==s5);

        System.out.println("*****");
    }
}
