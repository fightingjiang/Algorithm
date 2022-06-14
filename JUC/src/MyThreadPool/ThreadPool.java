package MyThreadPool;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPool {

    //有一个阻塞队列
    private BlockingQueue<Runnable> blockingQueue;

    //放线程的池子   一般用容器存着workers
    HashSet<Worker> workers = new HashSet<>();

    //核心线程数
    private int coreSize;
    public ThreadPool(int coreSize, int capacity) {
        this.coreSize = coreSize;
        blockingQueue = new BlockingQueue<>(capacity);
    }

    public void execute(Runnable task) {
        synchronized (workers) {
            // 创建任务
            // 池中还有空余线程时，可以运行任务
            // 否则阻塞
            if (workers.size() < coreSize) {
                Worker worker = new Worker(task);
                workers.add(worker);
                System.out.println("开始执行线程");
                worker.start();
            } else {
                System.out.println("线程池中线程已用完，请稍等");
                blockingQueue.put(task);
            }
        }
    }

    class Worker extends Thread{
        Runnable task;
        public Worker(Runnable task){
            this.task = task;
        }

        @Override
        public void run() {
            // 如果有任务就执行
            // 如果阻塞队列中有任务，就继续执行
            while (task!=null||(task = blockingQueue.take())!=null){
                    task.run();
                    //任务执行完成
                    task = null;
            }

        }
    }

    class BlockingQueue<T>{
        //阻塞队列
        private Deque<T> blockingQueue;

        private int capacity;

        private ReentrantLock lock;

        private Condition fullQueue;
        private Condition emptyQueue;

        public BlockingQueue(int capacity) {
            this.capacity = capacity;
            lock = new ReentrantLock();
            fullQueue = lock.newCondition();
            emptyQueue = lock.newCondition();
            blockingQueue = new ArrayDeque<>(capacity);
        }

        public T take(){
            lock.lock();
            try {
                //如果阻塞队列为空，没有任务就一直等待
                while (blockingQueue.isEmpty()){
                    try {
                        //阻塞队列空的   没有取出线程来执行  所以执行的任务的线程需要阻塞
                        emptyQueue.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                T task = blockingQueue.removeFirst();
                System.out.println("来阻塞队列取了。。。"+task);
                fullQueue.signalAll();
                return task;
            }finally {
                lock.unlock();
            }
        }

        public void put(T task){
            lock.lock();
            try {
                while (blockingQueue.size()==capacity){
                    try {
                        //阻塞队列满了  放入的线程需要阻塞
                        fullQueue.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("来阻塞队列存了。。。"+task);
                blockingQueue.add(task);
                emptyQueue.signalAll();
            }finally{
                lock.unlock();
            }
        }

        public int getSize(){
            lock.lock();
            try {
                return blockingQueue.size();
            }finally {
                lock.unlock();
            }
        }
    }
}

class Demo{
    static int i;
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(2, 4);
        for ( i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadPool.execute(()->{
                System.out.println(i);
            });
        }
    }
}
