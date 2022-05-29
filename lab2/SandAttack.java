import ru.ifmo.se.pokemon.*;

public class SandAttack extends StatusMove {
	protected SandAttack() {
		super(Type.GROUND, 0, 100);
	}
	@Override
	protected void applyOppEffects(Pokemon p) {
		p.setMod(Stat.ACCURACY, -1);
	}
}