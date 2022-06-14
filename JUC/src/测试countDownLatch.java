import java.util.concurrent.CountDownLatch;

public class 测试countDownLatch {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        int i;
        for ( i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(()->{
                System.out.println(finalI +"号准备好了");
                countDownLatch.countDown();
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("全部准备完毕。。。");
    }
}
