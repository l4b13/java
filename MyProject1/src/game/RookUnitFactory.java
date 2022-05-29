package game;

public class RookUnitFactory implements UnitFactory {

	@Override
	public Unit createUnit(int x, int y, int coalition) {
		return new RookUnit(x, y, coalition);
	}

}
