package jerik.model.object;

public class Affect {
	
	public static enum Location {
		NONE,
		STR,
		DEX,
		INT,
		WIS,
		CON,
		CHA,
		CLASS,
		LEVEL,
		AGE,
		CHAR_WEIGHT,
		CHAR_HEIGHT,
		MAXMANA,
		MAXHIT,
		MAXMOVE,
		GOLD(true),
		EXP(true),
		ARMOR,
		HITROLL,
		DAMROLL,
		SAVING_PARA,
		SAVING_ROD,
		SAVING_PETRI,
		SAVING_BREATH,
		SAVING_SPELL
		;
		
		private final boolean doNotUse;
		
		private Location() {
			this(false);
		}
		
		private Location(boolean doNotUse) {
			this.doNotUse = doNotUse;
		}
	}
	
	private Location location;
	
	private int value;
	
	public Affect() {
	}
	
	

}
