package JUC.线程方法.自定义线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 21:20 2021/7/13
 */
public class 线程池 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Executors.newSingleThreadExecutor();

    }
}
