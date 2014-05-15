package weiskopf.checkers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This implementation of a game of Checkers should match
 * http://simple.wikipedia.org/wiki/Checkers
 * 
 * How to play Checkers: https://www.youtube.com/watch?v=SuQY1_fCVsA
 */
public class CheckerBoard {

	public static final int WIDTH = 8;
	public static final int HEIGHT = 8;
	private final Piece[][] board;

	public CheckerBoard() {
		this.board = new Piece[HEIGHT][WIDTH];// y,x
	}

	public Piece getPiece(final int x, final int y) {
		return board[y][x];
	}

	public void setPiece(final int x, final int y, final Piece piece) {
		board[y][x] = piece;
	}

	public void removePiece(final int x, final int y) {
		setPiece(x, y, null);
	}

	/**
	 * Returns true if the x,y coordinate is within the 8x8 board, otherwise
	 * false
	 */
	public boolean isOnBoard(final int x, final int y) {// use this method for
														// getMoves and getJumps
		boolean onBoard = false;
		if (y >= 0 && y < 8 && x >= 0 && x < 8) {
			onBoard = true;
		}
		return onBoard;

	}

	/**
	 * Returns true if the square is null, otherwise false
	 */
	public boolean isEmptySquare(final int x, final int y) {
		return getPiece(x, y) == null;
	}

