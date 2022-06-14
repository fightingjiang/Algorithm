package JUC;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class MyAQS extends AbstractQueuedSynchronizer {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
    }
}
