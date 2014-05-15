//url for homework
//http://api.openweathermap.org/data/2.5/forecast?q=Brooklyn,NY&mode=json&units=imperial

package weiskopf.weather;

import java.io.IOException;

public class GUIDriver {

	public static void main(String[] args) throws IOException {

		WeatherGUI window = new WeatherGUI();
		window.setVisible(true);
		window.pack();

	}
}
