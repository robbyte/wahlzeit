/*
* Class: CartesianCoordinate
*
* Version: 1.0
*
* Date: 16.11.2018
*
* Copyright notice: AGPLv3
*/

package org.wahlzeit.model;

public class CartesianCoordinate implements Coordinate {
	/**
	 *
	 */
	private double x, y, z;
	
	
	/**
	 * 
	 */
	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	/**
	 * computes the direct Cartesian distance
	 */
	private double getDistance(CartesianCoordinate coordinate) {
		return Math.sqrt(
				Math.pow(coordinate.x - x, 2) + 
				Math.pow(coordinate.y - y, 2) + 
				Math.pow(coordinate.z - z, 2)
				);		
	}

	/**
	 * checks if two coordinates are equal
	 */
	private boolean isEqual(CartesianCoordinate coordinate) {
		final double THRESHOLD = 0.00001;

		if (Math.abs(x - coordinate.x) < THRESHOLD &&
			Math.abs(y - coordinate.y) < THRESHOLD &&
			Math.abs(z - coordinate.z) < THRESHOLD) {
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
		CartesianCoordinate other = (CartesianCoordinate) obj;
		return isEqual(other);
	}


	/**
	 * getter and setter methods
	 */
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}


	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}


	@Override
	public double getCartesianDistance(Coordinate coordinate) {
		return getDistance(coordinate.asCartesianCoordinate());
	}


	@Override
	public SphericCoordinate asSphericCoordinate() {
		double radius = Math.sqrt(x * x + y * y + z * z);
		double p = Math.atan(y / x);
		double t = Math.acos(z / radius);

		double phi = Math.toDegrees(p);
		double theta = Math.toDegrees(t);
		
		return new SphericCoordinate(phi, theta, radius);
	}


	@Override
	public double getCentralAngle(Coordinate coordinate) {
		return this.asSphericCoordinate().getCentralAngle(coordinate.asSphericCoordinate());
	}


	@Override
	public boolean isEqual(Coordinate coordinate) {
		return isEqual(coordinate.asCartesianCoordinate());
	}
	
}
