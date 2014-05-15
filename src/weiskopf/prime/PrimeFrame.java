package weiskopf.prime;

import java.awt.BorderLayout;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class PrimeFrame extends JFrame implements ActionListener, Runnable {

	private final JButton button;
	private final JTextArea area;
	private final Scrollbar scroll;

	public PrimeFrame() {
		this.setTitle("Prime");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button = new JButton("Start");
		area = new JTextArea();
		scroll = new Scrollbar(Scrollbar.VERTICAL, 0, 1, 0, 255);
		button.addActionListener(this);

		add(button, BorderLayout.SOUTH);
		add(area, BorderLayout.CENTER);
		add(scroll, BorderLayout.EAST);

		this.setVisible(true);

	}

	public static void main(String[] args) {
		PrimeFrame app = new PrimeFrame();
		app.setVisible(true);
	}

	@Override
	public void run() {
		int prime = 0;
		for (int i = 0; i < 10000000; i++) {
			if (i % 2 != 0 && i % 3 != 3 && i % 4 != 0 && i % 5 != 0
					&& i % 6 != 0 && i % 7 != 0 && i % 8 != 0 && i % 9 != 0) {
				prime = i;
				area.append(String.valueOf(prime));
				area.append("\n");
			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t = new Thread(this);
		t.start();
	}

}
