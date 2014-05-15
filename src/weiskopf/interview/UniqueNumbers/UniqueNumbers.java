package weiskopf.interview.UniqueNumbers;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UniqueNumbers {

	private Map<Integer, Integer> numbers;

	public UniqueNumbers() {
		numbers = new HashMap<Integer, Integer>();// number and how many times
													// it was entered
	}

	public void addNumber(int number) {
		if (numbers.containsKey(number)) {
			int numTimes = numbers.get(number);
			numbers.put(number, ++numTimes);
		} else {
			numbers.put(number, 1);
		}

	}

	public Map<Integer, Integer> getUniqueNumbers() {
		return numbers;
	}

	public static void main(String[] args) {
		UniqueNumbers numbers = new UniqueNumbers();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 10 integers");
		for (int i = 0; i < 10; i++) {
			numbers.addNumber(input.nextInt());
		}
		System.out.println(numbers.getUniqueNumbers());
	}

}