	/**
	 * Removes all pieces from the board
	 */
	public void clear() {
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				removePiece(i, j);
			}
		}
	}

	/**
	 * Sets the board to a starting configuration
	 */
	public void resetNewGame() {
		clear();
		for (int i = 0; i < HEIGHT; i++) {
			switch (i) {
			case 0:
			case 1:
			case 2:
				int j;
				if (i == 1) {
					j = 0;
				} else {
					j = 1;
				}
				for (int currJ = j; currJ < WIDTH; currJ += 2) {
					setPiece(currJ, i, Piece.WHITE_MAN);
				}
				break;

			case 3:
			case 4:
				for (int k = 0; k < WIDTH; k++) {
					setPiece(k, i, null);
				}
				break;

			case 5:
			case 6:
			case 7:
				int n;
				if (i == 6) {
					n = 1;
				} else {
					n = 0;
				}
				for (int currN = n; currN < WIDTH; currN += 2) {
					setPiece(currN, i, Piece.RED_MAN);
				}
				break;

			}
		}

	}

	@Override
	/**
	 * Returns a String representation of the board. Each row of the board should be on it's own line.
	 * A dash "-" represents an empty square. Pieces should be displayed using the .toString() method
	 * of the piece class.
	 */
	public String toString() {
		StringBuilder currentBoard = new StringBuilder();
		for (int i = 0; i < HEIGHT; i++) {
			currentBoard.append("\n");
			for (int j = 0; j < WIDTH; j++) {
				if (board[i][j] == null) {
					currentBoard.append("-");
				} else {
					currentBoard.append(getPiece(j, i).toString());
				}
			}
		}
		return currentBoard.toString();
	}

	/**
	 * Do the Move, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. If the piece is now on their "King's Row", then promote the piece
	 * should be promoted to a King
	 */
	public void execute(final Move move) {
		int currX = move.getX1();
		int currY = move.getY1();
		Piece piece = getPiece(currX, currY);
		removePiece(currX, currY);
		int toX = move.getX2();
		int toY = move.getY2();
		if (piece.isColor(Color.RED)) {
			if (toY == 0) {
				piece = Piece.RED_KING;
			}
		} else {
			if (piece.isColor(Color.WHITE)) {
				if (toY == 7) {
					piece = Piece.WHITE_KING;
				}
			}
		}
		setPiece(toX, toY, piece);
	}

	/**
	 * Do the Jump, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. Remove the piece from captureX, captureY as well. If the piece is now
	 * on their "King's Row", then promote the piece should be promoted to a
	 * King
	 */
	public void execute(final Jump jump) {
		int currX = jump.getX1();
		int currY = jump.getY1();
		Piece piece = getPiece(currX, currY);
		removePiece(currX, currY);

		int captureX = jump.getCaptureX();
		int captureY = jump.getCaptureY();
		removePiece(captureX, captureY);

		int toX = jump.getX2();
		int toY = jump.getY2();
		if (piece.isColor(Color.RED)) {
			if (toY == 0) {
				piece = Piece.RED_KING;
			}
		} else {
			if (piece.isColor(Color.WHITE)) {
				if (toY == 7) {
					piece = Piece.WHITE_KING;
				}
			}
		}
		setPiece(toX, toY, piece);
	}

	/**
	 * Returns a list of all possible moves from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal move then
	 * return an empty list
	 */
	public List<Move> getMoves(final int x, final int y) {
		List<Move> moves = new ArrayList<Move>();
		Piece piece = getPiece(x, y);
		if (piece == null) {
			return moves;
		} else {
			int newX1 = x - 1;
			int newX2 = x + 1;
			if (piece.isColor(Color.WHITE)) {
				int newY1 = y + 1;
				if (isOnBoard(newX1, newY1) && isEmptySquare(newX1, newY1)) {
					Move move = new Move(x, y, newX1, newY1);
					moves.add(move);
				}
				if (isOnBoard(newX2, newY1) && isEmptySquare(newX2, newY1)) {
					Move move = new Move(x, y, newX2, newY1);
					moves.add(move);
				}

				if (piece.isKing()) {// white king - can move backwards also
					int newY2 = y - 1;
					if (isOnBoard(newX1, newY2) && isEmptySquare(newX1, newY2)) {
						Move move = new Move(x, y, newX1, newY2);
						moves.add(move);
					}
					if (isOnBoard(newX2, newY2) && isEmptySquare(newX2, newY2)) {
						Move move = new Move(x, y, newX2, newY2);
						moves.add(move);
					}
				}
			} else {
				if (piece.isColor(Color.RED)) {
					int newY1 = y - 1;
					if (isOnBoard(newX1, newY1) && isEmptySquare(newX1, newY1)) {
						Move move = new Move(x, y, newX1, newY1);
						moves.add(move);
					}
					if (isOnBoard(newX2, newY1) && isEmptySquare(newX2, newY1)) {
						Move move = new Move(x, y, newX2, newY1);
						moves.add(move);
					}

					if (piece.isKing()) {// red king - can move backwards also

						int newY2 = y + 1;
						if (isOnBoard(newX1, newY2)
								&& isEmptySquare(newX1, newY2)) {
							Move move = new Move(x, y, newX1, newY2);
							moves.add(move);
						}
						if (isOnBoard(newX2, newY2)
								&& isEmptySquare(newX2, newY2)) {
							Move move = new Move(x, y, newX2, newY2);
							moves.add(move);
						}

					}
				}
			}
		}

		return moves;
	}

	/**
	 * Returns a list of all possible jumps from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal jump then
	 * return an empty list
	 */
	public List<Jump> getJumps(final int x, final int y) {
		List<Jump> jumps = new ArrayList<Jump>();
		Piece piece = getPiece(x, y);
		if (piece == null) {
			return jumps;
		} else {
			if (piece.isColor(Color.WHITE)) {
				int captureX1 = x - 1;
				int captureY = y + 1;
				int captureX2 = x + 1;
				Piece capturePiece1 = getPiece(captureX1, captureY);
				Piece capturePiece2 = getPiece(captureX2, captureY);
				int jumpToY = captureY + 1;
				if (capturePiece1 != null) {
					if (capturePiece1.getColor() == Color.RED) {
						int jumpToX = captureX1 - 1;
						if (isEmptySquare(jumpToX, jumpToY)
								&& isOnBoard(jumpToX, jumpToY)) {
							Jump jump = new Jump(x, y, captureX1, captureY,
									jumpToX, jumpToY);
							jumps.add(jump);
						}
					}
				}
				if (capturePiece2 != null) {
					if (capturePiece2.getColor() == Color.RED) {
						int jumpToX1 = captureX2 + 1;
						if (isEmptySquare(jumpToX1, jumpToY)
								&& isOnBoard(jumpToX1, jumpToY)) {
							Jump jump = new Jump(x, y, captureX2, captureY,
									jumpToX1, jumpToY);
							jumps.add(jump);
						}
					}
				}

				if (piece.isKing()) {
					int captureY1 = y - 1;
					Piece capturePiece3 = getPiece(captureX1, captureY1);
					Piece capturePiece4 = getPiece(captureX2, captureY1);
					int jumpToY2 = captureY1 - 1;
					if (capturePiece3 != null) {
						if (capturePiece3.getColor() == Color.RED) {
							int jumpToX2 = captureX1 - 1;
							if (isEmptySquare(jumpToX2, jumpToY2)
									&& isOnBoard(jumpToX2, jumpToY2)) {
								Jump jump = new Jump(x, y, captureX1,
										captureY1, jumpToX2, jumpToY2);
								jumps.add(jump);
							}
						}
					}
					if (capturePiece4 != null) {
						if (capturePiece4.getColor() == Color.RED) {
							int jumpToX3 = captureX2 + 1;
							if (isEmptySquare(jumpToX3, jumpToY2)
									&& isOnBoard(jumpToX3, jumpToY2)) {
								Jump jump = new Jump(x, y, captureX2,
										captureY1, jumpToX3, jumpToY2);
								jumps.add(jump);
							}
						}
					}
				}

			} else {
				if (piece.isColor(Color.RED)) {
					int captureX1 = x - 1;
					int captureY = y - 1;
					int captureX2 = x + 1;
					Piece capturePiece1 = getPiece(captureX1, captureY);
					Piece capturePiece2 = getPiece(captureX2, captureY);
					int jumpToY = captureY - 1;
					if (capturePiece1 != null) {
						if (capturePiece1.getColor() == Color.WHITE) {
							int jumpToX = captureX1 - 1;
							if (isEmptySquare(jumpToX, jumpToY)
									&& isOnBoard(jumpToX, jumpToY)) {
								Jump jump = new Jump(x, y, captureX1, captureY,
										jumpToX, jumpToY);
								jumps.add(jump);
							}
						}
					}
					if (capturePiece2 != null) {
						if (capturePiece2.getColor() == Color.WHITE) {
							int jumpToX1 = captureX2 + 1;
							if (isEmptySquare(jumpToX1, jumpToY)
									&& isOnBoard(jumpToX1, jumpToY)) {
								Jump jump = new Jump(x, y, captureX2, captureY,
										jumpToX1, jumpToY);
								jumps.add(jump);
							}
						}
					}

					if (piece.isKing()) {
						int captureY1 = y + 1;
						Piece capturePiece3 = getPiece(captureX1, captureY1);
						Piece capturePiece4 = getPiece(captureX2, captureY1);
						int jumpToY2 = captureY1 + 1;
						if (capturePiece3 != null) {
							if (capturePiece3.getColor() == Color.WHITE) {
								int jumpToX2 = captureX1 - 1;
								if (isEmptySquare(jumpToX2, jumpToY2)
										&& isOnBoard(jumpToX2, jumpToY2)) {
									Jump jump = new Jump(x, y, captureX1,
											captureY1, jumpToX2, jumpToY2);
									jumps.add(jump);
								}
							}
						}
						if (capturePiece4 != null) {
							if (capturePiece4.getColor() == Color.WHITE) {
								int jumpToX3 = captureX2 + 1;
								if (isEmptySquare(jumpToX3, jumpToY2)
										&& isOnBoard(jumpToX3, jumpToY2)) {
									Jump jump = new Jump(x, y, captureX2,
											captureY1, jumpToX3, jumpToY2);
									jumps.add(jump);
								}
							}
						}

					}
				}

			}
		}

		return jumps;
	}

}
