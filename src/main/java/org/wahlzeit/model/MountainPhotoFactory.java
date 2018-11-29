/*
* Class: MountainPhotoFactory
*
* Version: 1.0
*
* Date: 07.11.2018
*
* Copyright notice: AGPLv3
*/

package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

/**
 * 
 */
public class MountainPhotoFactory extends PhotoFactory {
	
	/**
	 * 
	 */
	private static final Logger log = Logger.getLogger(MountainPhotoFactory.class.getName());
	
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	private static MountainPhotoFactory instance = null;

	
	/**
	 * constructor
	 */
	protected MountainPhotoFactory() {
		super();
	}

	/**
	 * @methodtype mutation
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	public static void initialize() {
		getInstance(); // drops result due to getInstance() side-effects
	}

	/**
	 * @methodtype query
	 * Public singleton access method.
	 */
	public static synchronized MountainPhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic MountainPhotoFactory").toString());
			setInstance(new MountainPhotoFactory());
		}

		return instance;
	}

	/**
	 * @param mountainPhotoFactory
	 * @methodtype mutation
	 * Method to set the singleton instance of MountainPhotoFactory.
	 */
	protected static synchronized void setInstance(MountainPhotoFactory mountainPhotoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize MountainPhotoFactory twice");
		}

		instance = mountainPhotoFactory;
	}
	
	
	/**
	 * @methodtype mutation
	 */
	public MountainPhoto createPhoto() {
		return new MountainPhoto();
	}

	/**
	 * @param id
	 * @methodtype mutation
	 * Creates a new MountainPhoto with the specified id
	 */
	public MountainPhoto createPhoto(PhotoId id) {
		return new MountainPhoto(id);
	}
	

}
