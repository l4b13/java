package game;

import java.util.ArrayList;

public class UnitScanner {
	private ArrayList<Unit> units;

	public UnitScanner(ArrayList<Unit> units) {
		this.units = units;
	}

	public Unit getEnemy(int x, int y, int coalition) {
		int[] dx = { 0, 1, 0, -1, -1, -1, 1, 1 };
		int[] dy = { -1, 0, 1, 0, -1, 1, -1, 1 };
		int cx = 0;
		int cy = 0;
		for (Unit u : units) {
			for (int _i = 0; _i < dy.length; _i++) {
				cx = x+dx[_i];
				cy = y+dy[_i];
				if(u.getX()==cx && u.getY()==cy) {
					if(u.getCoalition()!=coalition)
						return u;
				}
			}
		}
		return null;		
	}

}
