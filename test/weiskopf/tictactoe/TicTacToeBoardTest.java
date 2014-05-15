package weiskopf.tictactoe;

import org.junit.Assert;
import org.junit.Test;

public class TicTacToeBoardTest {

	@Test
	public void testResetBoard() {
		TicTacToeBoard board = new TicTacToeBoard();
		Location l = new Location(0, 1);
		board.setSquare(l, Symbol.valueOf("X"));
		board.reset();
		Assert.assertNull(board.getSquare(l));

	}

	@Test
	public void testIsFull() {
		TicTacToeBoard board = new TicTacToeBoard();
		board.setSquare(new Location(0, 0), Symbol.valueOf("X"));
		board.setSquare(new Location(0, 1), Symbol.valueOf("X"));
		board.setSquare(new Location(0, 2), Symbol.valueOf("X"));
		board.setSquare(new Location(1, 0), Symbol.valueOf("X"));
		board.setSquare(new Location(1, 1), Symbol.valueOf("X"));
		board.setSquare(new Location(1, 2), Symbol.valueOf("X"));
		board.setSquare(new Location(2, 0), Symbol.valueOf("X"));
		board.setSquare(new Location(2, 1), Symbol.valueOf("X"));
		board.setSquare(new Location(2, 2), Symbol.valueOf("X"));
		Assert.assertTrue(board.isFull());
	}

	@Test
	public void testIsNotFull() {
		TicTacToeBoard board = new TicTacToeBoard();
		board.setSquare(new Location(0, 0), Symbol.valueOf("X"));
		board.setSquare(new Location(0, 1), Symbol.valueOf("X"));
		board.setSquare(new Location(0, 2), Symbol.valueOf("X"));
		board.setSquare(new Location(1, 1), Symbol.valueOf("X"));
		board.setSquare(new Location(1, 2), Symbol.valueOf("X"));
		board.setSquare(new Location(2, 0), Symbol.valueOf("X"));
		board.setSquare(new Location(2, 1), Symbol.valueOf("X"));
		Assert.assertFalse(board.isFull());
	}

	@Test
	public void testSetAndGetSquare() {
		TicTacToeBoard board = new TicTacToeBoard();
		Location l = new Location(2, 1);
		Symbol s = Symbol.valueOf("O");
		board.setSquare(l, s);
		Symbol actual = board.getSquare(l);
		Symbol expected = s;
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGetNullSquare() {
		TicTacToeBoard board = new TicTacToeBoard();
		Location l = new Location(0, 2);
		Assert.assertNull(board.getSquare(l));

	}

	@Test
	public void testInvalidSymbol() {
		try {
			TicTacToeBoard board = new TicTacToeBoard();
			Location l = new Location(2, 1);
			board.setSquare(l, Symbol.valueOf("A"));
			Assert.fail();
		} catch (IllegalArgumentException ex) {
			;
		}
	}

	@Test
	public void testSetFilledSquare() {
		TicTacToeBoard board = new TicTacToeBoard();
		Location l = new Location(1, 1);
		Symbol s = Symbol.valueOf("O");
		board.setSquare(l, s);
		board.setSquare(l, Symbol.valueOf("X"));
		Symbol actual = board.getSquare(l);
		Assert.assertEquals(s, actual);

	}

}
