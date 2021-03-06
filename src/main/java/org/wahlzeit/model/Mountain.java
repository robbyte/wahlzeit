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

/*
* Method calls for object creation:
* 	1. MountainManager.getInstance();
* 	2. MountainManager.createMountain();
* 	3. MountainType.createInstance();
* 	4. return new Mountain();
* 
* Design Space for object creation:
* 	1. Delegation: separate-object
* 	2. Selection: on-the-spot
* 	3. Configuration: nothing
* 	4. Instantiation: in-code
* 	5. Initialization: by-fixed-signature
* 	6. Building: default
*/
public class Mountain {
	/**
	 * 
	 */
	private String name;
	private int elevation;
	private int prominence;
	

	protected MountainManager manager;
	protected MountainType mountainType;
	
	
	/**
	 * @param name Name of the mountain
	 * @param elevation Elevation height of the mountain in meters
	 * @param prominence Prominence in meters
	 * constructor
	 */
	public Mountain(MountainType mountainType) {
		this.mountainType = mountainType;
		this.manager = mountainType.getMountainManager();
	}
	
	
	/**
	 * @param name Name of the mountain
	 * @param elevation Elevation height of the mountain in meters
	 * @param prominence Prominence in meters
	 * constructor
	 */
	public Mountain(String name, int elevation, int prominence) {
		setName(name);
		setElevation(elevation);
		setProminence(prominence);
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
		assertValidName(name);
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
		assertValidElevation(elevation);
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
		assertValidProminence(prominence);
		this.prominence = prominence;
	}
	
	
	/**
	 * @param name
	 * @methodtype helper
	 */
	protected void assertValidName(String name) {
		if (name.length() == 0) {
			throw new IllegalArgumentException("The name must to be empty.");
		}
		if (name.length() > 100) {
			throw new IllegalArgumentException("The name can have at least 100 characters.");
		}
	}
	
	/**
	 * @param elevation
	 * @methodtype helper
	 */
	protected void assertValidElevation(int elevation) {
		if (elevation < 0) {
			throw new IllegalArgumentException("Elevation must be a positive number.");
		}
		if (elevation > 10000) {
			throw new IllegalArgumentException("There is no mountain higher than 10 km.");
		}
	}
	
	/**
	 * @param prominence
	 * @methodtype helper
	 */
	protected void assertValidProminence(int prominence) {
		if (prominence < 0) {
			throw new IllegalArgumentException("Prominence must be a positive number.");
		}
	}




}
