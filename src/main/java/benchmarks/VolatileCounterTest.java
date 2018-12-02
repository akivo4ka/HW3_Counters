package benchmarks;

import counters.VolatileCounter;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

public class VolatileCounterTest {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(VolatileCounterTest.class.getSimpleName())
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
        VolatileCounter counter;

        @Setup()
        public void setup() {
            counter = new VolatileCounter();
        }
    }

    @Benchmark
    @Threads(1)
    public void testVolatile_01(MyState myState) {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(2)
    public void testVolatile_02(MyState myState) {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(4)
    public void testVolatile_04(MyState myState) {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(8)
    public void testVolatile_08(MyState myState) {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(16)
    public void testVolatile_16(MyState myState) {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(32)
    public void testVolatile_32(MyState myState) {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(64)
    public void testVolatile_64(MyState myState) {
        myState.counter.incrementAndGet();
    }
}
