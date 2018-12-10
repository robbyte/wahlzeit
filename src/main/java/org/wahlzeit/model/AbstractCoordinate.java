/*
* Class: AbstractCoordinate
*
* Version: 1.1
*
* Date: 29.11.2018
*
* Copyright notice: AGPLv3
*/

package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {

	/**
	 * @methodtype query
	 */
	@Override
	public abstract CartesianCoordinate asCartesianCoordinate() throws IllegalArgumentException;
	
	
	/**
	 * @methodtype query
	 */
	@Override
	public abstract SphericCoordinate asSphericCoordinate() throws IllegalArgumentException;
	
	
	/**
	 * @param c1
	 * @param c2
	 * @methodtype helper
	 * computes the direct Cartesian distance
	 */
	private double getDistance(CartesianCoordinate c1, CartesianCoordinate c2) {
		return Math.sqrt(
				Math.pow(c1.getX() - c2.getX(), 2) + 
				Math.pow(c1.getY() - c2.getY(), 2) + 
				Math.pow(c1.getZ() - c2.getZ(), 2)
				);
	}
	
	/**
	 * @param coordinate
	 * @methodtype query
	 */
	@Override
	public double getCartesianDistance(Coordinate coordinate) throws IllegalArgumentException {
		assertClassInvariants();
		double result = getDistance(this.asCartesianCoordinate(), coordinate.asCartesianCoordinate());
		assertValidDouble(result);
		return result;
	}

	
	/**
	 * @param s1
	 * @param s2
	 * @methodtype helper
	 * computes the central angle
	 * https://en.wikipedia.org/wiki/Great-circle_distance
	 */
	private double getCentralAngle(SphericCoordinate s1, SphericCoordinate s2) {
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
	
	/**
	 * @param coordinate
	 * @methodtype query
	 */
	@Override
	public double getCentralAngle(Coordinate coordinate) throws IllegalArgumentException {
		assertClassInvariants();
		double result = getCentralAngle(this.asSphericCoordinate(), coordinate.asSphericCoordinate());
		assertValidDouble(result);
		return result;
	}
	
	
	/**
	 * @param c1
	 * @param c2
	 * @methodtype helper
	 * checks if two coordinates are equal
	 */
	private boolean isEqual(CartesianCoordinate c1, CartesianCoordinate c2) {
		final double THRESHOLD = 0.00001;

		if (Math.abs(c1.getX() - c2.getX()) < THRESHOLD &&
			Math.abs(c1.getY() - c2.getY()) < THRESHOLD &&
			Math.abs(c1.getZ() - c2.getZ()) < THRESHOLD) {
			return true;
		}
		return false;
	}

	/**
	 * @param coordinate
	 * @methodtype query
	 */
	@Override
	public boolean isEqual(Coordinate coordinate) throws IllegalArgumentException {
		assertClassInvariants();
		return isEqual(this.asCartesianCoordinate(), coordinate.asCartesianCoordinate());
	}
	
	/**
	 * @methodtype helper
	 */
	protected abstract void assertClassInvariants();
	
	
	/**
	 * @param phi
	 * @methodtype helper
	 */
	protected void assertValidPhi(double phi) throws IllegalArgumentException {
		if (Math.abs(phi) > 90.0) {
			throw new IllegalArgumentException("The angle phi has to be in range of [-90,90].");
		}
	}

	/**
	 * @param theta
	 * @methodtype helper
	 */
	protected void assertValidTheta(double theta) throws IllegalArgumentException {
		if (Math.abs(theta) > 180.0) {
			throw new IllegalArgumentException("The angle theta has to be in range of [-180,180].");
		}
	}

	/**
	 * @param radius
	 * @methodtype helper
	 */
	protected void assertValidRadius(double radius) throws IllegalArgumentException {
		if (Math.abs(radius) < 0) {
			throw new IllegalArgumentException("The Radius has to be a positive number.");
		}
	}
	
	/**
	 * @param number
	 * @methodtype helper
	 */
	protected void assertValidDouble(double number) throws IllegalArgumentException {
		if (Double.isNaN(number)) {
			throw new IllegalArgumentException("The number has to be a valid double.");
		}
		if(!Double.isFinite(number)) {
			throw new IllegalArgumentException("The number has to be finite.");
		}
	}
	
}
