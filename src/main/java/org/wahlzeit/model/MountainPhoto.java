/*
* Class: MountainPhoto
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
public class MountainPhoto extends Photo {
	
	/**
	 * 
	 */
	private Mountain mountain;

	/**
	 * constructor
	 */
	public MountainPhoto() {
		super();
	}

	/**
	 * @param myId
	 * constructor
	 */
	public MountainPhoto(PhotoId myId) {
		super(myId);
	}
	

	/**
	 * @methodtype query
	 */
	public Mountain getMountain() {
		return mountain;
	}

	/**
	 * @methodtype mutation
	 */
	public void setMountain(Mountain mountain) {
		this.mountain = mountain;
	}

}
