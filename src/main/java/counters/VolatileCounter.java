package counters;

public class VolatileCounter {

    private volatile int counter = 0;

    public int incrementAndGet() {
        return ++counter;
    }
}