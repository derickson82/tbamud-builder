package jerik.model.mob;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jerik.util.Dice;

public class Mob {
	
	private int virtualNumber;
	private List<String> keyWords;
	
	private String shortDescription;
	private String longDescription;
	
	private String detailedDescription;
	private EnumSet<MobFlag> mobFlags;
	private EnumSet<AffectionFlag> affectionFlags;
	
	private int alignment;
	private MobType mobType = MobType.SIMPLE;
	private int level; // between 1 and 34
	private int thaco; // between 0 and 20. To Hit Armor Class
	private int armorClass; // between -10 and 10
	private Dice maxHitPoints; // example 4d10+15
	private Dice damage;
	private int initialGold; // 
	private int experience;
	private PositionType loadPosition;
	private PositionType defaultPosition;
	private Sex sex;
	
	private Map<String, String> enhancedSpecs;

	public int getVirtualNumber() {
		return virtualNumber;
	}
	
	public void setVirtualNumber(int vnum) {
		this.virtualNumber = vnum;
	}
	
	public List<String> getKeyWords() {
		if (keyWords == null) {
			keyWords = new ArrayList<String>();
		}
		return keyWords;
	}
	
	public void setKeyWords(String... keyWords) {
		this.keyWords = Arrays.asList(keyWords);
	}
	
	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getDetailedDescription() {
		return detailedDescription;
	}

	public void setDetailedDescription(String detailedDescription) {
		this.detailedDescription = detailedDescription;
	}
	
	public EnumSet<MobFlag> getMobFlags() {
		if (mobFlags == null) {
			mobFlags = EnumSet.noneOf(MobFlag.class);
		}
		return EnumSet.copyOf(mobFlags);
	}
	
	public void setMobFlags(EnumSet<MobFlag> flags) {
		this.mobFlags = flags != null ? EnumSet.copyOf(flags) : null;
	}
	
	public void setMobFlags(MobFlag...flags) {
		if (mobFlags == null) {
			mobFlags = EnumSet.noneOf(MobFlag.class);
		}
		if (flags != null) {
			for (MobFlag flag : flags) {
				mobFlags.add(flag);
			}
		}
	}

	public EnumSet<AffectionFlag> getAffectionFlags() {
		if (affectionFlags == null) {
			affectionFlags = EnumSet.noneOf(AffectionFlag.class);
			
		}
		return EnumSet.copyOf(affectionFlags);
	}
	
	public void setAffectionFlags(EnumSet<AffectionFlag> affectFlags) {
		this.affectionFlags = affectFlags != null ? EnumSet.copyOf(affectFlags): null;
	}
	
	public void setAffectionFlags(AffectionFlag... flags) {
		if (affectionFlags == null) {
			affectionFlags = EnumSet.noneOf(AffectionFlag.class);
		}
		if (flags != null) {
			for (AffectionFlag flag : flags) {
				affectionFlags.add(flag);
			}
		}
	}

	public int getAlignment() {
		return alignment;
	}

	public void setAlignment(int alignment) {
		this.alignment = alignment;
	}

	public MobType getMobType() {
		return mobType;
	}

	public void setMobType(MobType mobType) {
		this.mobType = mobType;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getThaco() {
		return thaco;
	}

	public void setThaco(int thaco) {
		this.thaco = thaco;
	}

	public int getArmorClass() {
		return armorClass;
	}

	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}

	public Dice getMaxHitPoints() {
		return maxHitPoints;
	}

	public void setMaxHitPoints(Dice maxHitPoints) {
		this.maxHitPoints = maxHitPoints;
	}

	public Dice getDamage() {
		return damage;
	}

	public void setDamage(Dice damage) {
		this.damage = damage;
	}

	public int getInitialGold() {
		return initialGold;
	}

	public void setInitialGold(int initialGold) {
		this.initialGold = initialGold;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public PositionType getLoadPosition() {
		return loadPosition;
	}

	public void setLoadPosition(PositionType loadPosition) {
		this.loadPosition = loadPosition;
	}


	public PositionType getDefaultPosition() {
		return defaultPosition;
	}

	public void setDefaultPosition(PositionType defaultPosition) {
		this.defaultPosition = defaultPosition;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public void setKeyWords(List<String> keyWords) {
		this.keyWords = keyWords;
	}

	public Map<String, String> getEnhancedSpecs() {
		if (enhancedSpecs == null) {
			enhancedSpecs = new HashMap<String, String>();
		}
		return enhancedSpecs;
	}
	
	public void setEnhancedSpecs(Map<String, String> specs) {
		this.enhancedSpecs = specs != null ? new HashMap<String, String>(specs) : null;
	}

	public void addEnhancedSpec(String key, String value) {
		getEnhancedSpecs().put(key, value);
	}
	
	public String getEnhancedSpec(String key) {
		return getEnhancedSpecs().get(key);
	}
	
}
