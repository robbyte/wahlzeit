/*
* Class: Coordinate
*
* Version: 2.0
*
* Date: 16.11.2018
*
* Copyright notice: AGPLv3
*/

package org.wahlzeit.model;

public interface Coordinate {

	public CartesianCoordinate asCartesianCoordinate();
	
	public double getCartesianDistance(Coordinate coordinate);
	
	public SphericCoordinate asSphericCoordinate();
	
	public double getCentralAngle(Coordinate coordinate);
	
	public boolean isEqual(Coordinate coordinate);
	
}
