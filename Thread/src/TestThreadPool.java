import java.util.concurrent.*;

public class TestThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main");
    }

    //固定线程数量的线程池
    public static ExecutorService newFixedThreadPool(int n){
        return new ThreadPoolExecutor(n,n,0L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
    }


}
