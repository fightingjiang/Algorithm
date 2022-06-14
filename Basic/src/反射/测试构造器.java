package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class 测试构造器 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<A> aClass = A.class;
        Constructor<A> constructor = aClass.getConstructor(String.class);
        A jiangzhihao = constructor.newInstance("jiangzhihao");
    }
}

class A{

    public A(String string) {
        System.out.println(string);
    }
}