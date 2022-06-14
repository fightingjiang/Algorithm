public class WaitNotify {
    static boolean condition1 = false;
    static Object lock = new Object();
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    while (!condition1){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println("2");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
                synchronized (lock){
                    condition1 = true;
                    lock.notifyAll();
                }
            }
        }).start();
    }
}
