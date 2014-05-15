package weiskopf.stocks;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AmexDataTest {

	@Test
	public void testConstructor() throws IOException, ParseException {
		AmexData data = new AmexData();
	}

	@Test
	public void testContains() throws IOException, ParseException {
		AmexData data = new AmexData();
		boolean actual1 = data.contains("bHh");
		Assert.assertTrue(actual1);
		boolean actual2 = data.contains("kbe");
		Assert.assertFalse(actual2);
	}

	@Test
	public void testGetPrices() throws IOException, ParseException {
		AmexData data = new AmexData();
		List<DailyPrice> list = data.getPrices("afo");
		Assert.assertNotNull(list);
		int size = list.size();
		Assert.assertNotSame(size, 0);
		DailyPrice first = list.get(0);
		DailyPrice last = list.get(size - 1);
		int isInAscendingOrder = first.getDate().compareTo(last.getDate());
		Assert.assertTrue(isInAscendingOrder < 0);

		List<DailyPrice> list1 = data.getPrices("zdr");
		Assert.assertNotNull(list);
		Assert.assertSame(list1.size(), 0);

	}

	@Test
	public void testGetPricesForSpecificDates() throws IOException,
			ParseException {
		AmexData data = new AmexData();
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		String stringStartDate = "5/8/2009";
		Date startDate = format.parse(stringStartDate);
		String stringEndDate = "2/8/2010";
		Date endDate = format.parse(stringEndDate);

		List<DailyPrice> list = data.getPrices("CXM", startDate, endDate);
		Assert.assertNotNull(list);
		int size = list.size();
		Assert.assertNotSame(size, 0);
		for (DailyPrice dp : list) {
			Date date = dp.getDate();
			int compareToStart = date.compareTo(startDate);
			int compareToEnd = date.compareTo(endDate);
			boolean a = compareToStart == 0 || compareToStart > 0;
			Assert.assertTrue(a);
			boolean b = compareToEnd == 0 || compareToEnd < 0;
			Assert.assertTrue(b);
		}

		DailyPrice first = list.get(0);
		DailyPrice last = list.get(size - 1);
		int isInAscendingOrder = first.getDate().compareTo(last.getDate());
		Assert.assertTrue(isInAscendingOrder < 0);

		List<DailyPrice> list1 = data.getPrices("GZR", startDate, endDate);
		Assert.assertNotNull(list1);
		Assert.assertSame(list1.size(), 0);
	}

}
