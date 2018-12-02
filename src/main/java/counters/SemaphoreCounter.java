package counters;

import java.util.concurrent.Semaphore;

public class SemaphoreCounter {

    private Semaphore semaphore = new Semaphore(1);

    private int counter = 0;

    public int incrementAndGet() throws InterruptedException {
        int temp = 0;
        try {
            semaphore.acquire();
            temp = ++counter;
        } finally {
            semaphore.release();
        }
        return temp;
    }

//    public int incrementAndGet() throws InterruptedException {
//        int temp = 0;
//        try {
//            semaphore.acquire();
//            temp = counter++;
//            System.out.println(temp);
//        } finally {
//            semaphore.release();
//        }
//        return temp;
//    }
}