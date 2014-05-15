package weiskopf.homework;

public class Force2D {

	private double x;
	private double y;

	public Force2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getMagnitude() {
		double magnitude = Math.sqrt((x * x) + (y * y));
		return magnitude;
	}

	public double getAngle() {
		double radians = Math.atan2(y, x);
		double angle = radians * (180 / Math.PI);
		return angle;
	}

	public Force2D add(Force2D force) {
		double x = this.x + force.getX();
		double y = this.y + force.getY();
		Force2D newForce = new Force2D(x, y);
		return newForce;
	}

}
