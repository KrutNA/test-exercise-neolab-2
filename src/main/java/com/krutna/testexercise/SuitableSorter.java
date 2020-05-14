package com.krutna.testexercise;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/** Class which represents some functionality for sorting only suitable objects. */
public class SuitableSorter {

  /**
   * Selecting from <code>array</code> and sorting only parts which suitable to <code>function
   * </code>
   *
   * @param array <code>int[]</code> on base of which will be created partly sorted new.
   * @param function <code>IntPredicate</code> which will be used for selectig sortable elements.
   * @return New <code>int[]</code> which result of merge <code>array</code> with sorted elements.
   */
  public final int[] sortOnlyFiltered(final int[] array, final IntPredicate function) {

    final AtomicInteger index = new AtomicInteger();
    final int[] filtered = IntStream.of(array).parallel().filter(function).sorted().toArray();

    return IntStream.of(array)
        .map(x -> function.test(x) ? filtered[index.getAndIncrement()] : x)
        .toArray();
  }
}
