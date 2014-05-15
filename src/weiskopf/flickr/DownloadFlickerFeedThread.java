package weiskopf.flickr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

/**
 * Retrieves the Flicker feed and calls frame.loadImages()
 */
public class DownloadFlickerFeedThread extends Thread {

	private static final String FEED_URL = "https://api.flickr.com/services/feeds/photos_public.gne?id=20952345@N03&format=json";
	private FlickerFeedFrame frame;

	public DownloadFlickerFeedThread(final FlickerFeedFrame frame) {
		this.frame = frame;

	}

	@Override
	public void run() {

		URL url = null;
		Gson gson = new Gson();
		URLConnection connection = null;
		InputStream in = null;
		try {
			url = new URL(FEED_URL);
			connection = url.openConnection();
			in = connection.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}

		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		JsonReader jsonReader = new JsonReader(reader);
		jsonReader.setLenient(true);
		try {
			jsonReader.nextString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		FlickerFeed flicker = gson.fromJson(jsonReader, FlickerFeed.class);
		frame.loadImages(flicker);
	}
}
