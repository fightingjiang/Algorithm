package Singleton;



public class Main {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Singleton04.getInstance().hashCode());
            }).start();
        }
    }
}
