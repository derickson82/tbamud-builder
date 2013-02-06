package jerik.util;

import java.util.BitSet;
import java.util.EnumSet;

import jerik.model.mob.MobFlag;


/**
 * 
 */

/**
 * @author derickson82
 *
 */
public class BitVector {

	public static <E extends Enum<E>> EnumSet<E> toEnum(Class<E> enumClass, Long mobFlagBitVector) {
		if (!enumClass.isEnum()) {
			throw new IllegalArgumentException("Not an enum class: enumClass");
		}
		if (mobFlagBitVector == null) {
			throw new IllegalArgumentException("Must provide a long as a bit vector");
		}
		
		EnumSet<E> all = EnumSet.allOf(enumClass);
		
		EnumSet<E> result = EnumSet.noneOf(enumClass);
		
		for (E value : all) {
			if ((mobFlagBitVector & (1L << value.ordinal())) > 0) {
				result.add(value);
			}
		}
		return result;
	}
	
	public static <E extends Enum<E>> long fromEnumSet(EnumSet<E> values) {
		long result = 0L;
		for (E value : values) {
			result |= (1L << value.ordinal());
		}
		return result;
	}
}
