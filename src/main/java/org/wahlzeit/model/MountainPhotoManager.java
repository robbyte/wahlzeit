/*
* Class: MountainPhotoManager
*
* Version: 1.0
*
* Date: 07.11.2018
*
* Copyright notice: AGPLv3
*/

package org.wahlzeit.model;

import java.util.logging.Logger;

/**
 * 
 */
public class MountainPhotoManager extends PhotoManager {

	/**
	 *
	 */
	protected static final MountainPhotoManager instance = new MountainPhotoManager();
	
	private static final Logger log = Logger.getLogger(MountainPhotoManager.class.getName());

	
	/**
	 * constructor
	 */
	public MountainPhotoManager() {
		photoTagCollector = MountainPhotoFactory.getInstance().createPhotoTagCollector();
	}
	
	/**
	 * @methodtype query
	 */
	public static final MountainPhotoManager getInstance() {
		return instance;
	}


}
