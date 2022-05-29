package game;

import java.util.ArrayList;
import java.util.Collections;

public class WaveAlg {

	public static void main(String[] args) {
		int[][] map = new int[][] {
			{-1,-1,-1,-1,-1,-1},
			{-1,-5,-1,-1,-5,-1},
			{-1,-5,-1,-1,-1,-1},
			{-1,-5,-1,-1,-1,-1},
			{-1,-1,-1,-5,-1,-1},
			{-1,-1,-1,-5,-1,-1},
		};
		WaveAlg alg = new WaveAlg();
		ArrayList<Point> path = alg.findStraightPath(map,0,2,4,4);
		alg.print(map);
	}
	public ArrayList<Point> findDiagPath(int[][] map, int x, int y, int tx, int ty) {
		int[] dx = { 0, 1, 0, -1, -1, -1, 1, 1 };
		int[] dy = { -1, 0, 1, 0, -1, 1, -1, 1 };
		return findPath(map, x, y, tx, ty, dx, dy);
	}
	public ArrayList<Point> findStraightPath(int[][] map, int x, int y, int tx, int ty) {
		int[] dx = {0,1,0,-1};
		int[] dy = {-1,0,1,0};
		return findPath(map, x, y, tx, ty, dx, dy);
	}
	public ArrayList<Point> findElephPath(int[][] map, int x, int y, int tx, int ty) {
		int[] dx = { -1, -1, 1, 1 };
		int[] dy = { -1, 1, -1, 1 };
		return findPath(map, x, y, tx, ty, dx, dy);
	}


	public ArrayList<Point> findPath(int[][] map, int x, int y, int tx, int ty, int[] dx, int[] dy) {
		ArrayList<Point> wave = new ArrayList<Point>();
		ArrayList<Point> oldWave = new ArrayList<>();
		oldWave.add(new Point(x,y));
		int nstep = 0;
		map[y][x] = 0;
		outer:
		while(oldWave.size()>0) {
			nstep++;
			wave.clear();
			for (Point p : oldWave) {
				for (int _i = 0; _i < dy.length; _i++) {
					x = p.getX()+dx[_i];
					y = p.getY()+dy[_i];
					if(x>=0 && x<map[0].length && y>=0 && y<map.length) {
						if(map[y][x]==-1) {
							map[y][x]=nstep;
							wave.add(new Point(x, y));
						}
						if(x==tx && y==ty)
							break outer;
					}
				}
			}
			oldWave = new ArrayList<Point>(wave);
		}
		////восстановление пути
		boolean flag = false;
		wave.clear();
		wave.add(new Point(tx, ty));
		while(map[ty][tx]!=0) {
			flag = false;
			for (int _i = 0; _i < dy.length; _i++) {
				x = tx+dx[_i];
				y = ty+dy[_i];
				if(x>=0 && x<map[0].length && y>=0 && y<map.length) {
					if(map[ty][tx]-1==map[y][x]) {
						tx = x;
						ty = y;
						flag = true;
						wave.add(new Point(tx,ty));
						break;
					}
				}
			}
			if(flag==false) {
				System.out.println("Путь не найден");
				break;
			}
		}
		Collections.reverse(wave);
		wave.remove(0);
//		for (Point p : wave) {
//			System.out.println("x="+p.getX()+", y="+p.getY());
//		}
//		draw(map,wave);
		return wave;
	}
	private void draw(int[][] map, ArrayList<Point> wave) {
		for(int _n=0; _n<map.length; _n++) {
			for(int _i=0; _i<map[0].length; _i++) {
				for (Point p : wave) {
					if(p.getX()==_i && p.getY()==_n)
						map[_n][_i]=0;
				}
			}
			System.out.println();
		}
	}

	private void print(int[][] map) {
		for (int _i = 0; _i < map.length; _i++) {
			for (int _j = 0; _j < map[_i].length; _j++) {
				System.out.print(map[_i][_j]+" ");
			}
			System.out.println();
		}
	}
}

