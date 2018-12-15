/*
* Class: SphericCoordinateTest
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

public class SphericCoordinateTest {
	
	final double THRESHOLD = 0.00001;

	/**
	 * testing the constructor
	 */
	@Test
	public void testSphericCoordinate() {
		SphericCoordinate coordinate = SphericCoordinate.createSphericCoordinate(10.0, 20.0, 2.0);

		assertEquals(10.0, coordinate.getPhi());
		assertEquals(20.0, coordinate.getTheta());
		assertEquals(2.0, coordinate.getRadius());
	}

	/**
	 * a few tests for the method getDistance()
	 */
	@Test
	public void testSphericCoordinateGetDistance() {		
		CartesianCoordinate c1 = CartesianCoordinate.createCarthesianCoordinate(0.0, 2.0, 3.0);
		CartesianCoordinate c2 = CartesianCoordinate.createCarthesianCoordinate(1.0, 2.0, 3.0);

		SphericCoordinate s1 = c1.asSphericCoordinate();
		SphericCoordinate s2 = c2.asSphericCoordinate();

		assertEquals(1.0, s1.getCartesianDistance(s2), THRESHOLD);
		assertEquals(1.0, s2.getCartesianDistance(s1), THRESHOLD);
	}

	/**
	 * tests for equals() and isEqual()
	 */
	@Test
	public void testSphericCoordinateEqual() {
		SphericCoordinate coordinate1 = SphericCoordinate.createSphericCoordinate(10.0, 42.0, 13.37);
		SphericCoordinate coordinate2 = SphericCoordinate.createSphericCoordinate(10.0, 42.0, 13.37);
		SphericCoordinate coordinate3 = SphericCoordinate.createSphericCoordinate(20.0, 42.0, 13.37);

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
	public void testSphericCoordinateConversions() {
		SphericCoordinate s1 = SphericCoordinate.createSphericCoordinate(42.0, 1.0, 13.37);
		
		CartesianCoordinate c1 = s1.asCartesianCoordinate();

        assertEquals(s1.getTheta(), c1.asSphericCoordinate().getTheta(), THRESHOLD);
        assertEquals(s1.getPhi(), c1.asSphericCoordinate().getPhi(), THRESHOLD);
        assertEquals(s1.getRadius(), c1.asSphericCoordinate().getRadius(), THRESHOLD);
	}
	
	/**
	 * central angle
	 */
	@Test
	public void testSphericCoordinateCentralAngle() {
		SphericCoordinate s1 = SphericCoordinate.createSphericCoordinate(2.0, -1.0, 1.0);
		SphericCoordinate s2 = SphericCoordinate.createSphericCoordinate(1.0, 2.0, 3.0);

        assertEquals(0.055174, s1.getCentralAngle(s2), THRESHOLD);
        assertEquals(0.055174, s2.getCentralAngle(s1), THRESHOLD);
	}

}
