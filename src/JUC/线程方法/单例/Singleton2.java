package JUC.线程方法.单例;

/**
 * @Author: jiangzhihao
 * @Description:   静态内部类
 * @Data: create in 17:44 2021/7/15
 */
public class Singleton2 {
    private Singleton2() {
    }
    private static Singleton2 INSTANCE;
    static{
        INSTANCE = new Singleton2();
    }
    public static Singleton2 getInstance(){
        return INSTANCE;
    }
}
