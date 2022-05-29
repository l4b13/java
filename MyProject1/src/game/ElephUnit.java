package game;

public class ElephUnit extends Unit{

	public ElephUnit(int x, int y, int coalition) {
		super(x, y, coalition);
	}

	@Override
	public void move() {
		WaveAlg alg = new WaveAlg();
		setPath(alg.findElephPath(getArea().getMap(), getX(),
					getY(), getTx(), getTy()));
	}
	
}