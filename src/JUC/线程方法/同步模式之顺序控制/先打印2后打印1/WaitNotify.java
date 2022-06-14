package JUC.线程方法.同步模式之顺序控制.先打印2后打印1;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 17:49 2021/7/15
 */
public class WaitNotify {
    static Object obj = new Object();
    static boolean flag = false;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                //如果t2还没执行完，则wait(),while是防止虚假唤醒
                while (!flag) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(1);
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (obj) {
                System.out.println(2);
                flag = true;
                obj.notifyAll();
            }
        });
        t1.start();
        t2.start();
    }
}
