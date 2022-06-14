package JUC.线程方法.自定义线程池;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 13:58 2021/7/14
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+threadLocal.get());
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+threadLocal.get());
                threadLocal.set(2);
                System.out.println(Thread.currentThread().getName()+threadLocal.get());
            }
        });
        t1.start();
        t2.start();
        System.out.println(1);
    }
}
