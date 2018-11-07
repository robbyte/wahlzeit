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
	 * @methodtype constructor
	 */
	public MountainPhoto() {
		super();
	}

	/**
	 * @methodtype constructor
	 */
	public MountainPhoto(PhotoId myId) {
		super(myId);
	}
	

	/**
	 * @methodtype get
	 */
	public Mountain getMountain() {
		return mountain;
	}

	/**
	 * @methodtype set
	 */
	public void setMountain(Mountain mountain) {
		this.mountain = mountain;
	}

}
