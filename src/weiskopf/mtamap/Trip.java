package weiskopf.mtamap;

import java.io.IOException;

public class Trip {

	private String routeId;
	private String shapeId;

	public Trip(String routeId, String shapeId) {
		this.routeId = routeId;
		this.shapeId = shapeId;
	}

	public Trip(String[] currentLine) throws IOException {
		routeId = currentLine[0];
		shapeId = currentLine[6];
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getShapeId() {
		return shapeId;
	}

	public void setShapeId(String shapeId) {
		this.shapeId = shapeId;
	}

	public String toString() {
		return "Route ID: " + routeId + " Shape ID: " + shapeId;
	}

}
