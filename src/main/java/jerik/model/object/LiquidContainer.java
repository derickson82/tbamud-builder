package jerik.model.object;

public abstract class LiquidContainer extends ObjectAdapter {

	public LiquidContainer(ObjectType type) {
		super(type);
	}

	public int getCapacity() {
		// value0
		return 0;
	}
	
	public int getCurrentQuantity() {
		// value1
		return 0;
	}
	
	public LiquidType getLiquidType() {
		// value2
		return null;
	}
	
	public boolean isPoisoned() {
		// value3
		return false;
	}
	
}
