/*
* Class: Location
*
* Version: 1.0
*
* Date: 30.10.2018
*
* Copyright notice: AGPLv3
*/

package org.wahlzeit.model;

public class Location {
	/**
	 *
	 */
	private Coordinate coordinate;

	/**
	 *
	 */
	public Location(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	
	/**
	 * getter and setter
	 */
	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	
	
}
