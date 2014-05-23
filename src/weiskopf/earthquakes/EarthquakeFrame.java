package weiskopf.earthquakes;

import javax.swing.JFrame;
import javax.swing.JList;

public class EarthquakeFrame extends JFrame {

	private JList list;

	public EarthquakeFrame() {
		setTitle("Earthquake Data");
		setSize(400, 620);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		list = new JList();
		list.setCellRenderer(new CellColorRenderer());
		this.add(list);

		DownloadEarthquakeFeed data = new DownloadEarthquakeFeed(this, list);
		data.start();

		setVisible(true);

	}

}
