package jerik.util;
import java.util.ArrayList;
import java.util.List;


public class BitVectorDef {
	private List<Bit> bitDefs = new ArrayList<Bit>();

	public void addValue(int value, char alphaValue, String name, String description) {
		bitDefs.add(new Bit(value, alphaValue, name, description));
	}
	
	
}
