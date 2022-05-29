package game;

public class Weapon {
	private int x;
	private int y;
	public String name;
	private int dmg = 2;
	public Area area;
	public Weapon(int x, int y, String name, int dmgMltplr) {
		this.x = x;
		this.y = y;
		this.name = name;
		this.dmg = dmg;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDmg() {
		return dmg;
	}
	public void setDmgMltplr(int dmg) {
		this.dmg = dmg;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	
}
