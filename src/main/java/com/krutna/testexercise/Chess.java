package com.krutna.testexercise;

import java.util.LinkedList;
import java.util.List;

class Chess {

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

  private final Piece size;

  Chess(final int sizeX, final int sizeY) throws IllegalArgumentException {

    if (sizeX <= 0 || sizeY <= 0)
      throw new IllegalArgumentException("X and Y sizes must be higher then '0'.");

    size = new Piece(sizeX, sizeY);
  }

  public boolean check(final String data) throws IllegalArgumentException {

    Piece checkKing = null;
    final List<Piece> queens = new LinkedList<>();
    final List<Piece> rooks = new LinkedList<>();
    final List<Piece> bishops = new LinkedList<>();
    final List<Piece> knights = new LinkedList<>();
    final List<Piece> pawns = new LinkedList<>();

    if (this.size.getX() * this.size.getY() != data.length())
      throw new IllegalArgumentException("Size of chessboard and size of data missmatches.");

    for (int i = 0; i < size.getY(); i++) {
      for (int j = 0; j < size.getX(); j++) {
        switch (data.charAt(i * size.getX() + j)) {
          case 'K':
            if (checkKing != null) throw new IllegalArgumentException("Multiple kings detected.");
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

    if (checkOnOneLine(queen, king)) return true;

    if (checkOnOneDiagonal(queen, king)) return true;

    return false;
  }

  private boolean checkRook(final Piece rook, final Piece king) {

    if (checkOnOneLine(rook, king)) return true;

    return false;
  }

  private boolean checkBishop(final Piece bishop, final Piece king) {

    if (checkOnOneDiagonal(bishop, king)) return true;

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
