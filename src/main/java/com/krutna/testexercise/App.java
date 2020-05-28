package com.krutna.testexercise;

/** Class which represents of <code>main</code> method and base functionallitty of application */
public class App {

  final SuitableSorter sorter;
  final TimeProcessor timeProcessor;
  final Chessboard chessboard;

  /**
   * Base contructor with constructing <code>sorter</code>, <code>timeProcessor</code> and <code>
   * chessboard</code>
   */
  App() {
    sorter = new SuitableSorter();
    timeProcessor = new TimeProcessor();
    chessboard = new Chessboard(4, 4);
  }

  /**
   * Sorts only odds of <code>array</code>
   *
   * @param array Integer array whose odds will be sorted
   * @return New <code>int[]</code> with sorted odds
   * @see SuitableSorter#sortOnlyFiltered(int[], IntPredicate)
   */
  public int[] sortOdds(final int[] array) {
    return this.sorter.sortOnlyFiltered(array, x -> x % 2 == 1);
  }

  /**
   * This function correct time value like <code>8:70:70</code> to <code>09:11:10</code>
   *
   * @see TimeProcessor#correct(String)
   */
  public String correctTime(final String time) {
    return this.timeProcessor.correct(time);
  }

  /**
   * Checks checkmate for black <code>king</code>. If is checkmate: returns <code>true</code>,
   * otherwise <code>false</code>
   *
   * @see Chessboard#check(String)
   */
  public boolean checkChess(final String chess) {
    return this.chessboard.check(chess);
  }

  public static void main(final String[] args) {
    final App app = new App();
  }
}
