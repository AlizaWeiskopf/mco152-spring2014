package weiskopf.mtamap;

import java.awt.Color;
import java.io.IOException;

public class Route {

	private String routeId;
	private Color color;

	public Route(String routeId, Color color) {
		this.routeId = routeId;
		this.color = color;
	}

	public Route(String[] currentLine) throws IOException {
		routeId = currentLine[0];
		String color = currentLine[currentLine.length - 2];
		if (!"".equals(color)) {
			this.color = Color.decode("#" + color);
		}
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String toString() {
		return "Route ID: " + routeId + " Color: " + color;
	}

}
