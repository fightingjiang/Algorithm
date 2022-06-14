package JUC;

public class Singleton {
    private static volatile Singleton Instance;

    public Singleton() {
    }
    public static Singleton getInstance(){
        if(Instance==null){
            synchronized (Singleton.class){
                if(Instance==null){
                    Instance = new Singleton();
                }
            }
        }
        return Instance;
    }
}


//饿汉式
class HungrySingleton{
    private static HungrySingleton Instance = new HungrySingleton();

    public HungrySingleton() {
    }

    public static HungrySingleton getInstance(){
        return Instance;
    }

}

//静态内部类
class Singleton01{
    private static class SingletonHolder{
        private static final Singleton01 Instance = new Singleton01();
    }

    public Singleton01() {
    }

    public static final Singleton01 getInstance(){
        return SingletonHolder.Instance;
    }
}