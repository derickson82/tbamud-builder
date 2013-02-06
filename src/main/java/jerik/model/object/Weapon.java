package jerik.model.object;

public class Weapon extends ObjectAdapter {

	public Weapon() {
		super(ObjectType.WEAPON);
	}

	public int getDiceCount() {
		// value1
		return 0;
	}
	
	public int getDiceSize() {
		// value2
		return 0;
	}
	
	public DamageType getDamageType() {
		// value3
		return null;
	}
}
