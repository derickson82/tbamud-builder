package jerik.tbamud.mob;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import jerik.model.mob.AffectionFlag;
import jerik.model.mob.Mob;
import jerik.model.mob.MobFlag;
import jerik.model.mob.MobType;
import jerik.model.mob.PositionType;
import jerik.model.mob.Sex;
import jerik.util.BitVector;
import jerik.util.Dice;

public class MobFileLoader {
	
	public static List<Mob> load(String resourceLocation) {
		MobFileLoader loader = new MobFileLoader(resourceLocation);
		loader.loadMobs();
		return loader.getLoadedMobs(); 
	}
	
	private final List<Mob> mobs = new ArrayList<Mob>();
	
	private final Path mobFilePath;
	
	private static final Pattern dicePattern = Pattern.compile("(\\d+)d(\\d+)\\+(\\d+)");
	
	private static final Pattern vnumPattern = Pattern.compile("#(\\d+)");
	
	private MobFileLoader(String filePath) {
		mobFilePath = Paths.get(filePath);
	}
	
	private void loadMobs() {
		try (Scanner scanner = new Scanner(mobFilePath, "UTF-8")) {
			Mob mob = null;
 			while ((mob = parseMob(scanner)) != null) {
				mobs.add(mob);
			}
		} catch (IOException e) {
			throw new IllegalStateException("Mob file could not be loaded: " + mobFilePath);
		}
	}
	
	private Mob parseMob(Scanner scanner) {
		Mob mob = null; 
		Integer vnum = loadVnum(scanner);
		if (vnum != null) {
			mob = new Mob();
			mob.setVirtualNumber(vnum);
			
			scanner.useDelimiter("~");
			mob.setKeyWords(scanner.next().trim().split(" "));
			mob.setShortDescription(scanner.next().trim());
			mob.setLongDescription(scanner.next());
			mob.setDetailedDescription(scanner.next());
			scanner.reset();
			scanner.next("~"); // eat the last tilda
			
			mob.setMobFlags(BitVector.toEnum(MobFlag.class, scanner.nextLong()));
			ignoreThreeLongs(scanner);

			mob.setAffectionFlags(BitVector.toEnum(AffectionFlag.class, scanner.nextLong()));
			ignoreThreeLongs(scanner);
			
			mob.setAlignment(scanner.nextInt());
			mob.setMobType(loadMobType(scanner));
			mob.setLevel(scanner.nextInt());
			mob.setThaco(scanner.nextInt());
			mob.setArmorClass(scanner.nextInt());
			mob.setMaxHitPoints(loadDice(scanner));
			mob.setDamage(loadDice(scanner));
			mob.setInitialGold(scanner.nextInt());
			mob.setExperience(scanner.nextInt());
			mob.setLoadPosition(loadEnum(PositionType.class, scanner));
			mob.setDefaultPosition(loadEnum(PositionType.class, scanner));
			mob.setSex(loadEnum(Sex.class, scanner));
			
			if (mob.getMobType() == MobType.ENHANCED) {
				mob.setEnhancedSpecs(loadEnhancedSpecs(scanner));
			}
		}
		return mob;
	}
	
	private Integer loadVnum(Scanner scanner) {
		// read lines until a vnum is found
		while (!scanner.hasNext(vnumPattern)) {
			String ignored = scanner.nextLine(); // skip the line until we find a vnum
			
			// reached the end of the file. quit
			if ("$".equals(ignored)) {
				return null;
			}
		}
		scanner.next(vnumPattern);
		return Integer.valueOf(scanner.match().group(1));
	}
	
	private Dice loadDice(Scanner scanner) {
		scanner.next(dicePattern);
		MatchResult match = scanner.match();
		
		// TODO probably need to do additional validation
		int count = Integer.valueOf(match.group(1));
		int sides = Integer.valueOf(match.group(2));
		int constant = Integer.valueOf(match.group(3));
		
		return Dice.create(count, sides, constant);
	}
	
	private MobType loadMobType(Scanner scanner) {
		MobType mobType = null;
		switch (scanner.nextLine().trim()) {
		case "E":
			mobType = MobType.ENHANCED;
			break;
		case "S":
			mobType = MobType.SIMPLE;
			break;
		}
		return mobType;
	}
	
	private void ignoreThreeLongs(Scanner scanner) {
		
		long zero = scanner.nextLong();
		zero += scanner.nextLong();
		zero += scanner.nextLong();
		
		// TODO change this to a warning or a log or something
		assert zero == 0 : "remaining mob flags should all be zero";
	}
	
	private <E extends Enum<E>> E loadEnum(Class<E> enumClass, Scanner scanner) {
		Integer ordinal = scanner.nextInt();
		EnumSet<E> values = EnumSet.allOf(enumClass);
		for (E value : values) {
			if (value.ordinal() == ordinal) {
				return value;
			}
		}
		return null;
	}
	
	private Map<String, String> loadEnhancedSpecs(Scanner scanner) {
		Map<String, String> result = new HashMap<String, String>();
		String property = null;
		while ((property = scanner.nextLine().trim()).equals("E") == false) {
			String[] split = property.split(":");
			if (split.length == 2) {
				result.put(split[0].trim(), split[1].trim());
			}
		}
		return result;
	}
	
	private List<Mob> getLoadedMobs() {
		return new ArrayList<Mob>(mobs);
	}
}