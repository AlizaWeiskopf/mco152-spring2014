package weiskopf.mtamap;

import java.awt.Graphics;
import java.io.IOException;
import java.util.List;

import javax.swing.JComponent;

public class MTAMap extends JComponent {

	private Routes routes;
	private Trips trips;
	private Shapes shapes;

	public MTAMap() throws IOException {
		routes = new Routes();
		trips = new Trips();
		shapes = new Shapes();
	}

	@Override
	public void paintComponent(Graphics g) {

		double width = getWidth() - 1;
		double height = getHeight() - 1;
		double minLat = shapes.getMinLat();
		double maxLat = shapes.getMaxLat();
		double minLong = shapes.getMinLong();
		double maxLong = shapes.getMaxLong();
		double latDiff = maxLat - minLat;
		double longDiff = maxLong - minLong;

		for (Route r : routes.getRoutes()) {// for each route....
			g.setColor(r.getColor());
			List<String> shapeIdsForRoute = trips.getShapeIdsForRoute(r
					.getRouteId());// all shapeIds for this route
			for (String s : shapeIdsForRoute) {
				List<Shape> shapesOfRoutes = shapes.getShapes(s);// all shapes
																	// that have
																	// this
																	// specific
																	// shapeId
				for (int i = 0; i < shapesOfRoutes.size() - 1; i++) {
					Shape currentShape = shapesOfRoutes.get(i);
					Shape nextShape = shapesOfRoutes.get(i + 1);
					int x1 = (int) (((currentShape.getLatitude() - minLat) / latDiff) * width);
					int y1 = (int) (((currentShape.getLongitude() - minLong) / longDiff) * height);
					int x2 = (int) (((nextShape.getLatitude() - minLat) / latDiff) * width);
					int y2 = (int) (((nextShape.getLongitude() - minLong) / longDiff) * height);
					g.drawLine(x1, y1, x2, y2);

				}
			}
		}
	}
}
