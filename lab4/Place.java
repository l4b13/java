public class Place extends ALocation{
	private Planet Location;
	public Place(String Name, Planet Location) {
		super(Name);
		try {
			if (Location == null) throw new InitException("Планеты"+" не существует");
			this.Location = Location;
		} catch(InitException e) {
			e.printStackTrace();
			this.Location = Planet.Other;
		}
		
	}
	public Planet getPlanet() {
		return Location;
	}
}