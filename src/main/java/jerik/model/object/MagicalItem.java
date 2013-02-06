package jerik.model.object;

public abstract class MagicalItem extends ObjectAdapter {

	protected MagicalItem(ObjectType type) {
		super(type);
	}

	public int getSpellLevel() {
		// TODO value0
		return 0;
	}
	
	public int getSpell1() {
		return 0;
	}
	
	public int getSpell2() {
		return 0;
	}
	
	public int getSpell3() {
		return 0;
	}
}
