package jerik.util;

import static jerik.util.Preconditions.checkPositive;
import java.util.Arrays;
import java.util.Random;

/**
 * 
 * @author dan
 */
/**
 * @author derickson82
 *
 */
public final class Dice {

	private static final Random random = new Random(System.currentTimeMillis());

	// I believe this is the standard set for d20 games. No reason not to add
	// more though.
	public static final Dice d4 = Dice.create(4);

	public static final Dice d6 = Dice.create(6);

	public static final Dice d8 = Dice.create(8);

	public static final Dice d10 = Dice.create(10);

	public static final Dice d12 = Dice.create(12);

	public static final Dice d20 = Dice.create(20);

	public static final Dice d100 = Dice.create(100);

	public static Dice create(int sides) {
		return new Dice(1, sides, 0);
	}

	public static Dice create(int numberOfDice, int sides) {
		return new Dice(numberOfDice, sides, 0);
	}

	public static Dice create(int numberOfDice, int sides, int constant) {
		return new Dice(numberOfDice, sides, constant);
	}

	private final int sides;
	private final int numberOfDice;
	private final int constant;

	private Dice(int numberOfDice, int sides, int constant) {
		checkPositive(sides, "sides");
		this.sides = sides;
		this.numberOfDice = numberOfDice;
		this.constant = constant;
	}
	
	public int getNumberOfDice() {
		return numberOfDice;
	}
	
	public int getConstant() {
		return constant;
	}

	public int getSides() {
		return sides;
	}

	public int roll() {
		int score = 0;
		for (int i = 0; i < numberOfDice; i++) {
			score += random.nextInt(sides) + 1;
		}
		return score + constant;
	}

	public int rollKeepHigh(int keepers) {
		checkPositive(keepers, "keepers");
		if (keepers > numberOfDice) {
			throw new IllegalArgumentException(
					"Cannot keep more dice than are being rolled! Keeping: "
							+ keepers + ", number of dice: " + numberOfDice);
		}
		int[] rolls = new int[numberOfDice];
		for (int i = 0; i < numberOfDice; i++) {
			rolls[i] = random.nextInt(sides) + 1;
		}
		Arrays.sort(rolls);
		int score = 0;
		for (int i = 1; i <= keepers; i++) {
			score += rolls[rolls.length - i];
		}
		return score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + constant;
		result = prime * result + numberOfDice;
		result = prime * result + sides;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dice other = (Dice) obj;
		if (constant != other.constant)
			return false;
		if (numberOfDice != other.numberOfDice)
			return false;
		if (sides != other.sides)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dice [numberOfDice=" + numberOfDice + ", sides=" + sides
				+ ", constant=" + constant + "]";
	}


}
