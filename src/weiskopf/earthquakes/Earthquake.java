package weiskopf.earthquakes;

public class Earthquake {

	private String magnitude;
	private String location;

	public String getMagnitude() {
		return magnitude;
	}

	public String getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return "Magnitude = " + magnitude + ", Location = " + location;
	}

}
