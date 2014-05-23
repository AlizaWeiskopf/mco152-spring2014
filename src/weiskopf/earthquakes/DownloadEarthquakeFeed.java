package weiskopf.earthquakes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import com.google.gson.Gson;

public class DownloadEarthquakeFeed extends Thread {

	private JList list;
	private EarthquakeFrame frame;

	public DownloadEarthquakeFeed(EarthquakeFrame frame, JList list) {
		this.list = list;
		this.frame = frame;
	}

	@Override
	public void run() {

		URL url;
		try {
			while (true) {
				sleep(1000);

				url = new URL(
						"http://earthquake-report.com/feeds/recent-eq?json");
				URLConnection connection = url.openConnection();
				InputStream in = connection.getInputStream();

				BufferedReader reader = new BufferedReader(
						new InputStreamReader(in));
				Gson gson = new Gson();
				Earthquakes data = gson.fromJson(reader, Earthquakes.class);
				list.setModel(new DefaultListModel());

				frame.repaint();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
