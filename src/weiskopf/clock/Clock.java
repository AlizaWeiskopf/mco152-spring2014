package weiskopf.clock;

import java.text.DecimalFormat;

public class Clock {

	private int seconds;
	private int minutes;
	private int hours;

	public Clock() {
		seconds = 0;
		minutes = 0;
		hours = 0;
	}

	public Clock(int hours, int minutes, int seconds) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public double getSecondAngle(int seconds) {
		double secondAngle = seconds * 6;
		return secondAngle;
	}

	public double getMinuteAngle() {
		double minuteAngle = (6 * minutes) + (seconds * .1);
		return minuteAngle;
	}

	public double getHourAngle() {
		double hourAngle = (hours * 30) + (.5 * minutes) + (seconds * .0083);
		return hourAngle;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public void increaseSeconds() {
		seconds++;
		if (seconds == 60) {
			seconds = 0;
			minutes++;
			if (minutes == 60) {
				minutes = 0;
				hours++;
				if (hours == 13) {
					hours = 1;
				}
			}
		}
	}

	public int getMinutes() {
		return minutes;

	}

	public String toString() {
		DecimalFormat formatter = new DecimalFormat("00");
		return hours + ":" + minutes + ":" + formatter.format(seconds) + " "
				+ getHourAngle() + ":" + getMinuteAngle() + ":"
				+ getSecondAngle(seconds);

	}
}
