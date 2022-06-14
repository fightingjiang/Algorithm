import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class 测试CyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(5);
        for (int i = 0; i < 4; i++) {
            int j = i;
            new Thread(()->{
                try {
                    barrier.await();
                    System.out.println(j+"号加载100%");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("游戏开始...");
    }
}
