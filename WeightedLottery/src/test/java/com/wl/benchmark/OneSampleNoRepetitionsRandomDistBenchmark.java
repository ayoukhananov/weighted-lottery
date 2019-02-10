package com.wl.benchmark;

import com.wl.SimpleIntWeightedLotteryNoRepetitions;
import com.wl.bingo.Bingo;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class OneSampleNoRepetitionsRandomDistBenchmark {
  private static WeightedLotteryBenchmark benchmark = WeightedLotteryBenchmark.INSTANCE;
  private static final double[] weights = benchmark.getRandomWeights();

  @Benchmark
  public void simple_05() {
    benchmark.drawKTimes(new SimpleIntWeightedLotteryNoRepetitions(weights, 0.5, ThreadLocalRandom::current));
  }

  @Benchmark
  public void simple_07() {
    benchmark.drawKTimes(new SimpleIntWeightedLotteryNoRepetitions(weights, 0.7, ThreadLocalRandom::current));
  }

  @Benchmark
  public void simple_09() {
    benchmark.drawKTimes(new SimpleIntWeightedLotteryNoRepetitions(weights, 0.9, ThreadLocalRandom::current));
  }

  @Benchmark
  public void bingo() {
    benchmark.drawKTimes(new Bingo(weights, ThreadLocalRandom.current()));
  }
}
