import ru.ifmo.se.pokemon.*;

public class Thunderbolt extends SpecialMove {
	protected Thunderbolt() {
		super(Type.ELECTRIC, 95, 100);
	}
	@Override
	protected void applyOppEffects(Pokemon p) {
		if (Math.random() <= 0.1 && !p.hasType(Type.ELECTRIC)) Effect.paralyze(p);
	}
}