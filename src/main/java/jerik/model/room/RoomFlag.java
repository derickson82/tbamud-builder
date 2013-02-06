package jerik.model.room;

public enum RoomFlag {
	DARK,
	DEATH,
	NO_MOB,
	INDOORS,
	PEACEFUL,
	SOUNDPROOF,
	NO_TRACK,
	NO_MAGIC,
	TUNNEL,
	PRIVATE,
	GODROOM,
	HOUSE(true),
	HCRSH(true),
	ATRIUM(true),
	OLC(true),
	BFS(true);
	
	/**
	 * Indicates that the zone builder should/should not be able to add this flag.
	 */
	private final boolean doNotUse;
	
	private RoomFlag() {
		this(false);
	}
	
	private RoomFlag(boolean doNotUse) {
		this.doNotUse = doNotUse;
	}
}
