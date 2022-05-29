import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {
	protected Facade() {
		super(Type.NORMAL, 70, 100);
	}
	@Override
	protected void applyOppDamage (Pokemon p, double dmg) {
		Status pCondition = p.getCondition();
		if (pCondition.equals(Status.BURN) || pCondition.equals(Status.POISON) || pCondition.equals(Status.PARALYZE)) {
			p.setMod(Stat.HP, (int) Math.round(dmg) * 2);
			System.out.println("Critical hit!"); 
		}
	}
}