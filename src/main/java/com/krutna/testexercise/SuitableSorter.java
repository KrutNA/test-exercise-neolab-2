package com.krutna.testexercise;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

class SuitableSorter {

  public final int[] sortBy(final int[] array, IntPredicate function) {
    final AtomicInteger index = new AtomicInteger();
    final int[] odds = IntStream.of(array).filter(function).sorted().toArray();
    return IntStream.of(array)
        .map(x -> function.test(x) ? odds[index.getAndIncrement()] : x)
        .toArray();
  }
}
