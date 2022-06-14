package Singleton;

public class Singleton02 {
    private Singleton02() {

    }
    private  static  Singleton02 instance ;

    //静态代码块   饿汉式
    static {
        instance = new Singleton02();
    }

    public static Singleton02 getInstance(){
        return instance;
    }
}
