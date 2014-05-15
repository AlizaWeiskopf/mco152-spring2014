package weiskopf.dictionary;

import java.io.FileNotFoundException;

import junit.framework.Assert;

import org.junit.Test;

public class DictionaryTest {

	@Test
	public void testWordInDictionary() throws FileNotFoundException {
		Dictionary d = new Dictionary();
		boolean word = d.exists("CRENATE");

		Assert.assertTrue(word);
	}

	@Test
	public void testWordNotInDictionary() throws FileNotFoundException {
		Dictionary d = new Dictionary();
		boolean word = d.exists("ALIZA");

		Assert.assertFalse(word);
	}

	@Test
	public void testMixedCase() throws FileNotFoundException {
		Dictionary d = new Dictionary();
		boolean word = d.exists("Driver");

		Assert.assertTrue(word);
	}

	@Test
	public void testSpaces() throws FileNotFoundException {
		Dictionary d = new Dictionary();
		boolean word = d.exists(("  DEMONSTRATIVES  "));

		Assert.assertTrue(word);
	}

}
