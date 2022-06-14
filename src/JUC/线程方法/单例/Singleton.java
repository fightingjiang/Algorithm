package JUC.线程方法.单例;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 17:28 2021/7/15
 */
public class Singleton {
    //双重锁校验机制   懒汉式
    private static volatile Singleton INSTANCE = null;

    private Singleton() {
    }

    public static Singleton getINSTANCE(){
        if(INSTANCE==null){
            synchronized (Singleton.class){
                if(INSTANCE==null){
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}
