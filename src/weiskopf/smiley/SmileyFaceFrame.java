package weiskopf.smiley;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class SmileyFaceFrame extends JFrame {

	public SmileyFaceFrame() {
		this.setTitle("Smiley Face");
		this.setSize(580, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(new SmileyFace(), BorderLayout.CENTER);

	}

}
