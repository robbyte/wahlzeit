/*
* Class: SphericCoordinate
*
* Version: 1.0
*
* Date: 16.11.2018
*
* Copyright notice: AGPLv3
*/

package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate {
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
	 * checks if two coordinates are equal
	 */
	private boolean isEqual(SphericCoordinate coordinate) {
		final double THRESHOLD = 0.00001;

		if (Math.abs(phi - coordinate.phi) < THRESHOLD &&
			Math.abs(theta - coordinate.theta) < THRESHOLD &&
			Math.abs(radius - coordinate.radius) < THRESHOLD) {
			return true;
		}
		return false;
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
	 * computes the central angle
	 * https://en.wikipedia.org/wiki/Great-circle_distance
	 */
	private double getCentralAngle(SphericCoordinate coordinate) {
		double p1 = Math.toRadians(phi);
		double t1 = Math.toRadians(theta);
		double p2 = Math.toRadians(coordinate.getPhi());
		double t2 = Math.toRadians(coordinate.getTheta());

		double delta_t = Math.abs(t1 - t2);
		
		return Math.acos(
				Math.sin(p1) * Math.sin(p2) + 
				Math.cos(p1) * Math.cos(p2) * Math.cos(delta_t)
				);
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
	public double getCartesianDistance(Coordinate coordinate) {
		return this.asCartesianCoordinate().getCartesianDistance(coordinate);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

	@Override
	public double getCentralAngle(Coordinate coordinate) {
		return getCentralAngle(coordinate.asSphericCoordinate());
	}

	@Override
	public boolean isEqual(Coordinate coordinate) {
		return isEqual(coordinate.asSphericCoordinate());
	}

}
