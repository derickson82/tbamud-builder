package jerik.model.object;

public class ObjectAdapter extends Object {
	
	static final String DEFAULT_VALUE = "0";

	public ObjectAdapter(ObjectType type) {
		super(type);
	}

	@Override
	protected String getValue0() {
		return DEFAULT_VALUE;
	}

	@Override
	protected String getValue1() {
		return DEFAULT_VALUE;
	}

	@Override
	protected String getValue2() {
		return DEFAULT_VALUE;
	}

	@Override
	protected String getValue3() {
		return DEFAULT_VALUE;
	}

}
