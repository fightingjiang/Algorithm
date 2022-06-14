package MyThreadPool;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 阻塞队列<T> {
    //存储task的队列  先进先出
    private Deque<T> blockingQueue;
    //队列容量
    int capacity;
    //锁 加入task的锁和拉取task的锁
    private ReentrantLock lock;
    //阻塞队列满  不能再添加
    Condition fullQueue;
    //阻塞队列空 不能读
    Condition emptyQueue;

    public 阻塞队列(int capacity) {
        this.capacity = capacity;
        blockingQueue = new ArrayDeque<>(capacity);
        lock = new ReentrantLock();
        fullQueue = lock.newCondition();
        emptyQueue = lock.newCondition();
    }

    public T take(){
        //取操作时先对队列上锁
        lock.lock();
        try {
            //如果阻塞队列为空  则进入emptyQueue条件变量中等待
            while (blockingQueue.isEmpty()){
                try {
                    System.out.println("阻塞队列当前为空，没有task可以取...");
                    emptyQueue.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T task = blockingQueue.removeFirst();
            System.out.println("取到了task...fullQueue可以被唤醒");
            //取走了任务
            fullQueue.signalAll();
            return task;
        }finally {
            lock.unlock();
        }
    }

    public void put(T task){
        lock.lock();
        try {
            //如果阻塞队列已满  则进入fullQueue等待
            while (blockingQueue.size()==capacity){
                System.out.println("阻塞队列当前满了，task不可以存...");
                try {
                    fullQueue.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("来阻塞队列存了..."+task);
            blockingQueue.add(task);
            emptyQueue.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
