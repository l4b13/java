public class Shorty implements IDefault, IShorty {
	private String Name;
	private Position currentP;
	private String currentL;
	private String status;

	public Shorty(String Name, Position p, City c) {
		this.Name = Name;
		currentP = p;
		currentL = c.getName();
		status = "стоит";
	}

	public string getName() {
		return Name;
	} 

	@Override
	public void LayDown(Furniture f) {
		status = "лежит на " + f.getType();
		System.out.println(Name + " лег на " + f.getType());
	}

	@Override
	public void GetUp()  {
		status = "стоит";
		System.out.println(Name + " встал");
	}

	@Override
	public void Give(AThing t, Shorty s) {
		t.setOwner(s);
		System.out.println(Name + " передал(а) " + s.toString() + t.getType());
	}

	@Override
	public void MoveTo(ALocation l) {
		currentL = l.getName();
		System.out.println(Name + " приехал в " + l.getName());
	}

	@Override
	public int hashCode() {
		return Name.hashCode() + currentP.hashCode() + currentL.hashCode();
	}

	@Override
	public String toString() {
		return currentP + " " + Name + " " + status;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj.hashCode() == this.hashCode())&&()&&() {
			return true;
		} else {
			return false;
		}
	}
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
		return true;
	}
}