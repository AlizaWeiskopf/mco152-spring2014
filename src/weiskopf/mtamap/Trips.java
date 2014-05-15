package weiskopf.mtamap;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Trips {

	private List<Trip> trips;
	private static final int DEFAULT_SKIP_LINES = 1;

	public Trips() throws IOException {
		trips = new ArrayList<Trip>();
		CSVReader reader = new CSVReader(new FileReader("./trips.txt"), ',',
				'\'', DEFAULT_SKIP_LINES);
		String[] currentLine;
		while ((currentLine = reader.readNext()) != null) {
			Trip t = new Trip(currentLine);
			trips.add(t);
		}
	}

	public List<Trip> getTrips() {
		return trips;
	}

	public Trip getTrip(String shapeId) {
		Trip trip = null;
		for (Trip t : trips) {
			if (t.getShapeId().equals(shapeId)) {
				trip = t;
			}
		}
		return trip;
	}

	public List<String> getShapeIdsForRoute(String routeId) {
		List<String> shapeIdsForRoute = new ArrayList<String>();
		for (Trip t : trips) {
			if (t.getRouteId().equals(routeId)) {
				String shapeId = t.getShapeId();
				if (!shapeIdsForRoute.contains(shapeId)) {
					shapeIdsForRoute.add(shapeId);
				}
			}
		}
		return shapeIdsForRoute;
	}

	public String toString() {
		StringBuilder info = new StringBuilder();
		for (Trip t : trips) {
			info.append(t.toString());
			info.append("\n");
		}
		return info.toString();
	}

}
