package jerik.model.object;

public class Light extends ObjectAdapter {
	public static final int ETERNAL = -1;
	public static final int BURNED_OUT = 0;
	
	protected Light() {
		super(ObjectType.LIGHT);
	}

	public int getCapacityHours() {
		// TODO look at value2 for this
		return 0;
	}
	
}
