import ru.ifmo.se.pokemon.*;

public class Rest extends StatusMove {
	protected Rest() {
		super(Type.PSYCHIC, 0, 0);
	}
	@Override
	protected void applySelfEffects(Pokemon p) {
		Effect e = new Effect().turns(2);
		e.condition(Status.SLEEP);
		p.setCondition(e);
		p.restore();
	}
}