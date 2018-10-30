/*
* Class: UtilsTestSuite
*
* Version: 1.0
*
* Date: 30.10.2018
*
* Copyright notice: AGPLv3
*/

package org.wahlzeit.utils;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	StringUtilTest.class,
	VersionTest.class
	})
public class UtilsTestSuite {

}
