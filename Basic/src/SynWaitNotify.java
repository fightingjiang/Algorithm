
public class SynWaitNotify {
    static boolean flag = false ;
    static Object o = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (o){
                    while (!flag){
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("b");
                    flag = false;
                    o.notifyAll();
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (o){
                    while (flag){
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("a");
                    flag = true;
                    o.notifyAll();
                }
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}