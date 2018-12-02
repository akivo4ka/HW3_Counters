package counters;

public class SynchronizedCounter {

    private int counter = 0;

    public synchronized int incrementAndGet() {
        return ++counter;
    }

}