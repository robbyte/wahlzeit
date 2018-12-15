/*
* Class: SphericCoordinate
*
* Version: 2.1
*
* Date: 29.11.2018
*
* Copyright notice: AGPLv3
*/

package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

public class SphericCoordinate extends AbstractCoordinate {
	
	private static final Logger log = Logger.getLogger(SphericCoordinate.class.getName());
	
	/**
	 *
	 */
	private final double phi, theta, radius;
	
	
	/**
	 * @param phi Angle in degrees [-90, 90]
	 * @param theta Angle in degrees [-180, 180]
	 * @param radius The Radius as a positive number.
	 * constructor
	 */
	private SphericCoordinate(double phi, double theta, double radius) throws IllegalArgumentException {
		assertValidPhi(phi);
		assertValidTheta(theta);
		assertValidRadius(radius);
		
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;

		assertClassInvariants();
	}
	
	
	/**
	 * @methodtype query
	 */
	public static SphericCoordinate createSphericCoordinate(double phi, double theta, double radius) {
		SphericCoordinate coordinate = new SphericCoordinate(phi, theta, radius);
		if (hashMap.containsKey(coordinate.hashCode())) {
			hashMap.get(coordinate.hashCode());
		}
		else {
			hashMap.put(coordinate.hashCode(), coordinate);
		}
		return coordinate;
	}

	
	/**
	 * @methodtype query
	 * forward equals() to isEqual()
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SphericCoordinate other = (SphericCoordinate) obj;
		return isEqual(other);
	}


	/**
	 * @methodtype query
	 */
	public double getPhi() {
		return phi;
	}
	
	/**
	 * @methodtype query
	 */
	public double getTheta() {
		return theta;
	}

	/**
	 * @methodtype query
	 */
	public double getRadius() {
		return radius;
	}
	

	/**
	 * @methodtype query
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() throws IllegalArgumentException {
		assertClassInvariants();
		
		double p = Math.toRadians(phi);
		double t = Math.toRadians(theta);
		
		double x = radius * Math.sin(t) * Math.cos(p);
		double y = radius * Math.sin(t) * Math.sin(p);
		double z = radius * Math.cos(t);

		assertValidDouble(x);
		assertValidDouble(y);
		assertValidDouble(z);
		
		return CartesianCoordinate.createCarthesianCoordinate(x,y,z);
	}

	/**
	 * @methodtype query
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() throws IllegalArgumentException {
		assertClassInvariants();
		return this;
	}

	

	/**
	 * @methodtype helper
	 */
	@Override
	protected void assertClassInvariants() throws IllegalArgumentException {
		try {
			assertValidPhi(phi);
			assertValidTheta(theta);
			assertValidRadius(radius);
		} catch (IllegalArgumentException e) {
			log.config(LogBuilder.createSystemMessage().addException(e.getMessage(), e).toString());
			throw e;
		}
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	
	@Override
	public String toString() {
		return "(" + phi + ", " + theta + ", " + radius + ")"; 
	}

}
