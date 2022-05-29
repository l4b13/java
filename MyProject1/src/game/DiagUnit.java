package game;

public class DiagUnit extends Unit{

	public DiagUnit(int x, int y, int coalition) {
		super(x, y, coalition);
	}

	@Override
	public void move() {
		WaveAlg alg = new WaveAlg();
		setPath(alg.findDiagPath(getArea().getMap(), getX(),
				getY(), getTx(), getTy()));
	}

}
