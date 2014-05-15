package weiskopf.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StatisticsOfOWL {

	public static void main(String[] args) {

		char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z' };
		int[] numberOfOccurrences = new int[26];
		double[] percentage = new double[26];

		Map<String, String> listOfWords = new HashMap<String, String>();

		try {
			Scanner inputFile = new Scanner(new File("./OWL.txt"));
			while (inputFile.hasNext()) {
				listOfWords.put(inputFile.next(), inputFile.nextLine());
			}
			inputFile.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Problem reading from  file");
		}

		for (int i = 0; i < letters.length; i++) {
			for (int j = 0; j < listOfWords.size(); j++) {
				String currentWord = listOfWords.get(j);
				for (int k = 0; k < currentWord.length(); k++) {
					char currentChar = currentWord.charAt(k);
					if (currentChar == letters[i]) {
						numberOfOccurrences[i]++;
					}
				}
			}
		}

		for (int i = 0; i < letters.length; i++) {
			for (int j = 0; j < listOfWords.size(); j++) {
				String currentWord = listOfWords.get(j);
				for (int k = 0; k < currentWord.length(); k++) {
					char currentChar = currentWord.charAt(k);
					if (currentChar == letters[i]) {
						percentage[i]++;
						break;
					}
				}
			}
			percentage[i] = percentage[i] * 100 / listOfWords.size();
		}

		DecimalFormat formatter = new DecimalFormat("#0.00");
		for (int i = 0; i < letters.length; i++) {
			System.out.println(letters[i] + "\t" + numberOfOccurrences[i]
					+ "\t" + formatter.format(percentage[i]) + "%");
		}

	}

}
