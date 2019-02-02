```java


// Collaboration of MountainPhoto and Mountain
public collaboration MountainPhoto_Mountain {
	public role MountainPhoto {
		public Mountain getMountain();
		public void setMountain(Mountain mountain);
	}

	public role Mountain {}
}

public class MountainPhoto extends Photo binds MountainPhoto_Mountain.MountainPhoto {
	public Mountain getMountain() {
		return MountainPhoto_Mountain.MountainPhoto.getMountain();
	}
	public void setMountain(Mountain mountain) {
		MountainPhoto_Mountain.MountainPhoto.setMountain(mountain);
	}
}

public class Mountain binds MountainPhoto_Mountain.Mountain {}



// Collaboration of Mountain and MountainType
public collaboration Mountain_MountainType {
	public role Mountain {}

	public role MountainType {
		public Mountain createInstance();
	}
}

public class Mountain binds Mountain_MountainType.Mountain {}

public class MountainType binds Mountain_MountainType.MountainType {
	public Mountain createInstance() {
		Mountain_MountainType.MountainType.createInstance();
	}
}



// Collaboration of Mountain and MountainManager
public collaboration Mountain_MountainManager {
	public role Mountain {}

	public role MountainManager {
		public Mountain createMountain(String typeName);
	}
}

public class Mountain binds Mountain_MountainManager.Mountain {}

public class MountainManager extends ObjectManager binds Mountain_MountainManager.MountainManager {
	public Mountain createMountain(String typeName) {
		return Mountain_MountainManager.MountainManager.createMountain(typeName);
	}
}


``` 