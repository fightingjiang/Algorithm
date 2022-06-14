package MyThreadPool;

import java.util.HashSet;

public class 自定义线程池 {
    //有一个阻塞队列
    阻塞队列<Runnable> blockingQueue;
    //有一个存放线程池的池子  池子中的是workers
    HashSet<Worker> workers;
    //核心线程数
    private int coreSize;

    public 自定义线程池(int coreSize,int capacity) {
        this.coreSize = coreSize;
        blockingQueue = new 阻塞队列(capacity);
        workers = new HashSet<>();
    }

    public void execute(Runnable task) {
        synchronized (workers) {
            //小于核心线程数  创建worker取执行task 并加入线程池
            if(workers.size()<coreSize){
                Worker worker = new Worker(task);
                workers.add(worker);
                worker.start();
            }else {
                System.out.println("线程池中线程已用完，加入阻塞队列中等待");
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
}

class Ceshi{
    public static void main(String[] args) throws InterruptedException {
        自定义线程池 threadPool = new 自定义线程池(3,5);
        for (int i = 0; i < 10; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行线程----"+Thread.currentThread().getName()+"  ");
                    System.out.println(Thread.currentThread().getName()+"需要执行1s ");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}