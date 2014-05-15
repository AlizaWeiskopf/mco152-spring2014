package weiskopf.mtamap;

import java.io.IOException;

public class Shape {// responsibility is one line in the shape file - which is
					// really one point on the line

	private String shapeId;
	private double latitude;
	private double longitude;

	public Shape(String shapeId, double latitude, double longitude) {
		this.shapeId = shapeId;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Shape(String[] currentLine) throws IOException {
		shapeId = currentLine[0];
		latitude = Double.valueOf(currentLine[1]);
		longitude = Double.valueOf(currentLine[2]);
	}

	public String getShapeId() {
		return shapeId;
	}

	public void setShapeId(String shapeId) {
		this.shapeId = shapeId;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String toString() {
		return "Shape ID: " + shapeId + " Latitude: " + latitude
				+ " Longitude: " + longitude;
	}

}
