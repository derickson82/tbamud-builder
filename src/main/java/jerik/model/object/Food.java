package jerik.model.object;

public class Food extends ObjectAdapter {

	public Food() {
		super(ObjectType.FOOD);
	}
	
	public int getSatisfiedHours() {
		// value0
		return 0;
	}
	
	public boolean isPoisoned() {
		// value3
		return false;
	}
}
