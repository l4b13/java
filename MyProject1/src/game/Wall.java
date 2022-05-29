package game;

public class Wall {
	private int x;
	private int y;
	private Area area;
	public Wall(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj==this)
			return true;
		Wall object = (Wall)obj;
		if(object.getX()==getX() && object.getY()==getY()) {
			return true;
		}
		return false;
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
	public void setArea(Area area) {
		this.area = area;
		area.putItem(x, y);
	}
}
