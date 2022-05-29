package game;

public class DiagUnitFactory implements UnitFactory {

	@Override
	public Unit createUnit(int x, int y, int coalition) {
		return new DiagUnit(x, y, coalition);
	}
	
}
