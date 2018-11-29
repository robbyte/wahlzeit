/*
* Class: AbstractCoordinate
*
* Version: 1.0
*
* Date: 24.11.2018
*
* Copyright notice: AGPLv3
*/

package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {

	@Override
	public abstract CartesianCoordinate asCartesianCoordinate();
	
	@Override
	public abstract SphericCoordinate asSphericCoordinate();
	
	
	/**
	 * computes the direct Cartesian distance
	 */
	private double getDistance(CartesianCoordinate c1, CartesianCoordinate c2) {
		assertClassInvariants();
		
		return Math.sqrt(
				Math.pow(c1.getX() - c2.getX(), 2) + 
				Math.pow(c1.getY() - c2.getY(), 2) + 
				Math.pow(c1.getZ() - c2.getZ(), 2)
				);		
	}
	
	@Override
	public double getCartesianDistance(Coordinate coordinate) {
		return getDistance(this.asCartesianCoordinate(), coordinate.asCartesianCoordinate());
	}

	
	/**
	 * computes the central angle
	 * https://en.wikipedia.org/wiki/Great-circle_distance
	 */
	private double getCentralAngle(SphericCoordinate s1, SphericCoordinate s2) {
		assertClassInvariants();
		
		double p1 = Math.toRadians(s1.getPhi());
		double t1 = Math.toRadians(s1.getTheta());
		double p2 = Math.toRadians(s2.getPhi());
		double t2 = Math.toRadians(s2.getTheta());

		double delta_t = Math.abs(t1 - t2);
		
		return Math.acos(
				Math.sin(p1) * Math.sin(p2) + 
				Math.cos(p1) * Math.cos(p2) * Math.cos(delta_t)
				);
	}
	
	@Override
	public double getCentralAngle(Coordinate coordinate) {
		return getCentralAngle(this.asSphericCoordinate(), coordinate.asSphericCoordinate());
	}
	
	
	/**
	 * checks if two coordinates are equal
	 */
	private boolean isEqual(CartesianCoordinate c1, CartesianCoordinate c2) {
		assertClassInvariants();
		
		final double THRESHOLD = 0.00001;

		if (Math.abs(c1.getX() - c2.getX()) < THRESHOLD &&
			Math.abs(c1.getY() - c2.getY()) < THRESHOLD &&
			Math.abs(c1.getZ() - c2.getZ()) < THRESHOLD) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isEqual(Coordinate coordinate) {
		return isEqual(this.asCartesianCoordinate(), coordinate.asCartesianCoordinate());
	}
	
	
	protected abstract void assertClassInvariants();
	
}
