import ru.ifmo.se.pokemon.*;

public class Lombre extends Lotad {
	public Lombre(String name, int level) {
		super(name, level);
		setStats(60, 50, 50, 60, 70, 50);
		setType(Type.WATER, Type.GRASS);
		Astonish _astonish = new Astonish();
		Confide _confide = new Confide();
		Bubble _bubble = new Bubble();
		setMove(_astonish, _confide, _bubble);
	}
}