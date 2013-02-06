package jerik.tbamud.mob;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jerik.model.mob.Mob;
import jerik.model.mob.MobFlag;
import jerik.model.mob.MobType;
import jerik.model.mob.PositionType;
import jerik.model.mob.Sex;
import jerik.util.Dice;

import org.junit.Assert;
import org.testng.annotations.Test;

public class MobFileLoaderTest {

	@Test
	public void testLoadingMobFile() {
		List<Mob> mobs = MobFileLoader.load("src/test/resources/90.mob");
		
		Assert.assertEquals(8, mobs.size());
		
		Mob fox = mobs.get(0);
		Assert.assertEquals("the desert fox", fox.getShortDescription());
		Assert.assertTrue(fox.getKeyWords().contains("fox"));
		Assert.assertTrue(fox.getKeyWords().contains("desert"));
		Assert.assertTrue(fox.getLongDescription().contains("watches you carefully"));
		Assert.assertTrue(fox.getDetailedDescription().contains("tan coat blends with the"));
		Assert.assertEquals(EnumSet.of(MobFlag.ISNPC, MobFlag.STAY_ZONE, MobFlag.SCAVENGER), fox.getMobFlags());
		Assert.assertEquals(0, fox.getAlignment());
		Assert.assertEquals(MobType.ENHANCED, fox.getMobType());
		Assert.assertEquals(7, fox.getLevel());
		Assert.assertEquals(18, fox.getThaco());
		Assert.assertEquals(5, fox.getArmorClass());
		Assert.assertEquals(Dice.create(1, 1, 70), fox.getMaxHitPoints());
		Assert.assertEquals(Dice.create(1, 2, 1), fox.getDamage());
		Assert.assertEquals(70, fox.getInitialGold());
		Assert.assertEquals(4900, fox.getExperience());
		Assert.assertEquals(PositionType.STANDING, fox.getLoadPosition());
		Assert.assertEquals(PositionType.STANDING, fox.getDefaultPosition());
		Assert.assertEquals(Sex.MALE, fox.getSex());
		
		Map<String, String> expectedEnhanced = new HashMap<String, String>();
		expectedEnhanced.put("BareHandAttack", "4");
		expectedEnhanced.put("SubRace 1", "0");
		expectedEnhanced.put("SubRace 2", "0");
		expectedEnhanced.put("SubRace 3", "0");
		expectedEnhanced.put("Race", "3");
		expectedEnhanced.put("Class", "3");
		expectedEnhanced.put("Size", "5");
		
		Assert.assertEquals(expectedEnhanced, fox.getEnhancedSpecs());
	}
}
