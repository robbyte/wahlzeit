/*
* Class: MountainType
*
* Version: 1.0
*
* Date: 20.01.2019
*
* Copyright notice: AGPLv3
*/

package org.wahlzeit.model;

public class MountainType {
	
	protected MountainManager manager;
	private MountainType superType;
	
	public MountainType(MountainManager manager) {
		this.manager = manager;
	}
	
	
	public boolean isSubtype() {
		return superType != null;
	}
	
	public Mountain createInstance() {
		return new Mountain(this);
	}
	
	public MountainManager getMountainManager() {
		return manager;
	}

}
