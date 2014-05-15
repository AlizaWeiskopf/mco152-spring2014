package weiskopf.weather;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

public class Graph extends JComponent {

	private int[] degreeIntervals = { 0, 10, 20, 30, 40, 50, 60, 70, 80, 90,
			100 };
	private List<Integer> temperatures;

	public Graph(Forecast f) {
		temperatures = new ArrayList<Integer>();
		List<Conditions> list = f.getList();
		for (int i = 0; i < 10; i++) {
			temperatures.add((int) list.get(i).getMain().getTemp());
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		int y = 700;
		for (int i = 0; i < degreeIntervals.length; i++) {
			g2.drawString(String.valueOf(degreeIntervals[i]), 70, y -= 60);
		}
		int xTemp = 150;
		for (int i = 0; i < 10; i++) {
			g2.setColor(Color.MAGENTA);
			g2.drawLine(xTemp, 640, xTemp, 640 - (6 * temperatures.get(i)));
			xTemp += 60;
		}
	}

}
