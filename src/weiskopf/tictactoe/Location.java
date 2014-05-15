package weiskopf.tictactoe;

public class Location {

	private int x;
	private int y;

	public Location(int x, int y) {
		if (x < 3 && y < 3) {
			this.x = x;
			this.y = y;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
