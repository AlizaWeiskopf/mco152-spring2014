package weiskopf.weather;

public class City {

	private String id;
	private String name;
	private Coordinates coord;
	private String country;
	private int population;

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", coord=" + coord
				+ ", country=" + country + ", population=" + population + "]";
	}

}
