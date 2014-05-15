package weiskopf.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {

	private Map<String, String> map;// has a unique key and a value

	public Dictionary() throws FileNotFoundException {
		map = new HashMap<String, String>();

		Scanner inputFile = new Scanner(new File("./OWL.txt"));
		while (inputFile.hasNext()) {
			map.put(inputFile.next(), inputFile.nextLine());
		}
		inputFile.close();
	}

	public Iterator<String> iterator() {
		return map.keySet().iterator();// have set of all of my keys
	}

	public boolean exists(String word) {// looking for the key
		return map.containsKey(word.toUpperCase().trim());// efficiency
															// is O(1)
	}

	public String getDefinition(String word) {
		return map.get(word.toUpperCase());// pass it the key, get the value
											// if word doesn't exist will return
											// null
	}

}
