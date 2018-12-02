package benchmarks;

import counters.SynchronizedCounter;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

public class SynchronizedCounterTest {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SynchronizedCounterTest.class.getSimpleName())
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
        SynchronizedCounter counter;

        @Setup()
        public void setup() {
            counter = new SynchronizedCounter();
        }
    }

    @Benchmark
    @Threads(1)
    public void testSynchronized_01(MyState myState) {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(2)
    public void testSynchronized_02(MyState myState) {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(4)
    public void testSynchronized_04(MyState myState) {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(8)
    public void testSynchronized_08(MyState myState) {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(16)
    public void testSynchronized_16(MyState myState) {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(32)
    public void testSynchronized_32(MyState myState) {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(64)
    public void testSynchronized_64(MyState myState) {
        myState.counter.incrementAndGet();
    }
}
