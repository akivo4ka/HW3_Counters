package counters;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerCounter {

    private AtomicInteger count = new AtomicInteger(0);

    public int incrementAndGet() {
        return count.incrementAndGet();
    }
}