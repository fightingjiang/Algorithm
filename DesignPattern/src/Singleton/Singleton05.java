package Singleton;


//枚举
enum Singleton05{
    INSTANCE;
    public void sayOK(){
        System.out.println("~ok");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Singleton05.INSTANCE.hashCode());
            }).start();

        }
    }
}