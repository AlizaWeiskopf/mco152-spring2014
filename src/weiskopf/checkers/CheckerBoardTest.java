package weiskopf.checkers;

import java.awt.Color;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CheckerBoardTest {

	@Test
	/**
	 * Your code must pass this test. Do not edit this test.
	 */
	public void testToStringOnEmptyBoard() {
		final CheckerBoard board = new CheckerBoard();
		final String expected = "--------\n" + "--------\n" + "--------\n"
				+ "--------\n" + "--------\n" + "--------\n" + "--------\n"
				+ "--------\n";
		Assert.assertEquals(expected.trim(), board.toString().trim());
	}

	@Test
	/**
	 * Your code must pass this test. Do not edit this test.
	 */
	public void testToStringAfterNewGame() {
		final CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		final String expected = "-w-w-w-w\n" + "w-w-w-w-\n" + "-w-w-w-w\n"
				+ "--------\n" + "--------\n" + "r-r-r-r-\n" + "-r-r-r-r\n"
				+ "r-r-r-r-\n";
		Assert.assertEquals(expected.trim(), board.toString().trim());
	}

	@Test
	/**
	 * Test that isOnBoard() returns the correct result for different xs and ys
	 */
	public void testIsOnBoard() {
		CheckerBoard board = new CheckerBoard();

		boolean onBoard1 = board.isOnBoard(0, 0);
		Assert.assertTrue(onBoard1);

		boolean onBoard2 = board.isOnBoard(5, 3);
		Assert.assertTrue(onBoard2);

		boolean onBoard3 = board.isOnBoard(7, 7);
		Assert.assertTrue(onBoard3);

		boolean notOnBoard1 = board.isOnBoard(8, 8);
		Assert.assertFalse(notOnBoard1);

		boolean notOnBoard2 = board.isOnBoard(-1, 2);
		Assert.assertFalse(notOnBoard2);
	}

	@Test
	/**
	 * Test that isEmptySquare() returns the correct result before and after setPiece() is called
	 */
	public void testIsEmptySquare() {
		CheckerBoard board = new CheckerBoard();
		boolean actual = board.isEmptySquare(4, 6);
		boolean expected = true;
		Assert.assertEquals(actual, expected);

		board.setPiece(4, 6, Piece.WHITE_MAN);
		boolean actual1 = board.isEmptySquare(4, 6);
		boolean expected1 = false;
		Assert.assertEquals(actual1, expected1);

	}

	@Test
	/**
	 * Given an board with pieces, test that calling clear() clears the board
	 */
	public void testClear() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 2, Piece.RED_MAN);
		board.setPiece(0, 0, Piece.WHITE_MAN);
		board.setPiece(7, 3, Piece.RED_MAN);
		board.clear();

		boolean actual1 = board.isEmptySquare(5, 2);
		Assert.assertTrue(actual1);

		boolean actual2 = board.isEmptySquare(0, 0);
		Assert.assertTrue(actual2);

		boolean actual3 = board.isEmptySquare(7, 3);
		Assert.assertTrue(actual3);
	}

	@Test
	/**
	 * Test that the board is in the correct configuration after
	 * resetNewGame() is called
	 */
	public void testResetNewGame() {
		CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		for (int i = 0; i < CheckerBoard.HEIGHT; i++) {
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
				for (int currJ = j; currJ < CheckerBoard.WIDTH; currJ += 2) {
					Piece piece = board.getPiece(j, i);
					Assert.assertTrue(piece.isColor(Color.WHITE));
					Assert.assertFalse(piece.isKing());
				}
				break;

			case 3:
			case 4:
				for (int k = 0; k < CheckerBoard.WIDTH; k++) {
					board.isEmptySquare(k, i);
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
				for (int currN = n; currN < CheckerBoard.WIDTH; currN += 2) {
					Piece piece = board.getPiece(n, i);
					Assert.assertTrue(piece.isColor(Color.RED));
					Assert.assertFalse(piece.isKing());
				}
				break;

			}
		}

	}

	@Test
	/**
	 * Test execute(Move) moves a piece from one square to the other
	 */
	public void testMove() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(1, 3, Piece.RED_MAN);
		Piece piece = board.getPiece(1, 3);

		Move move = new Move(1, 3, 0, 4);
		board.execute(move);

		boolean result = piece.equals(board.getPiece(0, 4));
		Assert.assertTrue(result);
	}

	@Test
	/**
	 * Test execute(Move) promotes a WHITE_MAN to a WHITE_KING when moving to the 8th row
	 */
	public void testMovePromoteToWhiteKing() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(6, 6, Piece.WHITE_MAN);
		Move move = new Move(6, 6, 7, 7);
		board.execute(move);
		Piece piece = board.getPiece(7, 7);
		boolean isKing = piece.isKing();

		Assert.assertTrue(isKing);
	}

	@Test
	/**
	 * Test execute(Move) promotes a RED_MAN to a RED_KING when moving to the 1st row
	 */
	public void testMovePromoteToRedKing() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 1, Piece.RED_MAN);
		Move move = new Move(2, 1, 1, 0);
		board.execute(move);
		Piece piece = board.getPiece(1, 0);
		boolean isKing = piece.isKing();

		Assert.assertTrue(isKing);

	}

	@Test
	/**
	 * Test execute(Jump) moves a piece from one square to another AND removes the piece that was jumped
	 */
	public void testJump() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(1, 4, Piece.RED_MAN);
		Piece originalLocation = board.getPiece(1, 4);
		board.setPiece(2, 3, Piece.WHITE_MAN);
		Jump jump = new Jump(1, 4, 2, 3, 3, 2);
		board.execute(jump);

		boolean isEmpty = board.isEmptySquare(1, 4);
		Assert.assertTrue(isEmpty);

		Piece newLocation = board.getPiece(3, 2);
		boolean compare = newLocation.equals(originalLocation);
		Assert.assertTrue(compare);

		boolean isEmpty1 = board.isEmptySquare(2, 3);
		Assert.assertTrue(isEmpty1);
	}

	@Test
	/**
	 * Test execute(Jump) promotes a RED_MAN to a RED_KING when moving to the 1st row
	 */
	public void testJumpPromoteToRedKing() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(3, 2, Piece.RED_MAN);
		Jump jump = new Jump(3, 2, 2, 1, 1, 0);
		board.execute(jump);
		Piece piece = board.getPiece(1, 0);
		Assert.assertTrue(piece.isKing());
	}

	@Test
	/**
	 * Test execute(Jump) promotes a WHITE_MAN to a WHITE_KING when moving to the 1st row
	 */
	public void testJumpPromoteToWhiteKing() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 5, Piece.WHITE_MAN);
		Jump jump = new Jump(2, 5, 3, 6, 4, 7);
		board.execute(jump);
		Piece piece = board.getPiece(4, 7);
		Assert.assertTrue(piece.isKing());
	}

	@Test
	/**
	 * Test that getMoves() returns the correct number of Move objects when called on an empty square
	 */
	public void testGetMovesForEmptySquare() {
		CheckerBoard board = new CheckerBoard();
		List<Move> moves = board.getMoves(3, 4);
		Assert.assertEquals(moves.size(), 0);
		Assert.assertTrue(moves.isEmpty());

	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_MAN is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForRedManInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 4, Piece.RED_MAN);
		List<Move> moves = board.getMoves(2, 4);
		Assert.assertEquals(moves.size(), 2);

		Move m1 = moves.get(0);
		int x = m1.getX2();
		int y = m1.getY2();
		Assert.assertEquals(x, 1);
		Assert.assertEquals(y, 3);

		Move m2 = moves.get(1);
		int x1 = m2.getX2();
		int y1 = m2.getY2();
		Assert.assertEquals(x1, 3);
		Assert.assertEquals(y1, 3);

	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForRedKingInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 4, Piece.RED_KING);
		List<Move> moves = board.getMoves(2, 4);
		Assert.assertEquals(moves.size(), 4);

		Move m1 = moves.get(0);
		int x = m1.getX2();
		int y = m1.getY2();
		Assert.assertEquals(x, 1);
		Assert.assertEquals(y, 3);

		Move m2 = moves.get(1);
		int x1 = m2.getX2();
		int y1 = m2.getY2();
		Assert.assertEquals(x1, 3);
		Assert.assertEquals(y1, 3);

		Move m3 = moves.get(2);
		int x2 = m3.getX2();
		int y2 = m3.getY2();
		Assert.assertEquals(x2, 1);
		Assert.assertEquals(y2, 5);

		Move m4 = moves.get(3);
		int x3 = m4.getX2();
		int y3 = m4.getY2();
		Assert.assertEquals(x3, 3);
		Assert.assertEquals(y3, 5);

	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_MAN is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForWhiteManInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(3, 4, Piece.WHITE_MAN);
		List<Move> moves = board.getMoves(3, 4);
		Assert.assertEquals(moves.size(), 2);

		Move m1 = moves.get(0);
		int x = m1.getX2();
		int y = m1.getY2();
		Assert.assertEquals(x, 2);
		Assert.assertEquals(y, 5);

		Move m2 = moves.get(1);
		int x1 = m2.getX2();
		int y1 = m2.getY2();
		Assert.assertEquals(x1, 4);
		Assert.assertEquals(y1, 5);

	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForWhiteKingInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(3, 4, Piece.WHITE_KING);
		List<Move> moves = board.getMoves(3, 4);
		Assert.assertEquals(moves.size(), 4);

		Move m1 = moves.get(0);
		int x = m1.getX2();
		int y = m1.getY2();
		Assert.assertEquals(x, 2);
		Assert.assertEquals(y, 5);

		Move m2 = moves.get(1);
		int x1 = m2.getX2();
		int y1 = m2.getY2();
		Assert.assertEquals(x1, 4);
		Assert.assertEquals(y1, 5);

		Move m3 = moves.get(2);
		int x2 = m3.getX2();
		int y2 = m3.getY2();
		Assert.assertEquals(x2, 2);
		Assert.assertEquals(y2, 3);

		Move m4 = moves.get(3);
		int x3 = m4.getX2();
		int y3 = m4.getY2();
		Assert.assertEquals(x3, 4);
		Assert.assertEquals(y3, 3);

	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is surrounded in 4 directions and
	 * cannot move.
	 * This should be an empty List
	 */
	public void testGetMovesForRedKingWhenSurrounded() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(3, 1, Piece.RED_KING);
		board.setPiece(2, 0, Piece.WHITE_MAN);
		board.setPiece(4, 0, Piece.WHITE_MAN);
		board.setPiece(2, 2, Piece.RED_KING);
		board.setPiece(4, 2, Piece.RED_MAN);
		List<Move> moves = board.getMoves(1, 3);
		Assert.assertTrue(moves.isEmpty());
	}

	@Test
	/**
	 * Test that when getMoves() is called for a piece at the EDGE of the board (0,7) then the correct
	 * move is returned.
	 */
	public void testGetMovesForRedKingAt07() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(0, 7, Piece.RED_MAN);
		List<Move> moves = board.getMoves(0, 7);
		Assert.assertEquals(moves.size(), 1);

		Move m = moves.get(0);
		int x = m.getX2();
		int y = m.getY2();
		Assert.assertEquals(x, 1);
		Assert.assertEquals(y, 6);
	}

	@Test
	/**
	 * Test that when getMoves() is called for a piece at the EDGE of the board (7,0) then the correct
	 * move is returned.
	 */
	public void testGetMovesForRedKingAt70() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(7, 0, Piece.WHITE_MAN);
		List<Move> moves = board.getMoves(7, 0);
		Assert.assertEquals(moves.size(), 1);

		Move m = moves.get(0);
		int x = m.getX2();
		int y = m.getY2();
		Assert.assertEquals(x, 6);
		Assert.assertEquals(y, 1);
	}

	@Test
	/**
	 * Test that getJumps() returns the correct number of Jump objects when called on an empty square
	 */
	public void testGetJumpsForEmptySquare() {
		CheckerBoard board = new CheckerBoard();
		List<Jump> jumps = board.getJumps(3, 5);
		Assert.assertTrue(jumps.isEmpty());
		Assert.assertSame(0, jumps.size());
	}

	@Test
	/**
	 * Test that getJumps() returns the correct number of Jump objects when called on square that does not have
	 * any possible jumps
	 */
	public void testGetJumpsForRedKingInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 2, Piece.RED_KING);
		List<Jump> jumps = board.getJumps(2, 2);
		Assert.assertTrue(jumps.isEmpty());
		Assert.assertSame(0, jumps.size());
	}

	@Test
	/**
	 * Test that getJumps() returns the correct Jump objects when a King can jump in 4 directions
	 */
	public void testGetJumpsForRedKingWhenSurrounded() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 3, Piece.RED_KING);
		board.setPiece(1, 2, Piece.WHITE_MAN);
		board.setPiece(3, 2, Piece.WHITE_MAN);
		board.setPiece(1, 4, Piece.WHITE_KING);
		board.setPiece(3, 4, Piece.WHITE_KING);
		List<Jump> jumps = board.getJumps(2, 3);
		int size = jumps.size();
		Assert.assertEquals(size, 4);

		Jump jump1 = jumps.get(0);
		int x1 = jump1.getX2();
		int y1 = jump1.getY2();
		Assert.assertEquals(x1, 0);
		Assert.assertEquals(y1, 1);

		Jump jump2 = jumps.get(1);
		int x2 = jump2.getX2();
		int y2 = jump2.getY2();
		Assert.assertEquals(x2, 4);
		Assert.assertEquals(y2, 1);

		Jump jump3 = jumps.get(2);
		int x3 = jump3.getX2();
		int y3 = jump3.getY2();
		Assert.assertEquals(x3, 0);
		Assert.assertEquals(y3, 5);

		Jump jump4 = jumps.get(3);
		int x4 = jump4.getX2();
		int y4 = jump4.getY2();
		Assert.assertEquals(x4, 4);
		Assert.assertEquals(y4, 5);
	}

	@Test
	/**
	 * Test that getJumps() returns the returns the correct Jump objects when a Piece can jump in 2 directions
	 */
	public void testGetJumpsForRedManWhenSurrounded() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 5, Piece.RED_MAN);
		board.setPiece(4, 4, Piece.WHITE_MAN);
		board.setPiece(6, 4, Piece.WHITE_MAN);
		List<Jump> jumps = board.getJumps(5, 5);
		Assert.assertEquals(jumps.size(), 2);

		Jump jump1 = jumps.get(0);
		int x1 = jump1.getX2();
		int y1 = jump1.getY2();
		Assert.assertEquals(x1, 3);
		Assert.assertEquals(y1, 3);

		Jump jump2 = jumps.get(1);
		int x2 = jump2.getX2();
		int y2 = jump2.getY2();
		Assert.assertEquals(x2, 7);
		Assert.assertEquals(y2, 3);
	}

}
