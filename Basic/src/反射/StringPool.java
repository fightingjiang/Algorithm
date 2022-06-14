package 反射;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

public class StringPool implements B1,B2{
    public static void main(String[] args) {
        new HashMap<>();
        Hashtable<Object, Object> hashtable = new Hashtable<>();
    }
}


abstract class A1{
    static void fun(){
        System.out.println("aa");
    }

}

abstract class A2{

}

interface B1{
    int age =10;
    static void fun(){
        System.out.println("aa");
    }

    default void fun2(){
        System.out.println("aa");
    }
}

interface B2{

}