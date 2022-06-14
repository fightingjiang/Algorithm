import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
    private static Lock lock1 = new ReentrantLock();
    private static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (lock1){
                System.out.println("i have lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("i want to have lock2。。。");
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName()+"  i have lock2...");
                }
            }
        }).start();
        new Thread(()->{
            synchronized (lock2){
                System.out.println("i have lock2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("i want to have lock1。。。");
                synchronized (lock1){
                    System.out.println(Thread.currentThread().getName()+"  i have lock1...");
                }
            }
        }).start();

    }
}
