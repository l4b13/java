import ru.ifmo.se.pokemon.*;

public class Makuhita extends Pokemon {
	public Makuhita(String name, int level) {
		super(name, level);
		setStats(72, 60, 30, 20, 30, 25);
		setType(Type.FIGHTING);
		Rest _rest = new Rest();
		SandAttack _sandattack = new SandAttack();
		LowSweep _lowsweep = new LowSweep();
		setMove(_rest, _sandattack, _lowsweep);
	}
}