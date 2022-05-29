import ru.ifmo.se.pokemon.*;

public class RockPolish extends StatusMove {
	protected RockPolish() {
		super(Type.NORMAL, 0, 0);
	}
	@Override
	protected void applySelfEffects(Pokemon p) {
		p.setMod(Stat.SPEED, +2);
	}
}
