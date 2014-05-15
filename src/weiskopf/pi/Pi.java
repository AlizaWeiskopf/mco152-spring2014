package weiskopf.pi;

public class Pi {

	private double pi = 0;
	private double sigma = 0;
	private static final int numTimes = 1000000000;

	public double calculatePi() {

		for (int i = 1; i < numTimes; i++) {
			sigma += (Math.pow(-1, i + 1)) / (2 * i - 1);
		}
		pi = sigma * 4;
		return pi;
	}

}
