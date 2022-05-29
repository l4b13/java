import java.util.ArrayList;

public class Rocket {
	private String Name;
	private Place Location;
	private int flightCount = 0;
	private static int maxPasCount = 10;
	private boolean status = true;

	public Rocket(String Name, Place Location) {
		this.Name = Name;
		this.Location = Location;
		flightCount = 0;
	}


	public String getName() {
		return Name;
	}

	public static class Drawing {
		public static int getMaxPasCount() {
			return maxPasCount;
		}
	}

	public class Engine {
		public boolean getStatus() {
			return status;
		}
		public void Repair(Shorty s) {
			try {
				if (s == null) throw new InitException("Коротышка");
				if (status == false) {
					status = true;
					System.out.println("Коротышка "+s.getName()+" починил ракету.");
				} else System.out.println(s.getName()+": ракета в норме, ремонт не требуется.");
			} catch(InitException e) {
				e.printStackTrace();
				System.out.println("Никто не приступил к починке ракеты.");
			}
		}
	}

	public void Fly(Place pl, ArrayList<Shorty> pas) {
		class Flight {
			boolean Start() {
				try {
					if (pl == null) throw new InitException("Точка прибытия"+" не существует.");
					if (pas == null) throw new InitException("Список пассажиров ракеты");
					if (Location.equals(pl)) throw new BasicException("Ракета "+getName()+" не может полететь туда, где она уже находится.");
					if (pas.size()==0) throw new BasicException("Ракета "+getName()+" не может полететь без пассажиров.");
					return true;
				} catch(InitException eI) {
					System.out.println(eI.getE());
					System.out.println("Полет отменяется.");
					return false;
				} catch(BasicException eB) {
					System.out.println(eB.getE());
					System.out.println("Полет отменяется.");
					return false;
				}
			}
		}
		Flight _flight = new Flight();

		if (_flight.Start()) {
			System.out.println("Ракета "+Name+" совершила полет к "+pl.getName()+".");
			for(Shorty s:pas) {
				s.MoveTo(pl);
			}
			Location = pl;
			flightCount++;
			if (flightCount > 5) {
				status = false;
				flightCount = 0;
			}
		}
	}
}