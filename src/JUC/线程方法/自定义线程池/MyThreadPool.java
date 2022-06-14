package JUC.线程方法.自定义线程池;


import java.util.HashSet;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 20:52 2021/7/13
 */
public class MyThreadPool {
    //阻塞队列
    private BlockingQueue<Runnable> taskQueue;

    // 线程集合
    private HashSet<Worker> workers = new HashSet<>();

    // 核心线程数
    private int coreSize;

    public MyThreadPool(BlockingQueue<Runnable> taskQueue, int coreSize) {
        this.taskQueue = taskQueue;
        this.coreSize = coreSize;
    }

    public void execute(Runnable task){
        synchronized (workers){
            if(workers.size()<coreSize){
                Worker worker = new Worker(task);
                workers.add(worker);
                worker.start();
            }else {
                // 1) 死等
                // 2) 带超时等待
                // 3) 让调用者放弃任务执行
                // 4) 让调用者抛出异常
                // 5) 让调用者自己执行任务
                taskQueue.put(task);
            }
        }
    }

    //worker类
    class Worker extends Thread{
        private Runnable task;

        public Worker(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            while (task!=null){
                try {
                    task.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    task=null;
                }
            }
            synchronized (workers) {
                workers.remove(this);
            }
        }
    }


}
