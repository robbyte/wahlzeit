/*
* Class: CoordinateTest
*
* Version: 1.0
*
* Date: 30.10.2018
*
* Copyright notice: AGPLv3
*/

package org.wahlzeit.model;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;

import org.junit.Test;

public class CoordinateTest {

	/**
	 * testing the constructor
	 */
	@Test
	public void testCoordinate() {
		Coordinate coordinate = new Coordinate(42.0, -1.0, 13.37);

		assertEquals(42.0, coordinate.getX());
		assertEquals(-1.0, coordinate.getY());
		assertEquals(13.37, coordinate.getZ());
	}

	/**
	 * a few tests for the method getDistance()
	 */
	@Test
	public void testCoordinateGetDistance() {
		final double THRESHOLD = 0.00001;
		
		Coordinate coordinate1 = new Coordinate(42.0, -1.0, 13.37);
		Coordinate coordinate2 = new Coordinate(42.0, -1.0, 13.37);
		Coordinate coordinate3 = new Coordinate(0.0, -1.0, 13.37);
		Coordinate coordinate4 = new Coordinate(1.1, 2.2, 3.3);
		Coordinate coordinate5 = new Coordinate(23458234.1123, 212391.2465345235, 32342405.31233);

		assertEquals(coordinate1.getDistance(coordinate2), 0.0, THRESHOLD);
		assertEquals(coordinate2.getDistance(coordinate1), 0.0, THRESHOLD);
		assertEquals(coordinate1.getDistance(coordinate3), 42.0, THRESHOLD);
		assertEquals(coordinate3.getDistance(coordinate1), 42.0, THRESHOLD);
		assertEquals(coordinate1.getDistance(coordinate4), 42.242809, THRESHOLD);
		assertEquals(coordinate4.getDistance(coordinate1), 42.242809, THRESHOLD);
		assertEquals(coordinate1.getDistance(coordinate5), 39954501.676222, THRESHOLD);
		assertEquals(coordinate5.getDistance(coordinate1), 39954501.676222, THRESHOLD);
	}

	/**
	 * tests for equals() and isEqual()
	 */
	@Test
	public void testCoordinateEqual() {
		Coordinate coordinate1 = new Coordinate(42.0, -1.0, 13.37);
		Coordinate coordinate2 = new Coordinate(42.0, -1.0, 13.37);
		Coordinate coordinate3 = new Coordinate(0.0, -1.0, 13.37);

        assertTrue(coordinate1.equals(coordinate2));
        assertTrue(coordinate2.equals(coordinate1));
        assertFalse(coordinate1.equals(coordinate3));
        assertFalse(coordinate3.equals(coordinate1));
        
        assertTrue(coordinate1.isEqual(coordinate2));
        assertTrue(coordinate2.isEqual(coordinate1));
        assertFalse(coordinate1.isEqual(coordinate3));
        assertFalse(coordinate3.isEqual(coordinate1));
	}

}
