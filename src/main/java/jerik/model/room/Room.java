package jerik.model.room;

import java.util.EnumSet;
import java.util.Map;

public class Room {
	
	public static final Room NO_WHERE = new Room(-1);
	
	// virtual numbers must appear in increasing order in the world file 
	private int virtualNumber;
	private String name;
	private String description;
	
	private EnumSet<RoomFlag> types = EnumSet.noneOf(RoomFlag.class);
	
	private SectorType sectorType;

	private Map<Direction, Exit> exits;
	
	/*
	 * keyword -> description. Multiple keywords could point to the same description
	 */
	private Map<String, String> extraDescriptions;
	
	// zone number - add some validation to see if the naming convention is followed (or not as this is deprecated. just don't choke on it)
	// room bitvector
	// sector type
	
	public Room() {
		
	}
	
	public Room(int virtualNumber) {
		this.virtualNumber = virtualNumber;
	}
	
}
