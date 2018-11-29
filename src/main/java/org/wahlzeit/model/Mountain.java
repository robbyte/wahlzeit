/*
* Class: Mountain
*
* Version: 1.0
*
* Date: 07.11.2018
*
* Copyright notice: AGPLv3
*/

package org.wahlzeit.model;


public class Mountain {
	/**
	 * 
	 */
	private String name;
	private int elevation;
	private int prominence;
	
	
	/**
	 * @param name Name of the mountain
	 * @param elevation Elevation height of the mountain in meters
	 * @param prominence Prominence in meters
	 * constructor
	 */
	public Mountain(String name, int elevation, int prominence) {
		this.name = name;
		this.elevation = elevation;
		this.prominence = prominence;
	}


	/**
	 * @methodtype query
	 */
	public String getName() {
		return name;
	}

	/**
	 * @methodtype mutation
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @methodtype query
	 */
	public int getElevation() {
		return elevation;
	}

	/**
	 * @methodtype mutation
	 */
	public void setElevation(int elevation) {
		this.elevation = elevation;
	}

	/**
	 * @methodtype query
	 */
	public int getProminence() {
		return prominence;
	}

	/**
	 * @methodtype mutation
	 */
	public void setProminence(int prominence) {
		this.prominence = prominence;
	}


}
