package com.krutna.testexercise;

public class App {

  final SuitableSorter sorter;
  final TimeProcessor timeProcessor;
  final Chessboard chessboard;

  App() {
    sorter = new SuitableSorter();
    timeProcessor = new TimeProcessor();
    chessboard = new Chessboard(4, 4);
  }

  public int[] sortOdds(final int[] array) {
    return this.sorter.sortOnlyFiltered(array, x -> x % 2 == 1);
  }

  public String correctTime(final String time) throws IllegalArgumentException {
    return this.timeProcessor.correct(time);
  }

  public boolean checkChess(final String chess) throws IllegalArgumentException {
    return this.chessboard.check(chess);
  }

  public static void main(final String[] args) {
    final App app = new App();
  }
}
