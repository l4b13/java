import ru.ifmo.se.pokemon.*;

public class Confide extends StatusMove {
	protected Confide() {
		super(Type.NORMAL, 0, 0);
	}
	@Override
	protected void applyOppEffects(Pokemon p) {
		p.setMod(Stat.SPECIAL_ATTACK, -1);
	}
}