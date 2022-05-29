import ru.ifmo.se.pokemon.*;

public class Screech extends StatusMove {
	protected Screech() {
		super(Type.NORMAL, 0, 85);
	}
	@Override
	protected void applyOppEffects(Pokemon p) {
		p.setMod(Stat.DEFENSE, -2);
	}
}