package weiskopf.homework;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

	@Test
	public void testTriangle() {
		Triangle t = new Triangle(6);
		String result = t.toString();
		String expected = "     *" + "\n    * *" + "\n   *   *" + "\n  *     *"
				+ "\n *       *" + "\n***********";
		Assert.assertEquals(result, expected);
	}

	@Test
	public void testTriangleZero() {
		Triangle t = new Triangle(0);
		String result = t.toString();
		String expected = "";
		Assert.assertEquals(result, expected);
	}

	@Test
	public void testTriangleNegNum() {
		try {
			Triangle t = new Triangle(-2);
			t.toString();
			Assert.fail();// if reaches this point, test fails because should
							// have thrown neg array size exception
		} catch (NegativeArraySizeException neg) {
			;// expect to reach to this point
		}
	}
}
