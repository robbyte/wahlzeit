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

public class SphericCoordinate extends AbstractCoordinate {
	/**
	 *
	 */
	private double phi, theta, radius;
	
	
	/**
	 * 
	 */
	public SphericCoordinate(double phi, double theta, double radius) {
		setPhi(phi);
		setTheta(theta);
		setRadius(radius);

		assertClassInvariants();
	}

	
	/**
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
	 * getter and setter methods
	 */
	public double getPhi() {
		return phi;
	}

	public void setPhi(double phi) {
		this.phi = phi;
	}

	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	

	/**
	 * override abstract methods
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		assertClassInvariants();
		
		double p = Math.toRadians(phi);
		double t = Math.toRadians(theta);
		
		double x = radius * Math.sin(t) * Math.cos(p);
		double y = radius * Math.sin(t) * Math.sin(p);
		double z = radius * Math.cos(t);
		
		return new CartesianCoordinate(x, y, z);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		assertClassInvariants();
		
		return this;
	}

	
	/**
	 * assertion methods
	 */
	@Override
	protected void assertClassInvariants() {
		assertValidPhi(phi);
		assertValidTheta(theta);
		assertValidRadius(radius);
	}
	
	protected void assertValidPhi(double phi) {
		assert (Math.abs(phi) <= 90.0);
	}
	
	protected void assertValidTheta(double theta) {
		assert (Math.abs(theta) <= 180.0);
	}
	
	protected void assertValidRadius(double radius) {
		assert (Math.abs(radius) >= 0);
	}
	

}
