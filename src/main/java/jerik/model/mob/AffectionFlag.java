package jerik.model.mob;

public enum AffectionFlag {
	BLIND,
	INVIS,
	DET_ALIGN,
	DET_INVIS,
	DET_MAGIC,
	SENSE_LIFE,
	WATWALK,
	SANCT,
	GROUP,
	CURSE,
	INFRA,
	POISON,
	PROT_EVIL,
	PROT_GOOD,
	SLEEP,
	NO_TRACK,
	UNUSED_1,
	UNUSED_2,
	SNEAK,
	HIDE,
	UNUSED_3,
	CHARM
	;
	private final boolean doNotUse;
	
	private AffectionFlag() {
		this(false);
	}
	
	private AffectionFlag(boolean doNotUse) {
		this.doNotUse = doNotUse;
	}
}
