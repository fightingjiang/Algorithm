package Singleton;

public class Singleton01 {

    //私有化构造器
    private Singleton01(){

    }
    //本类内部创建对象实例
    private final  static Singleton01 instance = new Singleton01();

    //提供一个公有的静态方法，返回实例对象
    public static Singleton01 getInstance(){
        return instance;
    }

}
