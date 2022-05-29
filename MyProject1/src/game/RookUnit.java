package game;

public class RookUnit extends Unit{

	public RookUnit(int x, int y, int coalition) {
		super(x, y, coalition);
	}

	@Override
	public void move() {
		WaveAlg alg = new WaveAlg();
		setPath(alg.findStraightPath(getArea().getMap(), getX(),
				getY(), getTx(), getTy()));
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

}