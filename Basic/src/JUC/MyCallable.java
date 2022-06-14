package JUC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class MyCallable implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("123");
        return 123;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> task = new FutureTask<Integer>(myCallable);
        Thread thread = new Thread(task);
        thread.start();
        System.out.println(task.get());

        System.out.println(Thread.currentThread().getName().toString());
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName().toString());
            }
        });
        thread1.start();
        thread1.join();
        Thread thread2 = new Thread(new MyRunnable());
        thread2.start();
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.interrupt();
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
            System.out.println(Thread.currentThread().getName().toString());
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName().toString());
        }
    }
}