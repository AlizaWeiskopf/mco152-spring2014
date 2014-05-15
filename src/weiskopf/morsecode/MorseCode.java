package weiskopf.morsecode;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MorseCode {

	private Map<String, String> charactersAndMorseCode;

	private String[] morseCodeCharacters = { "A", "B", "C", "D", "E", "F", "G",
			"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
			"U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6",
			"7", "8", "9", " " };
	private String[] morseCode = { ".-", "-...", "-.-.", "-..", ".", "..-.",
			"--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
			".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
			"-.--", "--..", "-----", ".----", "..---", "...--", "....-",
			".....", "-....", "--...", "---..", "----.", "/" };

	public MorseCode() {
		charactersAndMorseCode = new HashMap<String, String>();
		for (int i = 0; i < morseCodeCharacters.length; i++) {
			charactersAndMorseCode.put(morseCodeCharacters[i], morseCode[i]);
			charactersAndMorseCode.put(morseCode[i], morseCodeCharacters[i]);
		}
	}

	public String toMorseCode(String plainText) {
		String newPlainText = plainText.toUpperCase();
		StringBuilder morseCode = new StringBuilder();
		for (int i = 0; i < newPlainText.length(); i++) {
			String character = String.valueOf(newPlainText.charAt(i));
			if (charactersAndMorseCode.containsKey(character)) {
				String morse = charactersAndMorseCode.get(character);
				morseCode.append(morse);
				morseCode.append(" ");
			}

		}

		return morseCode.toString().trim();
	}

	public String toPlainText(String morseCode) {
		StringBuilder plainText = new StringBuilder();
		StringTokenizer tokenizer = new StringTokenizer(morseCode, " ");
		for (int i = tokenizer.countTokens(); i > 0; i--) {
			String currentToken = tokenizer.nextToken();
			if (charactersAndMorseCode.containsKey(currentToken)) {
				plainText.append(charactersAndMorseCode.get(currentToken));
			}
		}
		return plainText.toString();
	}

}
