import ru.ifmo.se.pokemon.*;

public class Hariyama extends Makuhita {
	public Hariyama(String name, int level) {
		super(name, level);
		setStats(144, 120, 60, 40, 60 ,50);
		setType(Type.FIGHTING);
		Rest _rest = new Rest();
		SandAttack _sandattack = new SandAttack();
		LowSweep _lowsweep = new LowSweep();
		StoneEdge _stoneedge = new StoneEdge();
		setMove(_rest, _sandattack, _lowsweep, _stoneedge);
	}
}