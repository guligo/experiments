package me.guligo.experiments.geometry;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * This class contains methods for basic geometric operations.
 * 
 * @author guligo
 */
public final class GeometryUtils {

	/**
	 * Prevents instantiation of this class.
	 */
	private GeometryUtils() {
		// empty
	}

	/**
	 * Returns type(s) that triangle with corresponding side lengths belongs to.
	 * 
	 * @param a
	 *         One of triangle's side lengths
	 * @param b
	 *         One of triangle's side lengths
	 * @param c
	 *         One of triangle's side lengths
	 * 
	 * @throws IllegalArgumentException
	 *         If side lengths provided as arguments do not represent
	 *         geometrically correct triangle
	 * 
	 * @return Set of triangle types that tested triangle belongs to
	 */
	public static Set<TriangleType> getTriangleTypes(BigDecimal a, BigDecimal b, BigDecimal c) {
		if (!isValidTriangle(a, b, c))
			throw new IllegalArgumentException("Invalid triangle!");
		return getTriangleTypes(countEqualTriangleSides(a, b, c));
	}

	/**
	 * @see GeometryUtils#getTriangleTypes(BigDecimal, BigDecimal, BigDecimal).
	 */
	public static Set<TriangleType> getTriangleTypes(double a, double b, double c) {
		return getTriangleTypes(BigDecimal.valueOf(a), BigDecimal.valueOf(b), BigDecimal.valueOf(c));
	}

	/**
	 * Returns "true" if side lengths provided in argument represent
	 * geometrically correct triangle.
	 */
	private static boolean isValidTriangle(BigDecimal... sideLengths) {
		for (int i = 0; i < 3; i++)
			if (sideLengths[i].compareTo(BigDecimal.ZERO) <= 0 || sideLengths[i].add(sideLengths[(i + 1) % 3]).compareTo(sideLengths[(i + 2) % 3]) <= 0)
				return false;
		return true;
	}

	/**
	 * Returns number of triangle's sides that are equal in length.
	 */
	private static int countEqualTriangleSides(BigDecimal... sideLengths) {
		if (sideLengths[0].compareTo(sideLengths[1]) == 0 && sideLengths[1].compareTo(sideLengths[2]) == 0)
			return 3;
		else if (sideLengths[0].compareTo(sideLengths[1]) == 0 || sideLengths[1].compareTo(sideLengths[2]) == 0 || sideLengths[2].compareTo(sideLengths[0]) == 0)
			return 2;
		return 0;
	}

	/**
	 * Returns set of triangle types that triangle with specified amount of
	 * identical sides belongs to.
	 */
	private static Set<TriangleType> getTriangleTypes(int equalSides) {
		Set<TriangleType> triangleTypes = new HashSet<TriangleType>();
		switch (equalSides) {
			case 0:
				triangleTypes.add(TriangleType.SCALENE);
				break;
			case 3:
				triangleTypes.add(TriangleType.EQUILATERAL);
			case 2:
				triangleTypes.add(TriangleType.ISOSCELES);
		}
		return triangleTypes;
	}

}
