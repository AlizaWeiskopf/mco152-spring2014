package weiskopf.stocks;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DailyPrice implements Comparable<DailyPrice> {

	private String exchange;
	private String symbol;
	private Date date;
	private double openPrice;
	private double highPrice;
	private double lowPrice;
	private double closePrice;
	private int volume;
	private double adjustedClosePrice;

	public DailyPrice(String exchange, String symbol, Date date,
			double openPrice, double highPrice, double lowPrice,
			double closePrice, int volume, double adjustedClosePrice) {
		this.exchange = exchange;
		this.symbol = symbol;
		this.date = date;
		this.openPrice = openPrice;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.closePrice = closePrice;
		this.volume = volume;
		this.adjustedClosePrice = adjustedClosePrice;
	}

	public DailyPrice(String[] currentLine) throws ParseException {
		this.exchange = currentLine[0];
		this.symbol = currentLine[1];

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.date = format.parse(currentLine[2]);

		this.openPrice = Double.parseDouble(currentLine[3]);
		this.highPrice = Double.parseDouble(currentLine[4]);
		this.lowPrice = Double.parseDouble(currentLine[5]);
		this.closePrice = Double.parseDouble(currentLine[6]);
		this.volume = Integer.parseInt(currentLine[7]);
		this.adjustedClosePrice = Double.parseDouble(currentLine[8]);
	}

	public String getExchange() {
		return exchange;
	}

	public String getSymbol() {
		return symbol;
	}

	public Date getDate() {
		return date;
	}

	public double getOpenPrice() {
		return openPrice;
	}

	public double getHighPrice() {
		return highPrice;
	}

	public double getLowPrice() {
		return lowPrice;
	}

	public double getClosePrice() {
		return closePrice;
	}

	public int getVolume() {
		return volume;
	}

	public double getAdjustedClosePrice() {
		return adjustedClosePrice;
	}

	public int compareTo(DailyPrice dp) {
		return date.compareTo(dp.getDate());
	}

}
