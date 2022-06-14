package Singleton;

public class Singleton03 {
    private  Singleton03() {

    }

    private static volatile Singleton03 instance;

    public static Singleton03 getInstance(){
        //双重检测   懒汉式
        if(instance==null){
            synchronized (Singleton03.class){
                if (instance==null){
                    instance = new Singleton03();
                }
            }
        }
        return instance;
    }
}
