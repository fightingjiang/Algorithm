public abstract class AbstractClassTest {
    int age;
    static String name;
    public void fun(){
        System.out.println("aaa");
    }
}

interface TestInterface{
    String name = "a";

    void fun01();

    default void fun(){
        System.out.println("aaa");
    }
}

class MyClass implements TestInterface{

    @Override
    public void fun01() {

    }
}