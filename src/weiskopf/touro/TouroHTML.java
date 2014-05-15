package weiskopf.touro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class TouroHTML {

	public static void main(String[] args) throws IOException {

		URL url = new URL("http://www.touro.edu/students");// must include http

		URLConnection connection = url.openConnection();
		InputStream in = connection.getInputStream();// return bytes
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));// an
																				// InputStreamReader
																				// changes
																				// bytes
																				// to
																				// strings,
																				// BufferedReader
																				// has
																				// readLine
																				// method

		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);// prints out html of this page, what is
										// sent back to the browser, same as
										// right clicking on page and clicking
										// View Page Source
		}
	}

}
