package weiskopf.mtamap;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;

public class MTAMapFrame extends JFrame {

	public MTAMapFrame() {
		setTitle("MTA Map");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		try {
			this.add(new MTAMap(), BorderLayout.CENTER);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
