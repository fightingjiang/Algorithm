package JVM;

import com.Class;

public class TestClassLoard {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
//        Class aclass = Class01.class;
        Class01.fun();
//        System.out.println(Class01.age);
//        aclass.newInstance();
    }
}

class Class01{
    public String name = "jiangzhihao";
    static {
        System.out.println("jingtaidaimakuai...");
    }
    public Class01() {
        System.out.println(name);
        System.out.println("gouzaoqi...");
    }

    static void fun(){
        System.out.println("fun...");
    }
    static final int age = 20;
}