package game;

import java.util.ArrayList;

public class WallAbilities implements Abilities{
	private ArrayList<Wall> walls;
	private Area area;
//	public void setWalls(ArrayList<Wall> walls) {
//		this.walls = walls;
//	}

	public WallAbilities(ArrayList<Wall> walls, Area area) {
		this.walls = walls;
		this.area = area;
	}

	@Override
	public void build(int x, int y) {
		Wall rmWall = new Wall(x, y);
		if(!walls.contains(rmWall)&& area.isFree(x, y)) {
			walls.add(rmWall);
			area.putItem(x, y);	
		}
	}

	@Override
	public void destroy(int x, int y, int coalition) {
		Wall rmWall = new Wall(x, y);
		walls.remove(rmWall);
		area.remove(x, y);
	}

}
