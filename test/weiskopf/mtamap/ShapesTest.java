package weiskopf.mtamap;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ShapesTest {

	@Test
	public void testConstructor() throws IOException {
		Shapes shapes = new Shapes();
	}

	@Test
	public void testGetShapes() throws IOException {
		Shapes shapes = new Shapes();
		List<Shape> listOfShapes = shapes.getShapes("4..N06R");
		Assert.assertNotNull(listOfShapes);
		Assert.assertNotSame(listOfShapes.size(), 0);
	}

}
