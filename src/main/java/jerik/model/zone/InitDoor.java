package jerik.model.zone;

import jerik.model.room.Direction;
import jerik.model.room.DoorState;
import jerik.model.room.Room;

public class InitDoor extends Command {

	private Room room;
	
	private Direction exit;
	
	private DoorState doorState;
	
	public InitDoor() {
	}

}
