package me.guligo.experiments.mavenprojgen.utils;

/**
 * Provides common static functions.
 * 
 * @author guligo
 */
public final class CommonsUtil {

	private CommonsUtil() {
		// do nothing
	}

	public static String getLetter(int index) {
		if (index >= 0 && index <= 25) {
			return String.valueOf('A' + (index - 00));
		} else if (index >= 26 && index <= 51) {
			return String.valueOf('a' + (index - 26));
		} else if (index >= 52 && index <= 61) {
			return String.valueOf('0' + (index - 52));
		} else {
			throw new RuntimeException("Index is not in range [0; 61]");
		}
	}

}
