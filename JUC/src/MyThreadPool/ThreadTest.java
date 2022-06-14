package MyThreadPool;

import java.util.concurrent.*;

public class ThreadTest {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        Future<Object> submit = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("1");
                return "Yes";
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
        try {
            System.out.println(submit.get().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Future<?> submit1 = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        });
        try {
            System.out.println(submit1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
