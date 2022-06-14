package JUC.线程方法;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 21:42 2021/7/22
 */
public class TestThreadLocal {
    public static void main(String[] args) {
        ThreadLocal<Integer> key = new ThreadLocal<>();
        key.set(1);
    }
}
