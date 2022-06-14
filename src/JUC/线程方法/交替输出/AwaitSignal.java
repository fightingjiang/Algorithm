package JUC.线程方法.交替输出;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 20:46 2021/7/15
 */
public class AwaitSignal extends ReentrantLock {
    public void start(Condition first) {
        this.lock();

    }
}