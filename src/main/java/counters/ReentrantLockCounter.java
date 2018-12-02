package counters;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter {

    private ReentrantLock counterLock = new ReentrantLock(false);

    private int counter;

    public int incrementAndGet() {
        counterLock.lock();
        try {
            return ++counter;
        } finally {
            counterLock.unlock();
        }
    }
}