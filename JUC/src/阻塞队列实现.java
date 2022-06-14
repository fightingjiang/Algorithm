import javafx.concurrent.Task;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 阻塞队列实现<T> {
    //数据结构
    Deque<T> blockingQueue;
    //阻塞队列大小
    int capacity;
    //锁
    ReentrantLock lock;
    //条件变量
    Condition emptyQueue;
    Condition fullQueue;

    public 阻塞队列实现(int capacity) {
        this.capacity = capacity;
        blockingQueue = new ArrayDeque<>(capacity);
        lock = new ReentrantLock();
        emptyQueue = lock.newCondition();
        fullQueue = lock.newCondition();
    }

    public T take(){
        lock.lock();
        try {
            while (blockingQueue.isEmpty()){
                try {
                    emptyQueue.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T task = blockingQueue.removeFirst();
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
                    fullQueue.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            blockingQueue.add(task);
            emptyQueue.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
