package game;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Unit /* extends WallAbilities */{
	private int x;
	private int y;
	private int tx;
	private int ty;
	private int life = 100;
	private int coalition = 0;
	private Weapon weapon;

	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	public void dropWeapon() {
		this.weapon.setX(x+1);
		this.weapon.setY(y);
		this.weapon = null;
	}

	ArrayList<Integer> frames = new ArrayList<>();
	//boolean selected = false;
	private int offset;
	private ArrayList<Point> path;
	private Area area;
	private Abilities abilities = new BlankAbilities();
	//private int trend = 0;//0-7
	private ArrayList<Integer> trend = new ArrayList<>();
	private UnitScanner scanner;
	private Maneuver maneuver = new Maneuver();
	
	public int getLife() {
		return life;
	}
	public int getCoalition() {
		return coalition;
	}
	public void setCoalition(int coalition) {
		this.coalition = coalition;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public void setScanner(UnitScanner scanner) {
		this.scanner = scanner;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj==this)
			return true;
		Unit object = (Unit)obj;
		if(object.getX()==getX() && object.getY()==getY()) {
			return true;
		}
		return false;
	}
	public int getTrend() {
		return trend.get(0);
	}
	public void setAbilities(Abilities abilities) {
		this.abilities = abilities;
	}
	public void build() {
		abilities.build(x+1, y);
	}
	public void destroy() {
		abilities.destroy(x+1, y, coalition);
	}
	public int getDir() {
		return offset;
	}
	public int getTx() {
		return tx;
	}
	public void setTx(int tx) {
		//if(tx>=0 && tx<getArea().getCol() && ty>=0 && ty<getArea().getRow()) {
		this.tx = tx;
	}
	public int getTy() {
		return ty;
	}
	public void setTy(int ty) {
		this.ty = ty;
	}
	public Unit(int x, int y, int coalition) {
		this.x = x;
		this.y = y;
		tx = x;
		ty = y;
		for(int _i=0; _i<8; _i++) {
			trend.add(_i);
		}
		frames.add(0);
		frames.add(1);
		frames.add(2);
		frames.add(3);
		this.coalition = coalition;
	}
	public void setArea(Area area) {
		this.area = area;
		area.putItem(x, y);
	}
	public Area getArea() {
		return area;
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public abstract void move();
	
	public void setPath(ArrayList<Point> findPath) {
		path = findPath;
	}
	public void tick() {
		if (weapon != null) {
			this.weapon.setX(x);
			this.weapon.setY(y);
		}
		Unit enemy = scanner.getEnemy(getX(),getY(),coalition);
		if(enemy!=null) {
			tx = x;
			ty = y;
			int newTrend = maneuver.getTrend((enemy.getX()-getX())+10*(enemy.getY()-getY()));//-10,-9,1,11,10,9,-1,11
			if(trend.get(0)==newTrend) {
				//???????? ??????????????
			}else {
				int offSet = 0;
				for(int _i=0; _i<trend.size(); _i++) {
					if(trend.get(_i)==newTrend) {
						offSet = _i; 
						break;
					}
				}
				Collections.rotate(trend, maneuver.getOffSet(offSet));
			}
			enemy.setLife(enemy.getLife()-5);
			if (weapon != null) enemy.setLife(enemy.getLife()-weapon.getDmg());
		}
		move();
		if(path!=null && path.size()>0){
			Point p = path.get(0);

			Maneuver maneuver = new Maneuver();
			int newTrend = maneuver.getTrend((p.getX()-getX())+10*(p.getY()-getY()));//-10,-9,1,11,10,9,-1,11
			if(trend.get(0)==newTrend) {
//				abilities.destroy(x+1, y, coalition);
				area.remove(getX(),getY());
				x = p.getX();
				y = p.getY();
				area.putItem(getX(),getY());
			}else {
				int offSet = 0;
				for (int _i = 0; _i < trend.size(); _i++) {
					if(trend.get(_i)==newTrend) {
						offSet = _i;
						break;
					}
				}
				Collections.rotate(trend, maneuver.getOffSet(offSet));
			}
			//Collections.rotate(trend, 1);
			
//            if(y[_i]>ty && x[_i]>tx) {
//            	rotate[_i] = 7;//3
//            }else if(y[_i]<ty && x[_i]<tx) {
//            	rotate[_i] = 3;//7
//            }else if(y[_i]<ty && x[_i]==tx){
//            	rotate[_i] = 4;//
//            }else if(y[_i]>ty && x[_i]==tx){
//            	rotate[_i] = 0;//
//            }else if(y[_i]==ty && x[_i]<tx){
//            	rotate[_i] = 2;
//            }else if(y[_i]==ty && x[_i]>tx){
//            	rotate[_i] = 6;
//            }else if(y[_i]<ty && x[_i]>tx){
//            	rotate[_i] = 5;
//            }else if(y[_i]>ty && x[_i]<tx){
//            	rotate[_i] = 1;
//            }
		}
	}

	public int getFrame() {

		return frames.get(0);
	}
}