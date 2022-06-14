public final class Singleton {
    private Singleton(){}
    private static volatile Singleton singleton ;
    public static Singleton getInstance(){
        if(singleton==null){
            //首次访问会加锁，之后不会
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
