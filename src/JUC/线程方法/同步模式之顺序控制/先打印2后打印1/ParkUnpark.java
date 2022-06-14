package JUC.线程方法.同步模式之顺序控制.先打印2后打印1;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 17:57 2021/7/15
 */
public class ParkUnpark {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            LockSupport.park();
            System.out.println(1);
        });
        Thread t2 = new Thread(() -> {
            System.out.println(2);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.unpark(t1);
        });
        t1.start();
        t2.start();
    }
}
