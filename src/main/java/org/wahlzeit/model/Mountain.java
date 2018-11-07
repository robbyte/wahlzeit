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

/**
 * 
 */
public class Mountain {
	/**
	 * name of the mountain
	 */
	private String name;
	
	/**
	 * elevation height of the mountain in meters
	 */
	private int elevation;
	
	/**
	 * prominence in meters
	 */
	private int prominence;
	
	
	/**
	 * @methodtype constructor
	 */
	public Mountain(String name, int elevation, int prominence) {
		this.name = name;
		this.elevation = elevation;
		this.prominence = prominence;
	}


	/**
	 * @methodtype get
	 */
	public String getName() {
		return name;
	}


	/**
	 * @methodtype set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @methodtype get
	 */
	public int getElevation() {
		return elevation;
	}


	/**
	 * @methodtype set
	 */
	public void setElevation(int elevation) {
		this.elevation = elevation;
	}


	/**
	 * @methodtype get
	 */
	public int getProminence() {
		return prominence;
	}


	/**
	 * @methodtype set
	 */
	public void setProminence(int prominence) {
		this.prominence = prominence;
	}


}
