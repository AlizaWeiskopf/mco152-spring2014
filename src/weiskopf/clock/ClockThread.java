package weiskopf.clock;

import java.awt.Color;
import java.awt.Graphics;
import java.util.GregorianCalendar;

public class ClockThread extends Thread {

	private Graphics g;
	private GregorianCalendar currentDate;

	public ClockThread(Graphics g) {
		this.g = g;
		currentDate = null;
	}

	@Override
	public void run() {
		currentDate = new GregorianCalendar();
		int second = currentDate.SECOND;
		int minute = currentDate.MINUTE;
		int hour = currentDate.HOUR;

		int centerX = 269;
		int centerY = 272;

		g.setColor(Color.RED);
		g.drawLine(centerX, centerY, 275, 114);

	}

}
