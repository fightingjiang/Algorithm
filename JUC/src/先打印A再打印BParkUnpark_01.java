import java.util.concurrent.locks.LockSupport;

public class 先打印A再打印BParkUnpark_01 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            LockSupport.park();
            System.out.println("A");
        });
        t1.start();
        new Thread(()->{
            System.out.println("B");
            LockSupport.unpark(t1);
        }).start();
    }
}
