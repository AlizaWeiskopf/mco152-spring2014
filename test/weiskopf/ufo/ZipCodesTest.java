package weiskopf.ufo;

import java.io.IOException;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class ZipCodesTest {

	@Test
	public void testConstructor() throws IOException {
		ZipCodes zips = new ZipCodes();
	}

	@Test
	public void testGetZipLatAndLong() throws IOException {
		ZipCodes zips = new ZipCodes();
		List<String> info = zips.getZipLatAndLong("holTSVILLE", "ny");
		Assert.assertNotNull(info);
		Assert.assertNotSame(info.size(), 0);
	}

}
