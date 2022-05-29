package game;

import java.util.ArrayList;

public class BattleAbilities implements Abilities{
	private ArrayList<Unit> units;
	private Area area;
	
	public BattleAbilities(ArrayList<Unit> units, Area area) {
		this.units = units;
		this.area = area;
	}
	@Override
	public void build(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy(int x, int y, int coalition) {
		for (Unit unit : units) {
			if(x==unit.getX() && y==unit.getY()) {
				if(unit.getCoalition()!=coalition)
					unit.setLife(unit.getLife()-5);
			}
		}
	}

}
