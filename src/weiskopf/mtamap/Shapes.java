package weiskopf.mtamap;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Shapes {

	private List<Shape> shapes;
	private static final int DEFAULT_SKIP_LINES = 1;
	private double minLat;
	private double maxLat;
	private double minLong;
	private double maxLong;

	public Shapes() throws IOException {
		shapes = new ArrayList<Shape>();
		CSVReader reader = new CSVReader(new FileReader("./shapes.txt"), ',',
				'\'', DEFAULT_SKIP_LINES);
		String[] nextLine;
		while ((nextLine = reader.readNext()) != null) {
			Shape s = new Shape(nextLine);
			shapes.add(s);
		}
		Shape initial = shapes.get(0);// sets initial values for following 4
										// variables
		minLat = initial.getLatitude();
		maxLat = initial.getLatitude();
		minLong = initial.getLongitude();
		maxLong = initial.getLongitude();
		setMinAndMaxLatAndLong();

	}

	public List<Shape> getShapes() {
		return shapes;
	}

	public List<Shape> getShapes(String shapeId) {
		List<Shape> specificShapes = new ArrayList<Shape>();
		for (Shape s : shapes) {
			if (s.getShapeId().equals(shapeId)) {
				specificShapes.add(s);
			}
		}
		return specificShapes;
	}

	public double getMinLat() {
		return minLat;
	}

	public double getMaxLat() {
		return maxLat;
	}

	public double getMinLong() {
		return minLong;
	}

	public double getMaxLong() {
		return maxLong;
	}

	public void setMinAndMaxLatAndLong() {
		for (Shape s : shapes) {
			double latitude = s.getLatitude();
			double longitude = s.getLongitude();
			if (latitude < minLat) {
				minLat = latitude;
			}
			if (latitude > maxLat) {
				maxLat = latitude;
			}
			if (longitude < minLong) {
				minLong = longitude;
			}
			if (longitude > maxLong) {
				maxLong = longitude;
			}
		}

	}

	public String toString() {
		StringBuilder info = new StringBuilder();
		for (Shape s : shapes) {
			info.append(s.toString());
			info.append("\n");
		}
		return info.toString();
	}
}
