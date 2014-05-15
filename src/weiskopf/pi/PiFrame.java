package weiskopf.pi;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class PiFrame extends JFrame implements ActionListener, Runnable {

	private JButton button;
	private JTextArea area;

	public PiFrame() {
		this.setTitle("Calculate Pi");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		button = new JButton("Start");
		area = new JTextArea();

		button.addActionListener(this);

		this.add(button, BorderLayout.SOUTH);
		this.add(area, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		PiFrame frame = new PiFrame();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t = new Thread(this);// sending it a runnable
		t.start();
	}

	@Override
	public void run() {
		double pi = 0;
		int numTimes = 1000000000;

		for (int i = 1; i < numTimes; i++) {
			pi += 4 * (Math.pow(-1, i + 1) / (2 * i - 1));
			area.setText(String.valueOf(pi));
		}

	}

}
