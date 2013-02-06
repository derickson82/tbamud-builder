package jerik.model.zone;

public class Equip extends Command {

	public static enum Position {
		LIGHT,
		RIGHT_FINGER,
		LEFT_FINGER,
		NECK1,
		NECK2,
		BODY,
		HEAD,
		LEGS,
		FEET,
		HANDS,
		ARMS,
		SHIELD,
		ABOUT,
		WAIST,
		RIGHT_WRIST,
		LEFT_WRIST,
		WIELD,
		HOLD,
		INV;
	}
	
	private Object object;
	
	private int maxExisting;
	
	private Position position;
	
	public Equip() {
	}

}
