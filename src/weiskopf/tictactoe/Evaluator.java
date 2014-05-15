package weiskopf.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Evaluator {

	private TicTacToeBoard theBoard;
	private Symbol winner;
	private List<Location> winningSquares;

	public Evaluator(TicTacToeBoard theBoard) {
		this.theBoard = theBoard;
		winner = null;
		winningSquares = null;
	}

	public void evaluate() {
		// evaluate three vertical, i changes, j stays the same
		for (int i = 0; i < 3; i++) {
			Location l1 = new Location(0, i);
			Symbol s = theBoard.getSquare(l1);
			Location l2 = new Location(1, i);
			Location l3 = new Location(2, i);
			if (s != null) {
				if (s == theBoard.getSquare(l2) && s == theBoard.getSquare(l3)) {
					winner = s;
					winningSquares = new ArrayList<Location>();
					winningSquares.add(l1);
					winningSquares.add(l2);
					winningSquares.add(l3);
					return;
				}
			}

		}
		// evaluate three horizontal, i stays the same, j changes
		for (int i = 0; i < 3; i++) {
			Location l1 = new Location(i, 0);
			Symbol s = theBoard.getSquare(l1);
			Location l2 = new Location(i, 1);
			Location l3 = new Location(i, 2);
			if (s != null) {
				if (s == theBoard.getSquare(l2) && s == theBoard.getSquare(l3)) {
					winner = s;
					winningSquares = new ArrayList<Location>();
					winningSquares.add(l1);
					winningSquares.add(l2);
					winningSquares.add(l3);
					return;
				}
			}
		}
		// evaluate diagonal right
		Location l1 = new Location(2, 0);
		Symbol s = theBoard.getSquare(l1);
		Location l2 = new Location(1, 1);
		Location l3 = new Location(0, 2);
		if (s != null) {
			if (s == theBoard.getSquare(l2) && s == theBoard.getSquare(l3)) {
				winner = s;
				winningSquares = new ArrayList<Location>();
				winningSquares.add(l1);
				winningSquares.add(l2);
				winningSquares.add(l3);
				return;
			}
		}
		// evaluate diagonal left
		Location la = new Location(2, 2);
		Symbol sym = theBoard.getSquare(la);
		Location lb = new Location(1, 1);
		Location lc = new Location(0, 0);
		if (sym != null) {
			if (sym == theBoard.getSquare(lb) && sym == theBoard.getSquare(lc)) {
				winner = sym;
				winningSquares = new ArrayList<Location>();
				winningSquares.add(la);
				winningSquares.add(lb);
				winningSquares.add(lc);
			}
		}
	}

	public Symbol getWinner() {
		return winner;
	}

	public List<Location> getWinningSquares() {
		return winningSquares;
	}

}
