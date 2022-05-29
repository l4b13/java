package game;

import java.util.HashMap;

public class Maneuver {
	private HashMap<Integer, Integer> trendMap = new HashMap<Integer, Integer>();
	private HashMap<Integer, Integer> turnMap = new HashMap<Integer, Integer>();
	public Maneuver() {
		trendMap.put(-10, 0);
		trendMap.put(-9, 1);
		trendMap.put(1, 2);
		trendMap.put(11, 3);
		trendMap.put(10, 4);
		trendMap.put(9, 5);
		trendMap.put(-1, 6);
		trendMap.put(-11, 7);
		turnMap.put(1, -1);//направо полоборота
		turnMap.put(2, -2);
		turnMap.put(3, -2);
		turnMap.put(4, 2);
		turnMap.put(5, 2);
		turnMap.put(6, 2);
		turnMap.put(7, 1);
	}
	public int getTrend(int d) {
		return trendMap.get(d);
	}
	public int getOffSet(int d) {
		return turnMap.get(d);
	}
}
