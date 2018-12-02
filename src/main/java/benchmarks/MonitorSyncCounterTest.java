package benchmarks;

import counters.AtomicIntegerCounter;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

public class MonitorSyncCounterTest {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MonitorSyncCounterTest.class.getSimpleName())
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
        MonitorSyncCounterTest counter;

        @Setup()
        public void setup() {
            counter = new MonitorSyncCounterTest();
        }
    }

    @Benchmark
    @Threads(1)
    public void testMonitorSync_01(AtomicIntegerCounterTest.MyState myState) {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(2)
    public void testMonitorSync_02(AtomicIntegerCounterTest.MyState myState) {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(4)
    public void testMonitorSync_04(AtomicIntegerCounterTest.MyState myState) {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(8)
    public void testMonitorSync_08(AtomicIntegerCounterTest.MyState myState) {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(16)
    public void testMonitorSync_16(AtomicIntegerCounterTest.MyState myState) {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(32)
    public void testMonitorSync_32(AtomicIntegerCounterTest.MyState myState) {
        myState.counter.incrementAndGet();
    }

    @Benchmark
    @Threads(64)
    public void testMonitorSync_64(AtomicIntegerCounterTest.MyState myState) {
        myState.counter.incrementAndGet();
    }
}
