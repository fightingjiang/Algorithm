package JUC.线程方法.自定义线程池;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 21:57 2021/7/13
 */
public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(()->{
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName());
        }).start();
        new Thread(()->{
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName());
        }).start();
        new Thread(()->{
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName());
        }).start();
        countDownLatch.await();
    }
}
