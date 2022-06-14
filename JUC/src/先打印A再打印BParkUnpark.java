import java.util.concurrent.locks.LockSupport;

public class 先打印A再打印BParkUnpark {
    //思路：打印B的条件还没好线程阻塞
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            LockSupport.park();
            System.out.println("B");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("A");
            LockSupport.unpark(t1);
        });

        t1.start();
        t2.start();
    }
}
