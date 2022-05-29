import ru.ifmo.se.pokemon.*;

public class Ludicolo extends Lombre {
	public Ludicolo(String name, int level) {
		super(name, level);
		setStats(80, 70, 70, 90, 100, 70);
		setType(Type.WATER, Type.GRASS);
		Astonish _astonish = new Astonish();
		Confide _confide = new Confide();
		Bubble _bubble = new Bubble();
		Facade _facade = new Facade();
		setMove(_astonish, _confide, _bubble, _facade);
	}
}