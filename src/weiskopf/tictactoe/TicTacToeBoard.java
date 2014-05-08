package weiskopf.tictactoe;



public class TicTacToeBoard {

	private Symbol[][] board;

	public TicTacToeBoard() {
		board = new Symbol[3][3];
	}

	public void reset() {
		board = new Symbol[3][3];
	}

	public boolean isFull() {
		boolean full = true;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == null) {
					full = false;
					break;
				}
			}
		}
		return full;
	}

	public void setSquare(Location l, Symbol s) {
		int x = l.getX();
		int y = l.getY();
		Symbol position = board[x][y];
		if (position == null) {
			board[x][y] = s;
		}
	}

	public Symbol getSquare(Location l) {
		Symbol s = board[l.getX()][l.getY()];
		return s;

	}

}
