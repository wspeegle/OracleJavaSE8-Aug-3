package fj;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.DoubleSummaryStatistics;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.DoubleStream;

public class FJ {

    public static final long TOTAL = 1_000_000_000L;

    class IntermediateResult {

        final double sum;
        final long count;

        double getAverage() {
            return sum / count;
        }

        IntermediateResult(double sum, long count) {
            this.sum = sum;
            this.count = count;
        }
    }

    class AveragerTask extends RecursiveTask<IntermediateResult> {

        private final long sampleCount;
        private final long BLOCK_SIZE = 1_000L;

        public AveragerTask(long sampleCount) {
            this.sampleCount = sampleCount;
        }

        @Override
        protected IntermediateResult compute() {
            if (sampleCount > BLOCK_SIZE) {
                long split = sampleCount / 2;
                long remainder = sampleCount - split;
                AveragerTask t1 = new AveragerTask(split);
                AveragerTask t2 = new AveragerTask(remainder);
//                System.out.println("Forking");
                t2.fork();

                IntermediateResult r1 = t1.compute();
                IntermediateResult r2 = t2.join();
                return new IntermediateResult(r1.sum + r2.sum, r1.count + r2.count);
            } else {
                return computeBlock(sampleCount);
            }
        }
    }

    private IntermediateResult computeBlock(long sampleCount) {
        final ThreadLocalRandom rand = ThreadLocalRandom.current();
        DoubleSummaryStatistics ds = DoubleStream.generate(rand::nextDouble)
            .limit(sampleCount)
            //            .peek(System.out::println)
            .summaryStatistics();
//            System.out.println("Computed " + ds);
        return new IntermediateResult(ds.getSum(), ds.getCount());
    }

    private IntermediateResult parallelComputeBlock(long sampleCount) {
        final ThreadLocalRandom rand = ThreadLocalRandom.current();
        DoubleSummaryStatistics ds = DoubleStream.generate(rand::nextDouble)
            .parallel()
            .limit(sampleCount)
            .summaryStatistics();
        return new IntermediateResult(ds.getSum(), ds.getCount());
    }

    public static void main(String[] args) {
        new FJ().go();
    }

    public void go() {
        ForkJoinPool fjp = new ForkJoinPool();
        AveragerTask rootTask = new AveragerTask(TOTAL);

        Instant start = Instant.now();
        IntermediateResult res = fjp.invoke(rootTask);
        System.out.println("average is " + res.getAverage());
        System.out.println("Elapsed: " + ChronoUnit.MILLIS.between(start, Instant.now()));

        start = Instant.now();
        System.out.println("Parallel-computed average is " + parallelComputeBlock(TOTAL).getAverage());
        System.out.println("Elapsed: " + ChronoUnit.MILLIS.between(start, Instant.now()));

        start = Instant.now();
        System.out.println("Linear-computed average is " + computeBlock(TOTAL).getAverage());
        System.out.println("Elapsed: " + ChronoUnit.MILLIS.between(start, Instant.now()));
    }
}
