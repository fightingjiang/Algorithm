package JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLock {
    static volatile boolean hasCigrette = false;
    static volatile boolean hasBreakfast = false;
    static ReentrantLock lock = new ReentrantLock();
    static Condition hasCigaretteQueue = lock.newCondition();
    static Condition waitbreakfastQueue = lock.newCondition();
    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (!hasCigrette){
                        try {
                            hasCigaretteQueue.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("烟来了...开始干活...");
                }finally {
                    lock.unlock();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (!hasBreakfast){
                        try {
                            waitbreakfastQueue.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("早餐来了...开始干活...");
                }finally {
                    lock.unlock();
                }

            }
        }).start();

        Thread.sleep(1000);
        sendBreakfast();
        Thread.sleep(1000);
        sendCigarette();

    }

    private static void sendCigarette() {
        lock.lock();
        try {
            System.out.println("送烟来了");
            hasCigrette = true;
            hasCigaretteQueue.signal();
        } finally {
            lock.unlock();
        }
    }

    private static void sendBreakfast() {
        lock.lock();
        try {
            System.out.println("送早餐来了");
            hasBreakfast = true;
            waitbreakfastQueue.signal();
        } finally {
            lock.unlock();
        }
    }

}
