package weiskopf.morsecode;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {

	@Test
	// to call something a test it must have this annotation
	public void testAlphabetToMorseCode() {// all methods begin with word test
		MorseCode morseCode = new MorseCode();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String code = morseCode.toMorseCode(alphabet);
		String expected = ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..";

		Assert.assertEquals(expected, code);

	}

	@Test
	public void testMorseCodeToAlphabet() {
		MorseCode morseCode = new MorseCode();
		String morse = ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..";
		String code = morseCode.toPlainText(morse).toLowerCase();
		String expected = "abcdefghijklmnopqrstuvwxyz";

		Assert.assertEquals(expected, code);
	}

	@Test
	public void testNumbersAndSpacesToMorseCode() {
		MorseCode morseCode = new MorseCode();
		String numbersAndSpaces = "123 456";
		String code;
		code = morseCode.toMorseCode(numbersAndSpaces);
		String expected = ".---- ..--- ...-- / ....- ..... -....";

		Assert.assertEquals(expected, code);
	}

	@Test
	public void testMorseCodeToNumbersAndSpaces() {
		MorseCode morseCode = new MorseCode();
		String morse = ".---- ..--- ...-- / ....- ..... -....";
		String code = morseCode.toPlainText(morse);
		String expected = "123 456";

		Assert.assertEquals(expected, code);
	}

	@Test
	public void testUnknownCharacters() {
		MorseCode morseCode = new MorseCode();

		String unknownCharacters = "!?*";
		String morse = morseCode.toMorseCode(unknownCharacters);
		String expectedMorse = "";

		Assert.assertEquals(expectedMorse, morse);

		String unknownMorse = "/.";
		String plainText = morseCode.toPlainText(unknownMorse);
		String expectedText = "";

		Assert.assertEquals(expectedText, plainText);

	}

	@Test
	public void testNullString() {
		MorseCode morseCode = new MorseCode();
		String nullString = null;

		try {
			morseCode.toMorseCode(nullString);
			Assert.fail();
		} catch (NullPointerException ex) {
			;
		}

		try {
			morseCode.toPlainText(nullString);
			Assert.fail();
		} catch (NullPointerException ex) {
			;
		}

	}

}
