package weiskopf.clock;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JComponent;

public class ClockComponent extends JComponent implements Runnable {

	private Graphics2D g2 = null;
	private GregorianCalendar currentTime = new GregorianCalendar();

	@Override
	protected void paintComponent(Graphics g) {
		g2 = (Graphics2D) g;
		int width = getWidth();// 592
		int height = getHeight();// 573
		int xCenter = 269;
		int yCenter = 272;
		int heightOfCircle = 57;
		int bottomOfCircle = 508;
		int rightWidthOfCircle = 508;
		int leftWidthOfCircle = 59;

		g2.drawOval(width / 10, height / 10, 450, 450);
		g2.fillOval(xCenter, yCenter, 10, 10);

		// 12 o'clock
		g2.drawLine(xCenter, heightOfCircle, xCenter, heightOfCircle + 60);

		// 6 o'clock
		g2.drawLine(xCenter, bottomOfCircle, xCenter, bottomOfCircle - 60);

		// 9 o'clock
		g2.drawLine(leftWidthOfCircle, yCenter, leftWidthOfCircle + 60, yCenter);

		// 3 o'clock
		g2.drawLine(rightWidthOfCircle, yCenter, rightWidthOfCircle - 60,
				yCenter);

		int hour = currentTime.get(Calendar.HOUR);
		int minute = currentTime.get(Calendar.MINUTE);
		int second = currentTime.get(Calendar.SECOND);

		int calculation = ((int) (3.14 / 30 - 3.14 / 2));

		int xSecond = (int) (Math.cos(second * calculation) * 120 + xCenter);
		int ySecond = (int) (Math.sin(second * calculation) * 120 + yCenter);
		int xMinute = (int) (Math.cos(minute * calculation) * 100 + xCenter);
		int yMinute = (int) (Math.sin(minute * calculation) * 100 + yCenter);
		int xHour = (int) (Math.cos((hour * 30 + minute / 2) * 3.14f / 180
				- 3.14f / 2) * 80 + xCenter);
		int yHour = (int) (Math.sin((hour * 30 + minute / 2) * 3.14f / 180
				- 3.14f / 2) * 80 + yCenter);

		int xCenterOfCenter = xCenter + 5;
		int yCenterOfCenter = yCenter + 5;
		// minute hand
		g2.setColor(Color.BLUE);
		g2.drawLine(xCenterOfCenter, yCenterOfCenter, xMinute, yMinute);

		// hour hand
		g2.setColor(Color.RED);
		g2.drawLine(xCenterOfCenter, yCenterOfCenter, xHour, yHour);

		// second hand
		g2.setColor(Color.ORANGE);
		g2.drawLine(xCenterOfCenter, yCenterOfCenter, xSecond, ySecond);
	}

	public void run() {
		int centerX = 269;
		int centerY = 272;

		g2.setColor(Color.RED);
		g2.drawLine(centerX, centerY, 275, 114);
	}
}
