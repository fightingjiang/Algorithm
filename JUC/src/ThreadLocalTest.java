public class ThreadLocalTest extends Thread{
    @Override
    public void run() {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        ThreadLocal<Integer> threadLocal1 = new ThreadLocal<>();
        threadLocal1.set(4);
        threadLocal.set(1);
        threadLocal.set(3);
        System.out.println(threadLocal.get());
        System.out.println(threadLocal1.get());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Test{
    public static void main(String[] args) {
        ThreadLocalTest t1 = new ThreadLocalTest();
        t1.start();
    }
}