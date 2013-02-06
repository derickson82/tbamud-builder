package jerik.model.object;

import java.util.List;
import java.util.Map;

public abstract class Object {
	private int virtualNumber;
	
	private List<String> keywords;
	
	private String shortDescription;
	
	private String longDescription;
	
	private String actionDescription;
	
	private final ObjectType type;
	
	private List<Effect> effects;
	
	private List<Wear> wearAttributes;

	protected abstract String getValue0();
	
	protected abstract String getValue1();
	
	protected abstract String getValue2();
	
	protected abstract String getValue3();
	
//	private String value0;
//
//	private String value1;
//
//	private String value2;
//
//	private String value3;

	private int weight;
	
	private int cost;
	
	private int rentPerDay;
	
	private Map<String, String> extraDescriptions;
	
	private Affect affect1;
	
	private Affect affect2;
	
	private Affect affect3;
	
	Object(ObjectType type) {
		this.type = type;
	}
	
}
