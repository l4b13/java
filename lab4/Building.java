public class Building extends ALocation {
	private Place Location;
	public Building(String Name, Place Location) {
		super(Name);
		try {
			if (Location == null) throw new InitException("Локация");
			this.Location = Location;
		} catch(InitException e) {
			e.printStackTrace();
			this.Location = new Place("???", Planet.Other);
		}
	}
	public Place getPlace() {
		return Location;
	}
}