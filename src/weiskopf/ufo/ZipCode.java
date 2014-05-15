package weiskopf.ufo;

public class ZipCode {

	private String zipCode;
	private String latitude;
	private String longitude;
	private String city;
	private String state;

	public ZipCode(String zipCode, String latitude, String longitude,
			String city, String state) {
		this.zipCode = zipCode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.city = city;
		this.state = state;
	}

	public ZipCode(String[] currentLine) {
		zipCode = currentLine[0];
		latitude = currentLine[1];
		longitude = currentLine[2];
		city = currentLine[3];
		state = currentLine[4];
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ZipCode [zipCode=" + zipCode + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", city=" + city + ", state="
				+ state + "]";
	}

}
