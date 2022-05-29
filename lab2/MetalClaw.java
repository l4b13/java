import ru.ifmo.se.pokemon.*;

public class MetalClaw extends PhysicalMove {
	protected MetalClaw() {
		super(Type.STEEL, 50, 95);
	}
	@Override
	protected void applySelfEffects(Pokemon p) {
		if (Math.random() <= 0.1) {
			p.setMod(Stat.ATTACK, +1); 
		}
	}
}