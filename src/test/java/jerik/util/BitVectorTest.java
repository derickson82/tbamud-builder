package jerik.util;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

import jerik.model.mob.MobFlag;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class BitVectorTest {

	@DataProvider(name="bitVectors")
	public Iterator<Object[]> bitVectors() {
		List<Object[]> values = new ArrayList<Object[]>();
		
		values.add(wrap(MobFlag.class, 1L, EnumSet.of(MobFlag.SPEC)));
		values.add(wrap(MobFlag.class, 2L, EnumSet.of(MobFlag.SENTINEL)));
		values.add(wrap(MobFlag.class, 3L, EnumSet.of(MobFlag.SPEC, MobFlag.SENTINEL)));
		
		values.add(wrap(MobFlag.class, 10, EnumSet.of(MobFlag.ISNPC, MobFlag.SENTINEL)));
		
		
		return values.iterator();
	}
	
	private Object[] wrap(Object... args) {
		return args;
	}
	
	@Test(dataProvider="bitVectors")
	public <E extends Enum<E>> void testToEnum(Class<E> enumClass, long bitvector, EnumSet<E> expected) {
		EnumSet<E> values = BitVector.toEnum(enumClass, bitvector);
		Assert.assertEquals(values, expected);
	}
	
	@Test(dataProvider="bitVectors")
	public <E extends Enum<E>> void testFromEnumSet(Class<E> enumClass, long expected, EnumSet<E> values) {
		long actual = BitVector.fromEnumSet(values);
		Assert.assertEquals(actual, expected);
	}
}
