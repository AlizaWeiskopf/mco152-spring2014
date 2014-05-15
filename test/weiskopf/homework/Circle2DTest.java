package weiskopf.homework;

import org.junit.Assert;
import org.junit.Test;

public class Circle2DTest {

	@Test
	public void testGetArea() {
		Circle2D theCircle = new Circle2D();
		double area = theCircle.getArea();
		double expected = Math.PI;
		double delta = .01;

		Assert.assertEquals(expected, area, delta);
	}

	@Test
	public void testGetPerimeter() {
		Circle2D theCircle = new Circle2D();
		double perimeter = theCircle.getPerimeter();
		double expected = 6.283;
		double delta = .01;

		Assert.assertEquals(expected, perimeter, delta);
	}

	@Test
	public void testContainsPoint() {
		Circle2D theCircle = new Circle2D();
		boolean containsPoint = theCircle.contains(0.5, 0.3);

		Assert.assertTrue(containsPoint);

	}

	@Test
	public void testContainsCircle() {
		Circle2D theCircle = new Circle2D();
		Circle2D aCircle = new Circle2D(0, 0, 0.5);
		boolean containsCircle = theCircle.contains(aCircle);

		Assert.assertTrue(containsCircle);
	}

	@Test
	public void testOverlap() {
		Circle2D theCircle = new Circle2D();
		Circle2D aCircle = new Circle2D(1.5, 0, 2);
		boolean overlaps = theCircle.overlaps(aCircle);

		Assert.assertTrue(overlaps);
	}

}
