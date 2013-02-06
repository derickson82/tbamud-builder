package jerik.model.object;

public abstract class ChargedMagicalItem extends ObjectAdapter {
	
	protected ChargedMagicalItem(ObjectType type) {
		super(type);
	}

	public int getSpellLevel() {
		// TODO value0
		return 0;
	}
	
	public int getChargeCapacity() {
		return 0;
	}
	
	public int getRemainingCharges() {
		return 0;
	}
	
	public int getSpell() {
		return 0;
	}
}
