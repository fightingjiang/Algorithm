public class 先打印A再打印BWaitNotify_01 {
    static Object lock = new Object();
    static boolean flag = true;
    public static void main(String[] args) {
        new Thread(()->{
            synchronized (lock){
                while (flag){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("B");
            }
        }).start();
        new Thread(()->{
            synchronized (lock){
                System.out.println("A");
                flag = false;
                lock.notifyAll();
            }
        }).start();

    }
}
