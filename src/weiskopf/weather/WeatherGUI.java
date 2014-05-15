package weiskopf.weather;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class WeatherGUI extends JFrame {

	private String locationText;

	private JLabel locationLabel;
	private JTextField location;
	private JButton conditions;

	public WeatherGUI() {
		setTitle("Weather GUI");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		locationLabel = new JLabel(
				"Enter name of location in format City,state or country");
		location = new JTextField(20);
		conditions = new JButton("Get weather conditions");
		conditions.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				locationText = location.getText();
				StringTokenizer tokenizer = new StringTokenizer(locationText,
						",");
				try {
					String city = tokenizer.nextToken();
					String state = tokenizer.nextToken();
					URLThread t = new URLThread(city, state);
					t.start();

				} catch (NoSuchElementException ex) {
					JOptionPane
							.showMessageDialog(null,
									"Invalid Location - please re-enter in format City,State");
				}
			}

		});

		this.add(locationLabel, BorderLayout.NORTH);
		this.add(location, BorderLayout.CENTER);
		this.add(conditions, BorderLayout.SOUTH);
	}

	public String getLocationText() {
		return locationText;
	}

}
