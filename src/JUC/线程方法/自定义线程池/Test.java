package JUC.线程方法.自定义线程池;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 21:46 2021/7/13
 */
public class Test {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
    }
}
