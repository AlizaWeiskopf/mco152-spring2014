package weiskopf.ufo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class ZipCodes {

	private List<ZipCode> zipCodes;

	public ZipCodes() throws IOException {
		zipCodes = new ArrayList<ZipCode>();
		CSVReader reader = new CSVReader(new FileReader("./ZIP_CODES.txt"));
		String[] currentLine;
		while ((currentLine = reader.readNext()) != null) {
			ZipCode zip = new ZipCode(currentLine);
			zipCodes.add(zip);
		}
	}

	public List<String> getZipLatAndLong(String city, String state) {// returns
																		// a
																		// list
																		// because
																		// may
																		// be
																		// more
																		// then
																		// one
																		// zipcode
																		// for
																		// one
																		// city
																		// and
																		// state
		List<String> data = new ArrayList<String>();
		String city1 = city.toUpperCase();
		String state1 = state.toUpperCase();
		for (ZipCode z : zipCodes) {
			if (z.getCity().equals(city1) && z.getState().equals(state1)) {
				data.add(z.toString());
			}
		}
		return data;
	}

}
