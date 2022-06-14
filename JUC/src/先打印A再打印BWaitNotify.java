public class 先打印A再打印BWaitNotify {
    //思路：打印B的条件还没好线程阻塞
    static Object lock = new Object();
    static boolean flag = false;
    public static void main(String[] args) {
        new Thread(()->{
            synchronized (lock){
                while (!flag){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("B");
            }
        }).start();

        new Thread(()->{
            System.out.println("A");
            synchronized (lock){
                flag = true;
                lock.notifyAll();
            }
        }).start();

    }
}
