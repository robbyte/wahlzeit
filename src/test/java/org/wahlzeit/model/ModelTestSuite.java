/*
* Class: ModelTestSuite
*
* Version: 1.0
*
* Date: 30.10.2018
*
* Copyright notice: AGPLv3
*/

package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	AccessRightsTest.class, 
	CartesianCoordinateTest.class, 
	SphericCoordinateTest.class, 
	FlagReasonTest.class, 
	GenderTest.class, 
	GuestTest.class, 
	MountainPhotoTest.class, 
	MountainPhotoFactoryTest.class, 
	MountainPhotoManagerTest.class, 
	PhotoFilterTest.class, 
	TagsTest.class, 
	UserStatusTest.class, 
	ValueTest.class
	})
public class ModelTestSuite {

}
