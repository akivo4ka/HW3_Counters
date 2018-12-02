import counters.MonitorSyncCounter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * This class is used only for debugging of counter realizations.<br>
 * I've marked it as {@link Deprecated} because realizations are done and a benchmark is done too.
 */

public class Test {

    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();

        int end = 1_500_000;
        // SemaphoreCounter counter = new SemaphoreCounter();
        // AtomicIntegerCounter counter = new AtomicIntegerCounter();
        // LockCounter counter = new LockCounter();
        // ReentrantLockCounter counter = new ReentrantLockCounter();
        // SynchronizedCounter counter = new SynchronizedCounter();
        // VolatileCounter counter = new VolatileCounter();
        MonitorSyncCounter counter = new MonitorSyncCounter();

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        for (int i = 0; i < end; i++) {
            executor.execute(() -> {
                list.add(counter.incrementAndGet());
            });
        }

        Set<Integer> set = findDuplicates(list);
        System.out.println(set.size() == 0 ? "GOOD REALIZATION" : "BAD REALIZATION");
    }

    private static Set<Integer> findDuplicates(List<Integer> listContainingDuplicates) {
        final Set<Integer> setToReturn = new HashSet<>();
        final Set<Integer> set = new HashSet<>();

        for (int number : listContainingDuplicates) {
            if (!set.add(number)) {
                setToReturn.add(number);
            }
        }
        return setToReturn;
    }
}