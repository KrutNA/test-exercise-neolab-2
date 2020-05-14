package com.krutna.testexercise;

import java.util.LinkedList;
import java.util.List;

/** Class which represents Chessboard with <code>X</code> and <code>Y</code> sizes. */
public class Chessboard {

  private class Piece {

    private final int x;
    private final int y;

    Piece(final int x, final int y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return this.x;
    }

    public int getY() {
      return this.y;
    }
  }

  private final int sizeX;
  private final int sizeY;

  /**
   * Base constructor with selecting <code>X</code> and <code>Y</code> sizes.
   *
   * @throws <code>IllegalArgumentException</code> when sizes are bellow or equals <code>0</code>
   */
  Chessboard(final int sizeX, final int sizeY) throws IllegalArgumentException {

    if (sizeX <= 0 || sizeY <= 0) {
      throw new IllegalArgumentException("X and Y sizes must be higher then '0'.");
    }

    this.sizeX = sizeX;
    this.sizeY = sizeY;
  }

  /** Base getter for X size of chessboard. */
  public int getSizeX() {
    return this.sizeX;
  }

  /** Base getter for Y size of chessboard */
  public int getSizeY() {
    return this.sizeY;
  }

  /**
   * Checks checkmate for black <code>king</code>
   *
   * @param data <code>String</code> of chessboard data with no newlines and with length equals
   *     <code>X*Y</code>
   * @return If is checkmate: returns <code>true</code>, otherwise <code>false</code>
   * @throws <code>IllegalArgumentException</code> if size of chessboard and legth of <code>data
   *     </code> missmatches or when <code>king</code> not found in <code>data</code> or multiple of
   *     <code>king</code>'s detected.
   */
  public boolean check(final String data) throws IllegalArgumentException {

    Piece checkKing = null;
    final List<Piece> queens = new LinkedList<>();
    final List<Piece> rooks = new LinkedList<>();
    final List<Piece> bishops = new LinkedList<>();
    final List<Piece> knights = new LinkedList<>();
    final List<Piece> pawns = new LinkedList<>();

    if (this.sizeX * this.sizeY != data.length()) {
      throw new IllegalArgumentException("Size of chessboard and size of data missmatches.");
    }

    for (int i = 0; i < this.sizeY; i++) {
      for (int j = 0; j < this.sizeX; j++) {
        switch (data.charAt(i * this.sizeX + j)) {
          case 'K':
            if (checkKing != null) {
              throw new IllegalArgumentException("Multiple kings detected.");
            }
            checkKing = new Piece(j, i);
            break;
          case 'Q':
            queens.add(new Piece(j, i));
            break;
          case 'R':
            rooks.add(new Piece(j, i));
            break;
          case 'B':
            bishops.add(new Piece(j, i));
            break;
          case 'N':
            knights.add(new Piece(j, i));
            break;
          case 'P':
            pawns.add(new Piece(j, i));
            break;
          default:
        }
      }
    }

    if (checkKing == null) throw new IllegalArgumentException("King not found.");
    final Piece king = checkKing;

    if (queens.stream().anyMatch(x -> checkQueen(x, king))) {
      return true;
    }

    if (rooks.stream().anyMatch(x -> checkRook(x, king))) {
      return true;
    }

    if (bishops.stream().anyMatch(x -> checkBishop(x, king))) {
      return true;
    }

    if (knights.stream().anyMatch(x -> checkKnight(x, king))) {
      return true;
    }

    if (pawns.stream().anyMatch(x -> checkPawn(x, king))) {
      return true;
    }

    return false;
  }

  private boolean checkQueen(final Piece queen, final Piece king) {

    if (checkOnOneLine(queen, king)) {
      return true;
    }

    if (checkOnOneDiagonal(queen, king)) {
      return true;
    }

    return false;
  }

  private boolean checkRook(final Piece rook, final Piece king) {

    if (checkOnOneLine(rook, king)) {
      return true;
    }

    return false;
  }

  private boolean checkBishop(final Piece bishop, final Piece king) {

    if (checkOnOneDiagonal(bishop, king)) {
      return true;
    }

    return false;
  }

  private boolean checkKnight(final Piece knight, final Piece king) {

    if ((absDiffX(knight, king) == 2 && absDiffY(knight, king) == 1)
        || (absDiffX(knight, king) == 1 && absDiffY(knight, king) == 2)) {
      return true;
    }

    return false;
  }

  private boolean checkPawn(final Piece pawn, final Piece king) {

    final int diffY = king.getY() - pawn.getY();
    if (diffY == -1 && absDiffX(pawn, king) == 1) {
      return true;
    }

    return false;
  }

  private int absDiffX(final Piece piece, final Piece king) {
    return Math.abs(king.getX() - piece.getX());
  }

  private int absDiffY(final Piece piece, final Piece king) {
    return Math.abs(king.getY() - piece.getY());
  }

  private boolean checkOnOneLine(final Piece piece, final Piece king) {
    return king.getX() == piece.getX() || king.getY() == piece.getY();
  }

  private boolean checkOnOneDiagonal(final Piece piece, final Piece king) {
    return absDiffX(piece, king) == absDiffY(piece, king);
  }
}
