package weiskopf.flickr;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class FlickerFeedFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel[] labels;
	private Thread download;
	private JScrollPane pane;
	private JPanel panel;

	public FlickerFeedFrame() {
		labels = new JLabel[20];
		panel = new JPanel();
		pane = new JScrollPane(panel);
		this.setTitle("Flickr");
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel();
			panel.add(labels[i]);

		}
		this.add(pane);
		download = new DownloadFlickerFeedThread(this);
		download.start();
	}

	/**
	 * Runs a LoadImageThread for each image in the feed
	 */
	public void loadImages(final FlickerFeed feed) {
		Item[] items = feed.getItems();
		for (int i = 0; i < items.length; i++) {
			String url = items[i].getMedia().getM();
			Thread loadImage = new DownloadImageThread(labels[i], url);
			loadImage.start();
		}

	}

	public static void main(final String args[]) {
		new FlickerFeedFrame().setVisible(true);
	}

}
