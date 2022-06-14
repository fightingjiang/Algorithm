package JUC.线程方法;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 20:23 2021/7/12
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger a = new AtomicInteger(1);
        Thread t1 = new Thread(() -> {
            System.out.println(1);
        });
        System.out.println(2);
        LockSupport.unpark(t1);
        t1.join();
        t1.wait(1000);
        Thread.sleep(1000);
    }
}
