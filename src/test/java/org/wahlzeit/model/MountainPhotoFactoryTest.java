/*
* Class: MountainPhotoFactoryTest
*
* Version: 1.0
*
* Date: 07.11.2018
*
* Copyright notice: AGPLv3
*/

package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;

/**
 *
 */
public class MountainPhotoFactoryTest {

	/**
	 * 
	 */
	@ClassRule
	public static RuleChain ruleChain = RuleChain.
			outerRule(new LocalDatastoreServiceTestConfigProvider()).
			around(new RegisteredOfyEnvironmentProvider());
	
	/**
	 * 
	 */
	@Test
	public void testGetInstance() {
		MountainPhotoFactory mountainPhotoFactory = MountainPhotoFactory.getInstance();
		
		assertNotNull(mountainPhotoFactory);
		assertTrue(mountainPhotoFactory instanceof MountainPhotoFactory);
	}

	/**
	 * 
	 */
	@Test
	public void testCreatePhoto() {
		MountainPhoto mountainPhoto = MountainPhotoFactory.getInstance().createPhoto();
		
		assertNotNull(mountainPhoto);
		assertTrue(mountainPhoto instanceof MountainPhoto);
	}

	/**
	 * 
	 */
	@Test
	public void testCreatePhotoPhotoId() {
		PhotoId photoId = new PhotoId(42);
		MountainPhoto mountainPhoto = MountainPhotoFactory.getInstance().createPhoto(photoId);
		
		assertNotNull(mountainPhoto);
		assertTrue(mountainPhoto instanceof MountainPhoto);
	}
	
}
