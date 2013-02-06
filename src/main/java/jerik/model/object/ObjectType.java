package jerik.model.object;

public enum ObjectType {

	UNDEFINED(true),
	LIGHT,
	SCROLL,
	WAND,
	STAFF,
	WEAPON,
	FURNITURE,
	FREE(true),
	TREASURE,
	ARMOR,
	POTION,
	WORN,
	OTHER,
	TRASH,
	FREE2(true),
	CONTAINER,
	NOTE,
	LIQ_CONTAINER,
	KEY,
	FOOD,
	MONEY,
	PEN,
	BOAT,
	FOUNTAIN
	;
	
	private final boolean doNotUse;
	
	private ObjectType() {
		this(false);
	}
	
	private ObjectType(boolean doNotUse) {
		this.doNotUse = doNotUse;
	}
}
