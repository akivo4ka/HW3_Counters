package counters;

public class MonitorSyncCounter {

    private int counter;
    private static final Object monitor = new Object();

    public int incrementAndGet() {
        synchronized (monitor) {
            counter++;
        }
        return counter;
    }

}
