//先打印a再打印b
public class ABWaitNotify {
    static Object lock = new Object();
    static boolean t2runed = false;

    //A等B先打印  先打印2在打印1
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock){
                while (!t2runed){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("1");
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println("2");
            synchronized (lock){
                t2runed = true;
                lock.notifyAll();
            }
        });

        t1.start();
        t2.start();
    }
}
