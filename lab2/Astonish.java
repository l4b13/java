import ru.ifmo.se.pokemon.*;

public class Astonish extends PhysicalMove {
	protected Astonish() {
		super(Type.GHOST, 30, 100);
	}
	@Override
	protected void applyOppEffects(Pokemon p) {
		if (Math.random() <= 0.3) Effect.flinch(p);
	}
}