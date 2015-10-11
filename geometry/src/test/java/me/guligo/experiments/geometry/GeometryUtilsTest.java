package me.guligo.experiments.geometry;

import java.util.Set;

import me.guligo.experiments.geometry.GeometryUtils;
import me.guligo.experiments.geometry.TriangleType;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test case class for {@link GeometryUtils}.
 * 
 * @author guligo
 */
public class GeometryUtilsTest {

	@Test
	public void testGetTriangleTypesOfScaleneTriangle() {
		Set<TriangleType> triangleTypes = GeometryUtils.getTriangleTypes(2, 3, 4);

		Assert.assertNotNull(triangleTypes);
		Assert.assertEquals(1, triangleTypes.size());
		Assert.assertTrue(triangleTypes.contains(TriangleType.SCALENE));
	}

	@Test
	public void testGetTriangleTypesOfIsoscelesTriangle1() {
		Set<TriangleType> triangleTypes = GeometryUtils.getTriangleTypes(2.00, 2.00, 3.25);

		Assert.assertNotNull(triangleTypes);
		Assert.assertEquals(1, triangleTypes.size());
		Assert.assertTrue(triangleTypes.contains(TriangleType.ISOSCELES));
	}

	@Test
	public void testGetTriangleTypesOfIsoscelesTriangle2() {
		Set<TriangleType> triangleTypes = GeometryUtils.getTriangleTypes(2.00, 3.50, 2.00);

		Assert.assertNotNull(triangleTypes);
		Assert.assertEquals(1, triangleTypes.size());
		Assert.assertTrue(triangleTypes.contains(TriangleType.ISOSCELES));
	}

	@Test
	public void testGetTriangleTypesOfIsoscelesTriangle3() {
		Set<TriangleType> triangleTypes = GeometryUtils.getTriangleTypes(3.75, 2.00, 2.00);

		Assert.assertNotNull(triangleTypes);
		Assert.assertEquals(1, triangleTypes.size());
		Assert.assertTrue(triangleTypes.contains(TriangleType.ISOSCELES));
	}

	@Test
	public void testGetTriangleTypesOfEquilateralTriangle() {
		Set<TriangleType> triangleTypes = GeometryUtils.getTriangleTypes(3, 3, 3);

		Assert.assertNotNull(triangleTypes);
		Assert.assertEquals(2, triangleTypes.size());
		Assert.assertTrue(triangleTypes.contains(TriangleType.ISOSCELES));
		Assert.assertTrue(triangleTypes.contains(TriangleType.EQUILATERAL));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetTriangleTypesOfTriangleWithOneNegativeSide() {
		GeometryUtils.getTriangleTypes(-1, 2, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetTriangleTypesOfTriangleWithOneZeroSide() {
		GeometryUtils.getTriangleTypes(1, 2, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetTriangleTypesOfImpossibleTriangle() {
		GeometryUtils.getTriangleTypes(1, 2, 3);
	}

	@Test
	public void testGetTriangleTypesOfScaleneTriangleWithHighPrecision() {
		Set<TriangleType> triangleTypes = GeometryUtils.getTriangleTypes(5.6, 5.8, 11.399999999999999);

		Assert.assertNotNull(triangleTypes);
		Assert.assertEquals(1, triangleTypes.size());
		Assert.assertTrue(triangleTypes.contains(TriangleType.SCALENE));
	}

}
