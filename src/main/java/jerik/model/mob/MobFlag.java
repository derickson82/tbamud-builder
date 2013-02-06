package jerik.model.mob;

import java.util.EnumSet;

public enum MobFlag {
	SPEC(true),
	SENTINEL,
	SCAVENGER,
	ISNPC,
	AWARE,
	AGGR,
	STAY_ZONE,
	WIMPY,
	AGGR_EVIL,
	AGGR_GOOD,
	AGGR_NEU,
	MEMORY,
	HELPER,
	NOCHARM,
	NOSUMMON,
	NOSLEEP,
	NOBASH,
	NOBLIND;
	
	private final boolean doNotUse;
	
	private MobFlag() {
		this(false);
	}
	
	private MobFlag(boolean doNotUse) {
		this.doNotUse = doNotUse;
	}
}
