package weiskopf.mtamap;

import java.awt.Color;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Routes {

	private List<Route> routes;
	private static final int DEFAULT_SKIP_LINES = 1;

	public Routes() throws IOException {
		routes = new ArrayList<Route>();
		CSVReader reader = new CSVReader(new FileReader("./routes.txt"), ',',
				'\'', DEFAULT_SKIP_LINES);
		String[] currentLine;
		while ((currentLine = reader.readNext()) != null) {
			Route r = new Route(currentLine);
			routes.add(r);
		}
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public Color getColor(String routeId) {
		Color color = null;
		for (Route r : routes) {
			if (r.getRouteId().equals(routeId)) {
				color = r.getColor();
			}
		}
		return color;
	}

	public String toString() {
		StringBuilder info = new StringBuilder();
		for (Route r : routes) {
			info.append(r.toString());
			info.append("\n");
		}
		return info.toString();
	}

}
