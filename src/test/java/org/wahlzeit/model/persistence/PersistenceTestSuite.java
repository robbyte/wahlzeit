/*
* Class: PersistenceTestSuite
*
* Version: 1.0
*
* Date: 30.10.2018
*
* Copyright notice: AGPLv3
*/

package org.wahlzeit.model.persistence;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	DatastoreAdapterTest.class
	})
public class PersistenceTestSuite {

}
