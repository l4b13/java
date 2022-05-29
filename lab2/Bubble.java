import ru.ifmo.se.pokemon.*;

public class Bubble extends SpecialMove {
	protected Bubble() {
		super(Type.WATER, 20, 100);
	}
	@Override
	protected void applyOppEffects(Pokemon p) {
		if (Math.random() <= 0.1) p.setMod(Stat.SPEED, -1);
	}
}