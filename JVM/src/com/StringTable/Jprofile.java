package com.StringTable;


import com.Person;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Jprofile {

    public static void main(String[] args) {
        String s = new String("a") + new String("b");
        String ab = new String("abc");
        String s2 = "abcd";
        Person person = new Person();
        SoftReference softReference = new SoftReference<Person>(person);
        WeakReference<Person> personWeakReference = new WeakReference<>(person);
        ReferenceQueue<Person> phantomQueue = new ReferenceQueue<>();
        PhantomReference<Person> personPhantomReference = new PhantomReference<Person>(person,phantomQueue);
        test01();
    }

    public static void test01(){
        System.out.println("nihao");
    }

    static {
        System.out.println("我先加载");
    }
}
