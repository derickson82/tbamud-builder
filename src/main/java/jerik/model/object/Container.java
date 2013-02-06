package jerik.model.object;

public class Container extends ObjectAdapter {

	public static final int NO_KEY = -1;
	
	public static enum Flag {
		CLOSABLE,
		PICKPROOF,
		CLOSED,
		LOCKED;
	}
	
	public Container() {
		super(ObjectType.CONTAINER);
	}
	
	public int getCapacity() {
		// value0
		return 0;
	}
	
	public Flag getFlag() {
		// value1
		return null;
	}
	
	public int getKeyVnum() {
		// value2
		return NO_KEY;
	}

}
