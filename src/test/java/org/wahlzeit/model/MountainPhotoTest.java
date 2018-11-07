/*
* Class: MountainPhotoTest
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
public class MountainPhotoTest {
	
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
	public void testMountainPhotoPhotoId() {
		PhotoId photoId = new PhotoId(42);
		MountainPhoto mountainPhoto = new MountainPhoto(photoId);
		
		assertEquals(photoId, mountainPhoto.getId());
	}

	/**
	 * 
	 */
	@Test
	public void testMountain() {
		Mountain mountain = new Mountain("Zugspitze", 2962, 1746);
		MountainPhoto mountainPhoto = new MountainPhoto();
		mountainPhoto.setMountain(mountain);

		assertEquals(mountain, mountainPhoto.getMountain());
		assertEquals(mountain.getName(), "Zugspitze");
		assertEquals(mountain.getElevation(), 2962);
		assertEquals(mountain.getProminence(), 1746);
		
	}

}
