package Singleton;

public class Singleton04 {
    private Singleton04() {

    }

    //静态内部类
    private static class SingletonINSTANCE{
        private static final Singleton04 instance =  new Singleton04();
    }

    public static Singleton04 getInstance(){
        return SingletonINSTANCE.instance;
    }

}
