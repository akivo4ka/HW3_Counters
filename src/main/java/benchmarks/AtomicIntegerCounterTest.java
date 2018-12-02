package benchmarks;

import counters.AtomicIntegerCounter;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

public class AtomicIntegerCounterTest {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(AtomicIntegerCounterTest.class.getSimpleName())
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
        AtomicIntegerCounter counter;

        @Setup()
        public void setup() {
            counter = new AtomicIntegerCounter();
        }
    }

    @Benchmark
    @Threads(1)
    public void testAtomicInteger_01(MyState myState) {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(2)
    public void testAtomicInteger_02(MyState myState) {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(4)
    public void testAtomicInteger_04(MyState myState) {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(8)
    public void testAtomicInteger_08(MyState myState) {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(16)
    public void testAtomicInteger_16(MyState myState) {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(32)
    public void testAtomicInteger_32(MyState myState) {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(64)
    public void testAtomicInteger_64(MyState myState) {
        myState.counter.incrementAndGet();
    }
}
