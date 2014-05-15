package weiskopf.weather;

import com.google.gson.annotations.SerializedName;

public class Rain {

	@SerializedName("3h")
	private int time;

	public String toString() {
		return "Rain [time=" + time + "]";
	}

}
