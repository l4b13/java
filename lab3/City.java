public class City extends ALocation{
	private Planet Location;
	public City(String Name, Planet Location) {
		super(Name);
		this.Location = Location;
	}
	public Planet getPlanet() {
		return Location;
	}
}