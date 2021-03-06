package game;

import java.util.ArrayList;

public class Area {
	private int[][] map;

	private final int FREE = -1;
	private final int ITEM = -5;
	public Area(int col, int row) {
		map = new int[row][col];
		for(int _n=0; _n<map.length; _n++) {
			for(int _i=0; _i<map[_n].length; _i++) {
				map[_n][_i]=-1;
			}
		}
	}

	public void print() {
		for(int _n=0; _n<map.length; _n++) {
			for(int _i=0; _i<map[_n].length; _i++) {
				System.out.print(map[_n][_i]+" ");
			}
			System.out.println();
		}
	}
	public int[][] getMap() {
		int[][] cloneMap = new int[map.length][map[0].length];
		for(int _n=0; _n<map.length; _n++) {
			for(int _i=0; _i<map[0].length; _i++) {
				cloneMap[_n][_i] = map[_n][_i];
			}
		}
		return cloneMap;
	}
	public boolean isFree(int x, int y) {
		if(map[y][x]==FREE) {
			return true;
		}else {
			return false;
		}
	}
	public boolean putItem(int x, int y) {
		map[y][x] = ITEM;	
		return true;
	}
	public void remove(int x, int y) {
		map[y][x] = FREE;
	}
}
