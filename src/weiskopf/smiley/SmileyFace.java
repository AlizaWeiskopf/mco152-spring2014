package weiskopf.smiley;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileyFace extends JComponent {

	@Override
	public void paintComponent(Graphics g) {// use this method to draw to
											// "screen"
		// g.drawLine(0, 0, this.getWidth(), this.getHeight());// draws line
		// from
		// one corner of
		// window to
		// opposite corner
		// g.drawLine(0, getHeight(), getWidth(), 0);
		g.drawOval(190, 90, 200, 200);// x,y(location on screen), width,
		// height(of oval)
		g.setColor(Color.BLUE);
		g.fillOval(250, 150, 20, 30);
		g.fillOval(300, 150, 20, 30);
		g.setColor(Color.RED);
		g.fillArc(270, 225, 30, 25, 180, 180);
		g.fillOval(getWidth() / 2 - 25, getHeight() / 2 + 25, 50, 50);
		g.setColor(Color.GREEN);
		g.fillOval(getWidth() / 2 - 25, getHeight() / 2 - 25, 50, 50);
		g.setColor(Color.BLUE);
		g.fillOval(getWidth() / 2 - 25, getHeight() / 2 + 75, 50, 50);
	}
}
