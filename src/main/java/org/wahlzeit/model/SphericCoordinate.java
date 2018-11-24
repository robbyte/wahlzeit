/*
* Class: SphericCoordinate
*
* Version: 2.0
*
* Date: 24.11.2018
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
		if (Math.abs(phi) > 90.0) {
			throw new IllegalArgumentException("Latitude has to be in range of [-90,90]");
		}
		this.phi = phi;
	}

	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		if (Math.abs(theta) > 180.0) {
			throw new IllegalArgumentException("Longtitude has to be in range of [-180,180]");
		}
		this.theta = theta;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if (radius < 0.0) {
			throw new IllegalArgumentException("Radius has to be a positive number.");
		}
		this.radius = radius;
	}
	

	/**
	 * override abstract methods
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		double p = Math.toRadians(phi);
		double t = Math.toRadians(theta);
		
		double x = radius * Math.sin(t) * Math.cos(p);
		double y = radius * Math.sin(t) * Math.sin(p);
		double z = radius * Math.cos(t);
		
		return new CartesianCoordinate(x,y,z);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}


}
