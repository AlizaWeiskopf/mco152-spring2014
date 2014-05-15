package weiskopf.homework;

public class Triangle {

	private int height;

	public Triangle(int height) {
		this.height = height;
	}

	public String toString() {
		char[][] triangle = new char[height][];
		for (int i = 0; i < height; i++) {
			triangle[i] = new char[height + i];
		}
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				triangle[i][j] = ' ';// initialize all elements to a space
			}
		}
		int lengthOfRow = 0;
		int numSpaces = 0;
		int positionOnRow = 0;
		for (int i = height - 1; i >= 0; i--) {
			lengthOfRow = triangle[i].length;
			for (int j = 0; j < lengthOfRow; j++) {
				if (i == height - 1) {
					triangle[i][j] = '*';
				} else {
					numSpaces++;
					positionOnRow = numSpaces;
					triangle[i][positionOnRow] = '*';
					triangle[i][lengthOfRow - 1] = '*';// last spot gets a star
					break;
				}
			}
		}
		StringBuilder triangleString = new StringBuilder();
		for (int i = 0; i < height; i++) {
			if (i != 0) {
				triangleString.append("\n");
			}
			for (int j = 0; j < triangle[i].length; j++) {
				triangleString.append(triangle[i][j]);
			}
		}
		return triangleString.toString();

	}
}
