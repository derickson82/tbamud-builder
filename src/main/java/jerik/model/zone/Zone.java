package jerik.model.zone;

import jerik.model.room.Room;

public class Zone {
	
	private int virtualNumber;
	
	private String builderName;
	
	private String name;
	
	private Room bottomRoom;
	
	private Room topRoom;
	
	private int lifespan; // real-time minutes between resets
	
	private ResetMode resetMode;
	
	// TODO commands? to initialize the zone?
}
