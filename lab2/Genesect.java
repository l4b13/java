import ru.ifmo.se.pokemon.*;

public class Genesect extends Pokemon {
	public Genesect(String name, int level) {
		super(name, level);
		setStats(71, 120, 95, 120, 95, 99);
		setType(Type.BUG, Type.STEEL);
		RockPolish _rockpolish = new RockPolish();
		Thunderbolt _thunderbolt = new Thunderbolt();
		Screech _screech = new Screech();
		MetalClaw _metalclaw = new MetalClaw();
		setMove(_rockpolish, _thunderbolt, _screech, _metalclaw);
	}
}