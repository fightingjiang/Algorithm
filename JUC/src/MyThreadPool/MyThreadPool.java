package MyThreadPool;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyThreadPool {
    //一个阻塞队列
    MyBlockingQueue<Runnable> blockingQueue;

    //一个放执行线程worker的容器
    HashSet<Worker> workers = new HashSet<>();

    private int coreSize;

    public MyThreadPool(int coreSize,int capacity) {
        this.coreSize = coreSize;
        blockingQueue = new MyBlockingQueue<Runnable>(capacity);
    }

    public void execute(Runnable task){
        synchronized (workers){
            if(workers.size()<coreSize){
                Worker worker = new Worker(task);
                workers.add(worker);
                worker.start();;
            }else {
                System.out.println("线程池中线程已用完，请稍等。。");
                blockingQueue.put(task);
            }
        }
    }

    class MyBlockingQueue<T>{
        //阻塞队列
        private Deque<T> queue;

        //阻塞队列容量
        private int capacity;

        //锁    阻塞队列代码是临界区代码
        private ReentrantLock lock ;
        private Condition empty ;
        private Condition full ;

        public MyBlockingQueue(int capacity) {
            this.capacity = capacity;
            queue = new ArrayDeque<>(capacity);
            lock = new ReentrantLock();
            empty = lock.newCondition();
            full = lock.newCondition();
        }

        public void put(T task){
            lock.lock();
            try {
                while (queue.size()==this.capacity){
                    try {
                        //阻塞队列已满   请求执行线程去fullSet condition中先阻塞
                        System.out.println("阻塞队列已满   请求执行线程去fullSet condition中先阻塞");
                        full.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.add(task);
                empty.signalAll();
            }finally {
                lock.unlock();
            }
        }

        public T take(){
            lock.lock();
            try {
                while (queue.isEmpty()){
                    //阻塞队列为空   执行线程先去empty中等
                    System.out.println("阻塞队列为空   执行线程先去empty中等 ");
                    try {
                        empty.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("取得task  阻塞队列有空间了");
                T task = queue.removeFirst();
                System.out.println("唤醒fullCondition");
                full.signalAll();
                return task;
            }finally {
                lock.unlock();
            }
        }
    }

    class Worker extends Thread{
        Runnable task;

        public Worker(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            while (task!=null||(task = blockingQueue.take())!=null){
                task.run();
            }
        }
    }
}
