package JUC.线程方法.单例;

/**
 * @Author: jiangzhihao
 * @Description:  饿汉单例   静态变量
 * @Data: create in 17:35 2021/7/15
 */
public class Singleton1 {
    public Singleton1() {
    }

    private final static Singleton1 INSTANCE = new Singleton1();

    public static Singleton1 getInstance(){
        return INSTANCE;
    }
}
