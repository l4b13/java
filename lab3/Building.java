public class Building extends ALocation {
	private City Location;
	public Building(String Name, City Location) {
		super(Name);
		this.Location = Location;
	}
	public City getCity() {
		return Location;
	}
}