package JUC.线程方法.自定义线程池;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 20:33 2021/7/13
 */
public class BlockingQueue<T> {
    //1.任务队列
    private Deque<T> queue =  new ArrayDeque<>();

    //2.锁
    private ReentrantLock lock = new ReentrantLock();

    //3.生产者条件变量
    private Condition fullWaitSet = lock.newCondition();

    //4.消费者条件变量
    private Condition EmptyWaitSet = lock.newCondition();

    //5. 容量
    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    //获取
    public T take(){
        lock.lock();
        try {
            while (queue.isEmpty()){
                try {
                    EmptyWaitSet.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = queue.removeFirst();
            fullWaitSet.signal();
            return t;
        }finally{
            lock.unlock();
        }
    }

    //添加
    public void put(T task){
        lock.lock();
        try {
            while (queue.size()==capacity){
                try {
                    fullWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.addLast(task);
            EmptyWaitSet.signal();
        }finally{
            lock.unlock();
        }
    }

}
