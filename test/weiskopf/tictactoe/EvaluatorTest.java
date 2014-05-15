package weiskopf.tictactoe;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class EvaluatorTest {

	@Test
	public void testEvaluateVerticalAndGetWinningSquares() {
		TicTacToeBoard board = new TicTacToeBoard();
		Symbol x = Symbol.valueOf("X");
		Symbol o = Symbol.valueOf("O");
		Location l1 = new Location(0, 2);
		Location l2 = new Location(1, 2);
		Location l3 = new Location(2, 2);
		board.setSquare(l1, x);
		board.setSquare(new Location(0, 1), o);
		board.setSquare(new Location(0, 2), x);
		board.setSquare(new Location(1, 0), o);
		board.setSquare(l2, x);
		board.setSquare(new Location(1, 2), x);
		board.setSquare(new Location(2, 0), o);
		board.setSquare(new Location(2, 1), o);
		board.setSquare(l3, x);
		Evaluator e = new Evaluator(board);
		e.evaluate();
		Symbol actual = e.getWinner();
		Symbol expected = x;
		Assert.assertEquals(actual, expected);

		ArrayList<Location> actual2 = (ArrayList<Location>) e
				.getWinningSquares();
		StringBuilder actualLocations = new StringBuilder();
		for (int i = 0; i < actual2.size(); i++) {
			actualLocations.append(actual2.get(i).getX());
			actualLocations.append(",");
			actualLocations.append(actual2.get(i).getY());
			actualLocations.append(" ");

		}
		String actual3 = actualLocations.toString().trim();
		String expected2 = "0,2 1,2 2,2";
		Assert.assertEquals(actual3, expected2);

	}

	@Test
	public void testEvaluateHorizontal() {
		TicTacToeBoard board = new TicTacToeBoard();
		Symbol x = Symbol.valueOf("X");
		Symbol o = Symbol.valueOf("O");
		board.setSquare(new Location(0, 0), x);
		board.setSquare(new Location(0, 1), o);
		board.setSquare(new Location(0, 2), x);
		board.setSquare(new Location(1, 0), o);
		board.setSquare(new Location(1, 1), o);
		board.setSquare(new Location(1, 2), o);
		board.setSquare(new Location(2, 0), o);
		board.setSquare(new Location(2, 1), x);
		board.setSquare(new Location(2, 2), o);
		Evaluator e = new Evaluator(board);
		e.evaluate();
		Symbol actual = e.getWinner();
		Symbol expected = o;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testEvaluateDiagonalRight() {
		TicTacToeBoard board = new TicTacToeBoard();
		Symbol x = Symbol.valueOf("X");
		Symbol o = Symbol.valueOf("O");
		board.setSquare(new Location(0, 0), x);
		board.setSquare(new Location(0, 1), x);
		board.setSquare(new Location(0, 2), o);
		board.setSquare(new Location(1, 0), o);
		board.setSquare(new Location(1, 1), o);
		board.setSquare(new Location(1, 2), x);
		board.setSquare(new Location(2, 0), o);
		board.setSquare(new Location(2, 1), x);
		board.setSquare(new Location(2, 2), o);
		Evaluator e = new Evaluator(board);
		e.evaluate();
		Symbol actual = e.getWinner();
		Symbol expected = o;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testEvaluateDiagonalLeft() {
		TicTacToeBoard board = new TicTacToeBoard();
		Symbol x = Symbol.valueOf("X");
		Symbol o = Symbol.valueOf("O");
		board.setSquare(new Location(0, 0), x);
		board.setSquare(new Location(0, 1), x);
		board.setSquare(new Location(0, 2), o);
		board.setSquare(new Location(1, 0), x);
		board.setSquare(new Location(1, 1), x);
		board.setSquare(new Location(1, 2), o);
		board.setSquare(new Location(2, 0), o);
		board.setSquare(new Location(2, 1), o);
		board.setSquare(new Location(2, 2), x);
		Evaluator e = new Evaluator(board);
		e.evaluate();
		Symbol actual = e.getWinner();
		Symbol expected = x;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testNoWinner() {
		TicTacToeBoard board = new TicTacToeBoard();
		Symbol x = Symbol.valueOf("X");
		Symbol o = Symbol.valueOf("O");
		board.setSquare(new Location(0, 0), x);
		board.setSquare(new Location(0, 1), o);
		board.setSquare(new Location(0, 2), x);
		Evaluator e = new Evaluator(board);
		e.evaluate();
		Symbol actual = e.getWinner();
		Assert.assertNull(actual);
	}

	@Test
	public void testNoWinnerOnBlankBoard() {
		TicTacToeBoard board = new TicTacToeBoard();
		Evaluator e = new Evaluator(board);
		e.evaluate();
		Symbol s = e.getWinner();
		Assert.assertNull(s);
		List<Location> actual = e.getWinningSquares();
		Assert.assertNull(actual);
	}

	@Test
	public void testNoWinnerOnFullBoard() {
		TicTacToeBoard board = new TicTacToeBoard();
		Symbol x = Symbol.valueOf("X");
		Symbol o = Symbol.valueOf("O");
		board.setSquare(new Location(0, 0), x);
		board.setSquare(new Location(0, 1), o);
		board.setSquare(new Location(0, 2), o);
		board.setSquare(new Location(1, 0), o);
		board.setSquare(new Location(1, 1), x);
		board.setSquare(new Location(1, 2), x);
		board.setSquare(new Location(2, 0), x);
		board.setSquare(new Location(2, 1), o);
		board.setSquare(new Location(2, 2), o);
		Evaluator e = new Evaluator(board);
		e.evaluate();
		Symbol s = e.getWinner();
		Assert.assertNull(s);
		List<Location> actual = e.getWinningSquares();
		Assert.assertNull(actual);
	}

}
