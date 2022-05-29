import ru.ifmo.se.pokemon.*;

public class Lotad extends Pokemon {
	public Lotad(String name, int level) {
		super(name, level);
		setStats(40, 30, 30, 40, 50, 30);
		setType(Type.WATER, Type.GRASS);
		Astonish _astonish = new Astonish();
		Confide _confide = new Confide();
		setMove(_astonish, _confide);
	}
}