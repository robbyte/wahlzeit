/*
* Class: MountainPhotoManagerTest
*
* Version: 1.0
*
* Date: 07.11.2018
*
* Copyright notice: AGPLv3
*/

package org.wahlzeit.model;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;

/**
 * 
 */
public class MountainPhotoManagerTest {
	
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
		MountainPhotoManager mountainPhotoManager = MountainPhotoManager.getInstance();
		
		assertNotNull(mountainPhotoManager);
		assertTrue(mountainPhotoManager instanceof MountainPhotoManager);
	}
	
	
}
