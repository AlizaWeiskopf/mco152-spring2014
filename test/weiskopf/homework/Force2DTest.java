package weiskopf.homework;

import org.junit.Assert;
import org.junit.Test;

public class Force2DTest {

	@Test
	public void testGetMagnitude() {
		Force2D force = new Force2D(3, 10);
		double magnitude = force.getMagnitude();
		double expected = 10.44030651;
		double delta = .1;
		Assert.assertEquals(expected, magnitude, delta);
	}

	@Test
	public void testGetAngle() {
		Force2D force = new Force2D(3, 10);
		double angle = force.getAngle();
		double expected = 73.301;
		double delta = .1;

		Assert.assertEquals(expected, angle, delta);
	}

	@Test
	public void testAddForce() {
		Force2D force1 = new Force2D(3, 10);
		Force2D force2 = new Force2D(2, 3);
		Force2D newForce = force1.add(force2);
		Force2D expected = new Force2D(5, 13);
		double delta = .01;

		Assert.assertEquals(newForce.getX(), expected.getX(), delta);
		Assert.assertEquals(newForce.getY(), expected.getY(), delta);

	}

}
