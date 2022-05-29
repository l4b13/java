import java.util.ArrayList;

public class lab3 {
    public static void main(String[] args) {
    	Place MDefaultTown = new Place("другой лунный город", Planet.Moon);
    	Place MSpaceTown = new Place("Космический городок на Луне", Planet.Moon);
    	Place MoonSide = new Place("Поверхность Луны", Planet.Moon);
    	Place ESpaceTown = new Place("Космический городок на Земле", Planet.Earth);

    	Rocket RocketFIS = new Rocket("ФИС", MSpaceTown);
    	Rocket.Engine eng = RocketFIS.new Engine();
    	Rocket RocketNIP = new Rocket("НИП", MoonSide);

    	Building SpaceStation = new Building("космодром", MSpaceTown);
    	Building Angar = new Building("ангар", MSpaceTown);
    	Building NeHouse = new Building("дом Незнайки", MSpaceTown);

    	Shorty Neznaika = new Shorty("Незнайка", Position.None, NeHouse);
    	Shorty Znaika = new Shorty("Знайка", Position.None, MSpaceTown);
    	Shorty Alpha = new Shorty("Альфа", Position.Astronom, MDefaultTown);
    	Shorty Memega = new Shorty("Мемега", Position.Lunolog, MDefaultTown);
    	Shorty Kwantik = new Shorty("Квантик", Position.Fizik, MDefaultTown);
    	Shorty Kantik = new Shorty("Кантик", Position.Fizik, MDefaultTown);
    	Shorty Fuksia = new Shorty("Фуксия", Position.None, SpaceStation);
    	Shorty Seld = new Shorty("Селедочка", Position.None, SpaceStation);

    	Thing Lunit = new Thing("лунит", Znaika);
    	Thing AntiLunit = new Thing("антилунит", Znaika);
    	Thing Drawings = new Thing("чертежи", Znaika);
    	Thing SpaceSuits = new Thing("скафандры", Znaika);
    	Furniture Bed = new Furniture("кровать", Neznaika);

    	ArrayList<Shorty> MScientists = new ArrayList<>();
    	MScientists.add(Alpha);
    	MScientists.add(Memega);
    	MScientists.add(Kwantik);
    	MScientists.add(Kantik);

    	ArrayList<Shorty> EVisiters = new ArrayList<>();
    	EVisiters.add(Znaika);
    	EVisiters.add(Neznaika);

    	ArrayList<Shorty> Mechanics = new ArrayList<>();
    	Mechanics.add(Znaika);
    	Mechanics.add(Fuksia);
    	Mechanics.add(Seld);

    	for(Shorty s:MScientists) {
    		s.MoveTo(MSpaceTown, "познакомиться с устройством ракеты и "+SpaceSuits.getType());
    	}

    	Neznaika.changeMood("радостное");

    	Shorty DrPilul = new Shorty("Пилюлькин", Position.Doctor, NeHouse) {
    		@Override
    		public void Advice(Shorty s) {
    			System.out.println(getName()+" сказал: "+s.getName()+", веди себя спокойнее, твой организм ослаблен болезнью, береги силы.");
    			s.changeMood("нетерпеливое");
    		}
    	};
    	DrPilul.Advice(Neznaika);
    	//DrPilul.Say(Neznaika.getName()+" веди себя спокойнее, твой организм ослаблен болезнью, береги силы.");		
		//Neznaika.changeMood("нетерпеливое");
    	Neznaika.LayDown(Bed);
    	Neznaika.GetUp();
    	
    	Znaika.Give(Lunit, Alpha);
    	Znaika.Give(AntiLunit, Alpha);
    	Znaika.Give(Drawings, Alpha);

    	Alpha.Say("Мы сохраним "+MSpaceTown.getName()+" в порядке и устроим здесь "+SpaceStation.getName()+" с площадкой для посадки ракет.");

    	for(Shorty s:Mechanics) {
    		s.MoveTo(Angar, "проверить ракеты");
    	}

    	for(Shorty s:MScientists) {
    		s.MoveTo(Angar, "проверить ракеты");
    	}
    	
    	eng.Repair(Znaika);

    	ArrayList<Shorty> pasFIS = new ArrayList<>();
    	pasFIS.add(Alpha);
    	pasFIS.add(Memega);
    	pasFIS.add(Znaika);
    	pasFIS.add(Neznaika);
    	
    	RocketFIS.Fly(MoonSide, pasFIS);
    	pasFIS.remove(Znaika);
    	pasFIS.remove(Neznaika);

    	RocketNIP.Fly(ESpaceTown, EVisiters);

    	RocketFIS.Fly(MSpaceTown, pasFIS);
    }
}