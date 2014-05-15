package weiskopf.ufo;

import com.google.gson.annotations.SerializedName;

public class Sighting {

	private String description;

	@SerializedName("sighted_at")
	private String sightedAt;

	@SerializedName("reported_at")
	private String reportedAt;

	private String duration;
	private String shape;
	private String location;// city and state

	public String getDescription() {
		return description;
	}

	public String getSightedAt() {
		return sightedAt;
	}

	public String getReportedAt() {
		return reportedAt;
	}

	public String getDuration() {
		return duration;
	}

	public String getShape() {
		return shape;
	}

	public String getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return "Sighting [sightedAt=" + sightedAt + ", shape=" + shape
				+ ", location=" + location + "]";
	}

}
