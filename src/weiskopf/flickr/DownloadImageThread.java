package weiskopf.flickr;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Loads a single image from a url into a JLabel
 */
public class DownloadImageThread extends Thread {
	private JLabel label;
	private String url;

	public DownloadImageThread(final JLabel label, final String url) {
		this.label = label;
		this.url = url;

	}

	@Override
	public void run() {
		Image image = null;
		try {
			image = ImageIO.read(new URL(url));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(image);
		label.setIcon(icon);

	}

}
