package com.krutna.testexercise;

public class App {

  final SuitableSorter sorter;
  final TimeProcessor timeProcessor;

  App() {
    sorter = new SuitableSorter();
    timeProcessor = new TimeProcessor();
  }

  public int[] sortOdds(final int[] array) {
    return this.sorter.sortBy(array, x -> x % 2 == 1);
  }

  public String correctTime(String time) {
    return this.timeProcessor.correct(time);
  }

  public static void main(String[] args) {
    final App app = new App();
  }
}
