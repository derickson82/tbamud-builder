package jerik.model.room;

import java.util.List;

public class Exit {
	
	public static final int NO_KEY_FOR_DOOR = -1;
	
	private Room parentRoom;
	
	private String description;
	private List<String> keywordList;
	private DoorType doorType;
	
	private int keyVirtualNumber = NO_KEY_FOR_DOOR; // vnum of the key. -1 i
	
	private Room linkedRoom = Room.NO_WHERE;
	
	
}
