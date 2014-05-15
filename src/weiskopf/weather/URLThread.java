package weiskopf.weather;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

public class URLThread extends Thread {

	private String city;
	private String state;
	private Forecast forecast;

	public URLThread(String city, String state) {
		this.city = city;
		this.state = state;
		forecast = null;
	}

	public String getCity() {
		return city;
	}

	public Forecast getForecast() {
		return forecast;
	}

	@Override
	public void run() {
		URL url;
		try {
			url = new URL("http://api.openweathermap.org/data/2.5/forecast?q="
					+ city + "," + state + "&mode=json&units=imperial");
			URLConnection connection = url.openConnection();
			InputStream data = connection.getInputStream();
			InputStreamReader reader = new InputStreamReader(data);
			Gson gson = new Gson();// Gson needs a reader
			forecast = gson.fromJson(reader, Forecast.class);
			ForecastGraph graph = new ForecastGraph(city, state, forecast);
			graph.setVisible(true);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
