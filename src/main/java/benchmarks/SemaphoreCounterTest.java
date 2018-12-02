package benchmarks;

import counters.SemaphoreCounter;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

public class SemaphoreCounterTest {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SemaphoreCounterTest.class.getSimpleName())
                .warmupIterations(2)
                .measurementIterations(11)
                .forks(1)
                .mode(Mode.Throughput)
                .timeUnit(TimeUnit.MILLISECONDS)
                .build();

        new Runner(opt).run();
    }


    @State(Scope.Benchmark)
    public static class MyState {
        SemaphoreCounter counter;

        @Setup()
        public void setup() {
            counter = new SemaphoreCounter();
        }
    }

    @Benchmark
    @Threads(1)
    public void testSemaphoreLock_01(MyState myState) throws InterruptedException {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(2)
    public void testSemaphoreLock_02(MyState myState) throws InterruptedException {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(4)
    public void testSemaphoreLock_04(MyState myState) throws InterruptedException {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(8)
    public void testSemaphoreLock_08(MyState myState) throws InterruptedException {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(16)
    public void testSemaphoreLock_16(MyState myState) throws InterruptedException {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(32)
    public void testSemaphoreLock_32(MyState myState) throws InterruptedException {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(64)
    public void testSemaphoreLock_64(MyState myState) throws InterruptedException {
        myState.counter.incrementAndGet();
    }
}
