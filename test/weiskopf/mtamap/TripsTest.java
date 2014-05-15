package weiskopf.mtamap;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

public class TripsTest {

	@Test
	public void testConstructor() throws IOException {
		Trips trips = new Trips();
	}

	@Test
	public void testGetTrip() throws IOException {
		Trips trips = new Trips();
		Trip actual = trips.getTrip("4..S01R");
		String routeId = actual.getRouteId();
		String expected = "4";
		Assert.assertEquals(routeId, expected);
	}

}
