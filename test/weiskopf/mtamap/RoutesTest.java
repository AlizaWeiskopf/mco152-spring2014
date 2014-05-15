package weiskopf.mtamap;

import java.awt.Color;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class RoutesTest {

	@Test
	public void testConstructor() throws IOException {
		Routes routes = new Routes();
	}

	@Test
	public void testGetColor() throws IOException {
		Routes routes = new Routes();
		Color actual = routes.getColor("4");
		Color expected = Color.decode("#" + "00933c");
		Assert.assertEquals(actual, expected);
	}

}
