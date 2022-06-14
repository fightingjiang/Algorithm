public class client implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
    }
}
