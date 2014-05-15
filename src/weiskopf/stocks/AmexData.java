package weiskopf.stocks;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;

public class AmexData {

	private Map<String, List<DailyPrice>> data;// pass it symbol, and all
												// dailyPrices with that symbol
	private static final int DEFAULT_SKIP_LINES = 1;

	public AmexData() throws IOException, ParseException {
		data = new HashMap<String, List<DailyPrice>>();
		getDataFromFile("./resources/amex/AMEX_daily_prices_A.csv");
		getDataFromFile("./resources/amex/AMEX_daily_prices_B.csv");
		getDataFromFile("./resources/amex/AMEX_daily_prices_C.csv");
		getDataFromFile("./resources/amex/AMEX_daily_prices_D.csv");
	}

	public void getDataFromFile(String fileName) throws IOException,
			ParseException {
		CSVReader reader = new CSVReader(new FileReader(fileName), ',', '\'',
				DEFAULT_SKIP_LINES);
		String[] currentLine;
		while ((currentLine = reader.readNext()) != null) {
			DailyPrice dp = new DailyPrice(currentLine);
			String symbol = dp.getSymbol();
			if (data.containsKey(symbol)) {
				data.get(symbol).add(dp);
			} else {
				List<DailyPrice> pricesForSymbol = new ArrayList<DailyPrice>();
				pricesForSymbol.add(dp);
				data.put(symbol, pricesForSymbol);
			}
		}
	}

	public Iterator<String> iterator() {
		return data.keySet().iterator();
	}

	public boolean contains(String symbol) {
		boolean exists = false;
		Iterator<String> iter = iterator();
		while (iter.hasNext()) {
			if (iter.next().equals(symbol.toUpperCase())) {
				exists = true;
				break;
			}
		}
		return exists;
	}

	public List<DailyPrice> getPrices(String symbol) {
		List<DailyPrice> list = new ArrayList<DailyPrice>();
		List<DailyPrice> listForSymbol = data.get(symbol.toUpperCase());
		if (listForSymbol != null) {
			list = listForSymbol;
			Collections.sort(list);
		}
		return list;
	}

	public List<DailyPrice> getPrices(String symbol, Date startDate,
			Date endDate) {
		List<DailyPrice> listWithinDates = new ArrayList<DailyPrice>();
		List<DailyPrice> list = data.get(symbol.toUpperCase());
		if (list != null) {
			for (DailyPrice dp : list) {
				Date date = dp.getDate();
				if (date.compareTo(startDate) >= 0
						&& date.compareTo(endDate) <= 0) {
					listWithinDates.add(dp);
				}
			}
			Collections.sort(listWithinDates);
		}
		return listWithinDates;
	}

}
