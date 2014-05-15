package weiskopf.weather;

import java.util.ArrayList;

public class Forecast {

	private String cod;
	private double message;
	private City city;
	private double cnt;
	private ArrayList<Conditions> list;

	public String getCod() {
		return cod;
	}

	public double getMessage() {
		return message;
	}

	public City getCity() {
		return city;
	}

	public double getCnt() {
		return cnt;
	}

	public ArrayList<Conditions> getList() {
		return list;
	}

	@Override
	public String toString() {
		return "Forecast [cod=" + cod + ", message=" + message + ", city="
				+ city + ", cnt=" + cnt + ", list=" + list + "]";
	}

}
