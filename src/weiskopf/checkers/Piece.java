package weiskopf.checkers;

import java.awt.Color;

/**
 * 
 * You do not instantiate this class. Use the constants and their methods
 * 
 * Piece.WHITE_MAN, Piece.RED_MAN, Piece.WHITE_KING, Piece.RED_KING
 * 
 * 
 * This class does not need to be modified
 */
public class Piece {

	public static final Piece WHITE_MAN = new Piece(Color.WHITE, false);
	public static final Piece RED_MAN = new Piece(Color.RED, false);
	public static final Piece WHITE_KING = new Piece(Color.WHITE, true);
	public static final Piece RED_KING = new Piece(Color.RED, true);

	private final Color color;
	private final boolean isKing;

	private Piece(final Color color, final boolean isKing) {
		this.color = color;
		this.isKing = isKing;
	}

	public Color getColor() {
		return color;
	}

	public boolean isKing() {// getKing
		return isKing;
	}

	public boolean isColor(final Color color) {// does color equal
		return this.color.equals(color);
	}

	public boolean isEnemyColor(final Color color) {
		return !this.color.equals(color);
	}

	public boolean isSameColor(final Piece piece) {
		return piece.color.equals(this.color);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + (isKing ? 1231 : 1237);
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
		final Piece other = (Piece) obj;
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
			return false;
		}
		if (isKing != other.isKing) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		if (color == Color.RED) {
			if (isKing) {
				return "R";
			}
			return "r";
		}
		if (isKing) {
			return "W";
		}
		return "w";
	}

}
