package MyThreadPool;

public class 工作类Worker extends Thread{
    Runnable task;

    public 工作类Worker(Runnable task) {
        this.task = task;
    }

    @Override
    public void run() {
    }
}
