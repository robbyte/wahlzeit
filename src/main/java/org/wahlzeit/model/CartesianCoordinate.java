/*
* Class: CartesianCoordinate
*
* Version: 2.0
*
* Date: 24.11.2018
*
* Copyright notice: AGPLv3
*/

package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate {
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

	/**
	 * override abstract methods
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
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
	
}
