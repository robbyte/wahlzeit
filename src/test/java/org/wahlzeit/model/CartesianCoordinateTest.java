/*
* Class: CartesianCoordinateTest
*
* Version: 1.0
*
* Date: 16.11.2018
*
* Copyright notice: AGPLv3
*/

package org.wahlzeit.model;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;

import org.junit.Test;

public class CartesianCoordinateTest {
	
	final double THRESHOLD = 0.00001;

	/**
	 * testing the constructor
	 */
	@Test
	public void testCartesianCoordinate() {
		CartesianCoordinate coordinate = CartesianCoordinate.createCarthesianCoordinate(42.0, -1.0, 13.37);

		assertEquals(42.0, coordinate.getX());
		assertEquals(-1.0, coordinate.getY());
		assertEquals(13.37, coordinate.getZ());
	}

	/**
	 * a few tests for the method getDistance()
	 */
	@Test
	public void testCartesianCoordinateGetDistance() {		
		CartesianCoordinate coordinate1 = CartesianCoordinate.createCarthesianCoordinate(42.0, -1.0, 13.37);
		CartesianCoordinate coordinate2 = CartesianCoordinate.createCarthesianCoordinate(42.0, -1.0, 13.37);
		CartesianCoordinate coordinate3 = CartesianCoordinate.createCarthesianCoordinate(0.0, -1.0, 13.37);
		CartesianCoordinate coordinate4 = CartesianCoordinate.createCarthesianCoordinate(1.1, 2.2, 3.3);
		CartesianCoordinate coordinate5 = CartesianCoordinate.createCarthesianCoordinate(23458234.1123, 212391.2465345235, 32342405.31233);

		assertEquals(coordinate1.getCartesianDistance(coordinate2), 0.0, THRESHOLD);
		assertEquals(coordinate2.getCartesianDistance(coordinate1), 0.0, THRESHOLD);
		assertEquals(coordinate1.getCartesianDistance(coordinate3), 42.0, THRESHOLD);
		assertEquals(coordinate3.getCartesianDistance(coordinate1), 42.0, THRESHOLD);
		assertEquals(coordinate1.getCartesianDistance(coordinate4), 42.242809, THRESHOLD);
		assertEquals(coordinate4.getCartesianDistance(coordinate1), 42.242809, THRESHOLD);
		assertEquals(coordinate1.getCartesianDistance(coordinate5), 39954501.676222, THRESHOLD);
		assertEquals(coordinate5.getCartesianDistance(coordinate1), 39954501.676222, THRESHOLD);
	}

	/**
	 * tests for equals() and isEqual()
	 */
	@Test
	public void testCartesianCoordinateEqual() {
		CartesianCoordinate coordinate1 = CartesianCoordinate.createCarthesianCoordinate(42.0, -1.0, 13.37);
		CartesianCoordinate coordinate2 = CartesianCoordinate.createCarthesianCoordinate(42.0, -1.0, 13.37);
		CartesianCoordinate coordinate3 = CartesianCoordinate.createCarthesianCoordinate(0.0, -1.0, 13.37);

        assertTrue(coordinate1.equals(coordinate2));
        assertTrue(coordinate2.equals(coordinate1));
        assertFalse(coordinate1.equals(coordinate3));
        assertFalse(coordinate3.equals(coordinate1));
        
        assertTrue(coordinate1.isEqual(coordinate2));
        assertTrue(coordinate2.isEqual(coordinate1));
        assertFalse(coordinate1.isEqual(coordinate3));
        assertFalse(coordinate3.isEqual(coordinate1));
	}
	
	/**
	 * conversions
	 */
	@Test
	public void testCartesianCoordinateConversions() {
		CartesianCoordinate c1 = CartesianCoordinate.createCarthesianCoordinate(42.0, 1.0, 13.37);
		
		SphericCoordinate s1 = c1.asSphericCoordinate();

        assertEquals(c1.getX(), s1.asCartesianCoordinate().getX(), THRESHOLD);
        assertEquals(c1.getY(), s1.asCartesianCoordinate().getY(), THRESHOLD);
        assertEquals(c1.getZ(), s1.asCartesianCoordinate().getZ(), THRESHOLD);
	}
	
	/**
	 * central angle
	 */
	@Test
	public void testSphericCoordinateCentralAngle() {
		CartesianCoordinate c1 = CartesianCoordinate.createCarthesianCoordinate(42.0, 1.0, 13.37);
		CartesianCoordinate c2 = CartesianCoordinate.createCarthesianCoordinate(1.0, 2.0, 3.0);

        assertEquals(1.176020, c1.getCentralAngle(c2), THRESHOLD);
        assertEquals(1.176020, c2.getCentralAngle(c1), THRESHOLD);
	}

}
