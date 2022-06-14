public class 死锁 {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1){
                    try {
                        Thread.sleep(50);
                        synchronized (lock2){
                            System.out.println("i have lock1 and lock2...");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2){
                    try {
                        Thread.sleep(50);
                        synchronized (lock1){
                            System.out.println("i have lock1 and lock2...");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
