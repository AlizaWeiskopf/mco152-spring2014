package weiskopf.ufo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class ListSightings {

	public static void main(String[] args) throws JsonIOException,
			JsonSyntaxException, FileNotFoundException {

		Gson gson = new Gson();
		FileReader reader = new FileReader("ufo_awesome.json");
		// reader.setLenient(true);// accept the fact that there is no comma in
		// between records
		Sightings list = gson.fromJson(reader, Sightings.class);
		Map<String, List<Sighting>> map = new HashMap<String, List<Sighting>>();// string
																				// is
																				// the
																				// location

		for (Sighting s : list) {
			String location = s.getLocation();
			List<Sighting> sightings = map.get(location);// returns value that
															// this key is
															// mapped to
			if (sightings == null) {
				sightings = new ArrayList<Sighting>();
			}
			sightings.add(s);
			map.put(location, sightings);
		}

		System.out.println(list.size());

		List<Sighting> specificSightings = new ArrayList<Sighting>();
		for (Sighting s : list) {
			if (s.getSightedAt().equals("19950115")) {
				specificSightings.add(s);
			}
		}

		ZipCodes zipsOfSightings = null;
		try {
			zipsOfSightings = new ZipCodes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Sighting s : specificSightings) {
			StringTokenizer tokenizer = new StringTokenizer(s.getLocation(),
					",");
			String city = tokenizer.nextToken().trim();
			String state = tokenizer.nextToken().trim();
			List<String> dataForLocations = zipsOfSightings.getZipLatAndLong(
					city, state);
			System.out
					.println(s.toString().concat(dataForLocations.toString()));
		}

	}

}
