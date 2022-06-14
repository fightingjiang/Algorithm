package 启动线程三种方式;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(100);
                return 1;
            }
        };
        FutureTask<Integer> task = new FutureTask<>(callable);
        new Thread(task).start();
        System.out.println(task.get());

    }
}
