public class Shorty implements IDefault, IShorty {
	private String Name; //имя
	private Position currentP; //должность
	private String currentL; //местонахождение
	private String status; //положение тела
	private String mood; //настроение
	private String reason; //причина местонахождения, по умолчанию - ее нет, отвечает на вопрос "зачем?"

	public Shorty(String Name, Position p, ALocation pl) {
		this.Name = Name;
		status = "стоит";
		mood = "нормальное";
		reason = "";
		try {
			if (p == null) throw new InitException("Должности"+" не существует");
			currentP = p;
		} catch(InitException e) {
			e.printStackTrace();
			currentP = Position.None;
		}
		try {
			if (pl == null) throw new InitException("Место");
			currentL = pl.getName();
		} catch(InitException e) {
			e.printStackTrace();
			currentL = "???";
		}
	}

	public String getName() {
		return Name;
	}

	public void changeMood(String s) {
		mood = s;
		System.out.println("Настроение "+Name+" сменилось на "+s);
	}

	public String getLocation() {
		return currentL;
	}

	@Override
	public void Say(String s) {
		System.out.println(Name + " сказал: " + s);
	}

	@Override
	public void LayDown(Furniture f) {
		try {
			if (f == null) throw new InitException("Мебель");
			status = "лежит на " + f.getType();
			System.out.println(Name + " лег на " + f.getType());
		} catch(InitException e) {
			e.printStackTrace();
			System.out.println("Коротышка "+Name+" ничего не сделал.");
		}
	}

	@Override
	public void GetUp()  {
		status = "стоит";
		System.out.println(Name + " встал");
	}

	@Override
	public void Give(AThing t, Shorty s) {
		try {
			if (s.equals(this)) throw new BasicException("Коротышка "+Name+" не может передать предмет себе");
			t.newOwner(s);
			System.out.println(Name + " передал(а) " + s.getName() + " предмет " + t.getType());
		} catch(InitException e) {
			e.printStackTrace();
			System.out.println("Предмет не был передан.");
		} catch(BasicException e) {
			e.printStackTrace();
			System.out.println("Передача предмета "+t.getType()+" самому себе не произошла.");
		}
	}

	@Override
	public void MoveTo(ALocation l) {
		try {
			if (l == null) throw new InitException("Локация");
			currentL = l.getName();
			System.out.println(Name + " приехал в " + l.getName());
		} catch(InitException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void MoveTo(ALocation l, String r) {
		try {
			if (l == null) throw new InitException("Локация");
			currentL = l.getName();
			reason = r;
			System.out.println(Name + " приехал в " + l.getName() + ", чтобы " + r);
		} catch(InitException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Advice(Shorty s) {
		System.out.println(Name + " сказал: "+s.getName()+", будь спокоен.");
	}

	@Override
	public int hashCode() {
		return Name.hashCode() + currentP.hashCode() + currentL.hashCode() + status.hashCode() + mood.hashCode() + reason.hashCode();
	}

	@Override
	public String toString() {
		return currentP + " " + Name + " " + status + ", настроение: " + mood;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shorty other = (Shorty) obj;
		if (Name != other.Name)
			return false;
		if (currentP != other.currentP)
			return false;
		if (currentL != other.currentL)
			return false;
		if (status != other.status)
			return false;
		if (mood != other.mood)
			return false;
		if (reason != other.reason)
			return false;
		return true;
	}
}