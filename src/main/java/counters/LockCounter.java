package counters;

import java.util.concurrent.locks.StampedLock;

public class LockCounter {

    private StampedLock lock = new StampedLock();

    private int counter;

    public int incrementAndGet() {
        long stamp = lock.writeLock();
        try {
            return ++counter;
        } finally {
            lock.unlockWrite(stamp);
        }
    }

}