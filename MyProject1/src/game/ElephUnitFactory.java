package game;

public class ElephUnitFactory implements UnitFactory {

	@Override
	public Unit createUnit(int x, int y, int coalition) {
		return new ElephUnit(x, y, coalition);
	}
	
}
