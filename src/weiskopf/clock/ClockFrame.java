package weiskopf.clock;

import javax.swing.JFrame;

public class ClockFrame extends JFrame {

	public ClockFrame() {
		setTitle("Clock");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(new ClockComponent());

	}
}
