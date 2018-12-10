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
	 * @param coordinate
	 * constructor
	 */
	public Location(Coordinate coordinate) {
		if (coordinate == null) {
			throw new IllegalArgumentException("Coordinate must be not null.");
		}
		this.coordinate = coordinate;
	}
	
	
	/**
	 * @methodtype query
	 */
	public Coordinate getCoordinate() {
		return coordinate;
	}

	/**
	 * @methodtype mutation
	 */
	public void setCoordinate(Coordinate coordinate) {
		if (coordinate == null) {
			throw new IllegalArgumentException("Coordinate must be not null.");
		}
		this.coordinate = coordinate;
	}
	
	
	
}
