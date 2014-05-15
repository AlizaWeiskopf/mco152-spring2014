package weiskopf.weather;

import javax.swing.JFrame;

public class ForecastGraph extends JFrame {

	public ForecastGraph(String city, String state, Forecast forecast) {
		setTitle("Forecast for " + city + "," + state);
		setSize(700, 700);
		setLocationRelativeTo(null);

		add(new Graph(forecast));

	}

}
