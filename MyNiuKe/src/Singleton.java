public class Singleton {
    private volatile static Singleton Instance;

    private Singleton() {
    }

    public static Singleton getInstance(){
        //单例模式的线程安全只发生在第一次初始化时，加锁解锁会消耗时间，后续getInstance获取实例对项时直接判断即可
        if(Instance==null){
            //加锁操作  保证只有一个线程能操作singleton
            synchronized (Singleton.class){
                //第二次判断，因为instance被volatile修饰，所以此次去读时要去主内存空间度而不是线程的高速缓存中，为空才区new，否则直接返回已经new好的instance即可
                if(Instance==null){
                    Instance = new Singleton();
                }
            }
        }
        return Instance;
    }
}
