import ru.ifmo.se.pokemon.*;

public class StoneEdge extends PhysicalMove {
	protected StoneEdge() {
		super(Type.ROCK, 100, 80);
	}
	@Override        
	protected double calcCriticalHit(Pokemon att, Pokemon def) {        
		if (Math.random() < att.getStat(Stat.SPEED) / 512 * 8) {                
			System.out.println("Critical hit!");                
			return 2.0;            
		} else {                
			return 1.0;            
		}        
	}
}