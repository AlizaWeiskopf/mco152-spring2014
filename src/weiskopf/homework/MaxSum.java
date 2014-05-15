package weiskopf.homework;

import java.util.Scanner;

public class MaxSum {

	private Integer[][] square;
	private int size;

	public MaxSum(int size) {
		this.size = size;
		square = new Integer[size][size];
	}

	public void addNumbers(Scanner input) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				square[i][j] = input.nextInt();
			}
		}
	}

	public int getMaxSum() {
		int maxSum = 0;
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				for (int height = 0; height < size; height++) {
					for (int width = 0; width < size; width++) {
						int sum = 0;
						for (int row = y; row <= height; row++) {
							for (int column = x; column <= width; column++) {
								sum += square[row][column];
							}
						}
						if (sum > maxSum) {
							maxSum = sum;
						}
					}
				}
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter size of square followed by the values");
		int size = input.nextInt();
		MaxSum square = new MaxSum(size);
		square.addNumbers(input);
		int max = square.getMaxSum();
		System.out.println("Max Sum: " + max);
	}
}
