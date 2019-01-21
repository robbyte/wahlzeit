/*
* Class: MountainManager
*
* Version: 1.0
*
* Date: 20.01.2019
*
* Copyright notice: AGPLv3
*/

package org.wahlzeit.model;

import java.util.HashMap;
import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.services.ObjectManager;

public class MountainManager extends ObjectManager {

	protected static final PhotoManager instance = new PhotoManager();
	private static final Logger log = Logger.getLogger(MountainManager.class.getName());

	private HashMap<Integer, Mountain> mountains = new HashMap<>();
	private HashMap<String, MountainType> mountainTypes = new HashMap<>();

	private int mountainID = 0;

	
	protected MountainManager() {
		super();
	}
	
	
	public static PhotoManager getInstance() {
		return instance;
	}

	
	public Mountain createMountain(String typeName) {
		MountainType mountainType = getMountainType(typeName);
		Mountain result = mountainType.createInstance();
		mountains.put(mountainID++, result);
		return result;
	}
	

	protected MountainType getMountainType(String typeName) {
		MountainType result = mountainTypes.get(typeName);
		if(result == null) {
			result = new MountainType(this);
			mountainTypes.put(typeName, result);
		}
		return result;
	}

	
	

}
