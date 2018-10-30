/*
* Class: Coordinate
*
* Version: 1.0
*
* Date: 30.10.2018
*
* Copyright notice: AGPLv3
*/

package org.wahlzeit.model;

public class Coordinate {
	/**
	 *
	 */
	private double x, y, z;
	
	
	/**
	 * @methodtype constructor
	 */
	public Coordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	/**
	 * computes the direct Cartesian distance
	 */
	public double getDistance(Coordinate coordinate) {
		return Math.sqrt(
				Math.pow(coordinate.x - x, 2) + 
				Math.pow(coordinate.y - y, 2) + 
				Math.pow(coordinate.z - z, 2)
				);		
	}

	/**
	 * checks if two coordinates are equal
	 */
	public boolean isEqual(Coordinate coordinate) {
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
		Coordinate other = (Coordinate) obj;
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
	
}
