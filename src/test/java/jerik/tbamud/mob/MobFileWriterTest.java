/**
 * 
 */
package jerik.tbamud.mob;

import java.util.Arrays;

import jerik.model.mob.AffectionFlag;
import jerik.model.mob.Mob;
import jerik.model.mob.MobFlag;
import jerik.model.mob.MobType;
import jerik.model.mob.PositionType;
import jerik.model.mob.Sex;
import jerik.util.Dice;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author derickson82
 *
 */
public class MobFileWriterTest {

	private static final String NL = System.getProperty("line.separator");
	
	@Test
	public void test() {
		
		Mob mob = new Mob();
		mob.setVirtualNumber(9000);
		mob.setKeyWords("feral", "cat");
		mob.setShortDescription("A feral cat staring at you");
		mob.setLongDescription("This feral cat gives you the creeps. It won't stop staring at you.");
		mob.setDetailedDescription("Why won't this cat just stop looking at you? A longer description might be necessary, and breaking this up into 80 character lines would be nice too.");
		mob.setMobFlags(MobFlag.ISNPC, MobFlag.SENTINEL, MobFlag.SCAVENGER);
		mob.setAffectionFlags(AffectionFlag.BLIND, AffectionFlag.CHARM, AffectionFlag.NO_TRACK, AffectionFlag.POISON);
		mob.setAlignment(-20);
		
		mob.setMobType(MobType.ENHANCED);
		mob.setLevel(14);
		mob.setThaco(4);
		mob.setArmorClass(-1);
		mob.setMaxHitPoints(Dice.create(3, 5, 10));
		mob.setDamage(Dice.create(1, 6, 9));
		mob.setInitialGold(234);
		mob.setExperience(22334);
		
		mob.setLoadPosition(PositionType.SITTING);
		mob.setDefaultPosition(PositionType.RESTING);
		mob.setSex(Sex.NEUTRAL);
		
		mob.addEnhancedSpec("BareHandAttack", "4");
		mob.addEnhancedSpec("Str", "20");
		
		StringBuilder sink = new StringBuilder();
		MobFileWriter.write(Arrays.asList(mob), sink);
		
		String value = sink.toString();
		System.out.println(value);
		Assert.assertTrue(value.contains("#9000" + NL));
		Assert.assertTrue(value.contains("feral cat~" + NL));
		Assert.assertTrue(value.contains(" feral cat staring at you~" + NL));
		Assert.assertTrue(value.contains("It won't stop staring at you." + NL + "~" + NL));
		Assert.assertTrue(value.contains("character lines would be nice too." + NL + "~" + NL));
	}
}
