package jerik.tbamud.mob;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jerik.model.mob.Mob;
import jerik.model.mob.MobType;
import jerik.util.BitVector;
import jerik.util.Dice;

import org.apache.commons.lang3.StringUtils;

public class MobFileWriter {
	
	public static void write(List<Mob> mobs, String path) throws IOException {
		MobFileWriter writer = new MobFileWriter();
		Path filePath = Paths.get(path);
		if (!Files.exists(filePath)) {
			Files.createFile(filePath);
		}
		try (Formatter formatter = new Formatter(path)) {
			writer.writeMobs(mobs, formatter);
		}
	}
	
	public static void write(List<Mob> mobs, Appendable appendable) {
		MobFileWriter writer = new MobFileWriter();
		
		try (Formatter formatter = new Formatter(appendable)) {
			writer.writeMobs(mobs, formatter);
		}
	}
	
	private void writeMobs(List<Mob> mobs, Formatter formatter) {
		for (Mob mob : mobs) {
			writeMob(mob, formatter);
		}
		// end of file
		formatter.format("$%n");
	}
	
	private void writeMob(Mob mob, Formatter formatter) {
		formatter.format("#%d%n", mob.getVirtualNumber());
		writeKeyWords(mob, formatter);
		formatter.format("%s~%n", mob.getShortDescription());
		formatter.format("%s%n~%n", mob.getLongDescription());
		formatter.format("%s%n~%n", mob.getDetailedDescription());
		
		formatter.format("%d %d %d %d %d %d %d %d %d ",
				BitVector.fromEnumSet(mob.getMobFlags()),
				0, 0, 0,
				BitVector.fromEnumSet(mob.getAffectionFlags()),
				0, 0, 0,
				mob.getAlignment());
		
		writeMobType(mob.getMobType(), formatter);
		
		formatter.format("%d %d %d ",
				mob.getLevel(),
				mob.getThaco(),
				mob.getArmorClass());
		
		writeDice(mob.getMaxHitPoints(), formatter);
		writeDice(mob.getDamage(), formatter);
		formatter.format("%n");
		
		formatter.format("%d %d%n", mob.getInitialGold(), mob.getExperience());

		formatter.format("%d %d %d%n",
				mob.getLoadPosition().ordinal(),
				mob.getDefaultPosition().ordinal(),
				mob.getSex().ordinal());
		
		if (mob.getMobType() == MobType.ENHANCED) {
			writeEnhancedSpecs(mob.getEnhancedSpecs(), formatter);
		}
	}
	
	private void writeEnhancedSpecs(Map<String, String> enhancedSpecs, Formatter formatter) {
		for (Entry<String, String> entry : enhancedSpecs.entrySet()) {
			formatter.format("%s: %s%n", entry.getKey(), entry.getValue());
		}
		formatter.format("E%n");
	}

	private void writeDice(Dice dice, Formatter formatter) {
		formatter.format("%dd%d+%d ", dice.getNumberOfDice(), dice.getSides(), dice.getConstant());
	}
	
	private void writeKeyWords(Mob mob, Formatter formatter) {
		String keywords = StringUtils.join(mob.getKeyWords(), ' ');
		formatter.format("%s~%n", keywords);
	}
	
	private void writeMobType(MobType type, Formatter formatter) {
		final String typeString;
		switch (type) {
		case SIMPLE:
			typeString = "S";
			break;
		case ENHANCED:
			typeString = "E";
			break;
		default:
			typeString = "S";
		}
		
		formatter.format("%s%n", typeString);
	}
	
}