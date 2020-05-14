package com.krutna.testexercise;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

class SuitableSorter {

  public final int[] sortOnlyFiltered(final int[] array, IntPredicate function) {

    final AtomicInteger index = new AtomicInteger();
    final int[] filtered = IntStream.of(array).parallel().filter(function).sorted().toArray();

    return IntStream.of(array)
        .map(x -> function.test(x) ? filtered[index.getAndIncrement()] : x)
        .toArray();
  }
}
