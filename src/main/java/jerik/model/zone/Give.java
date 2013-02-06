package jerik.model.zone;

public class Give extends Command {

	private Object object;
	
	private int maxExisting;
	
	// TODO given to last loaded mob. Consider making a mob template command that is an aggregate of several commands
	public Give() {
	}

}
