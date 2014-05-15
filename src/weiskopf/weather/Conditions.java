package weiskopf.weather;

import java.util.ArrayList;

public class Conditions {

	private int dt;
	private Main main;
	private ArrayList<Object> weather;
	private Clouds clouds;
	private Wind wind;
	private Sys sys;
	private String dt_txt;

	public int getDt() {
		return dt;
	}

	public Main getMain() {
		return main;
	}

	public ArrayList<Object> getWeather() {
		return weather;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public Wind getWind() {
		return wind;
	}

	public Sys getSys() {
		return sys;
	}

	public String getDt_txt() {
		return dt_txt;
	}

	@Override
	public String toString() {
		return "Conditions [dt=" + dt + ", main=" + main + ", weather="
				+ weather + ", clouds=" + clouds + ", wind=" + wind + ", sys="
				+ sys + ", dt_txt=" + dt_txt + "]";
	}

}
