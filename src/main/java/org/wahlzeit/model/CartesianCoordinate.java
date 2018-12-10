/*
* Class: CartesianCoordinate
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

public class CartesianCoordinate extends AbstractCoordinate {

	private static final Logger log = Logger.getLogger(SphericCoordinate.class.getName());
	
	/**
	 *
	 */
	private double x, y, z;
	
	
	/**
	 * @param x Coordinate in x direction
	 * @param y Coordinate in y direction
	 * @param z Coordinate in z direction
	 * constructor
	 */
	public CartesianCoordinate(double x, double y, double z) throws IllegalArgumentException {
		setX(x);
		setY(y);
		setZ(z);
		
		assertClassInvariants();
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
		CartesianCoordinate other = (CartesianCoordinate) obj;
		return isEqual(other);
	}


	/**
	 * @methodtype query
	 */
	public double getX() {
		return x;
	}

	/**
	 * @methodtype mutation
	 */
	public void setX(double x) throws IllegalArgumentException {
		assertValidDouble(x);
		this.x = x;
	}

	/**
	 * @methodtype query
	 */
	public double getY() {
		return y;
	}

	/**
	 * @methodtype mutation
	 */
	public void setY(double y) throws IllegalArgumentException {
		assertValidDouble(y);
		this.y = y;
	}

	/**
	 * @methodtype query
	 */
	public double getZ() {
		return z;
	}

	/**
	 * @methodtype mutation
	 */
	public void setZ(double z) throws IllegalArgumentException {
		assertValidDouble(z);
		this.z = z;
	}

	/**
	 * @methodtype query
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() throws IllegalArgumentException {
		assertClassInvariants();
		return this;
	}
	
	/**
	 * @methodtype query
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() throws IllegalArgumentException {
		assertClassInvariants();
		
		double radius = Math.sqrt(x * x + y * y + z * z);
		double p = Math.atan(y / x);
		double t = Math.acos(z / radius);

		double phi = Math.toDegrees(p);
		double theta = Math.toDegrees(t);
		
		assertValidPhi(phi);
		assertValidTheta(theta);
		assertValidRadius(radius);
		
		return new SphericCoordinate(phi, theta, radius);
	}
	
	/**
	 * @methodtype helper
	 */
	@Override
	protected void assertClassInvariants() throws IllegalArgumentException {
		try {
			assertValidDouble(x);
			assertValidDouble(y);
			assertValidDouble(z);
		} catch (IllegalArgumentException e) {
			log.config(LogBuilder.createSystemMessage().addException(e.getMessage(), e).toString());
			throw e;
		}
	}

}
