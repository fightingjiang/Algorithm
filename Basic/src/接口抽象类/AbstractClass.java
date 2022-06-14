package 接口抽象类;

public abstract class AbstractClass {
    abstract void fun();
    private void fun1(int a ){
        System.out.println(a);
    }

    public AbstractClass() {
    }
}


interface P1{
    void fun3();
    default void fun4(){

    }
    int a = 0;
}

