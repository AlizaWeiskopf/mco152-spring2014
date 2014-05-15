package weiskopf.checkers;

/**
 * This class does not need to be modified
 */
public class Move {

	private final int	x1;
	private final int	y1;
	private final int	x2;
	private final int	y2;

	public Move(final int x1, final int y1, final int x2, final int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public int getX1() {
		return x1;
	}

	public int getY1() {
		return y1;
	}

	public int getX2() {
		return x2;
	}

	public int getY2() {
		return y2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x1;
		result = prime * result + x2;
		result = prime * result + y1;
		result = prime * result + y2;
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Move other = (Move) obj;
		if (x1 != other.x1) {
			return false;
		}
		if (x2 != other.x2) {
			return false;
		}
		if (y1 != other.y1) {
			return false;
		}
		if (y2 != other.y2) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Move [x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + "]";
	}
}
