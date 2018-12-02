package counters;

import java.util.concurrent.Semaphore;

public class SemaphoreCounter {

    private Semaphore semaphore = new Semaphore(1);

    private int counter = 0;

    public int incrementAndGet() throws InterruptedException {
        int temp;
        try {
            semaphore.acquire();
            temp = ++counter;
        } finally {
            semaphore.release();
        }
        return temp;
    }
}