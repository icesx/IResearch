package cn.i.xportal.jdp.singleton.answers;

/**
 * Only once instance of the class may be created during the execution of any given program. Instances of this class should
 * be aquired through the getInstance() method. Notice that there are no public constructors for this class.
 */

import java.util.Date;

public class LazySingleton1 {
	private static LazySingleton1 instance = null;

	// These fields help us see whether one or
	// more Singletons were created. There is usually
	// no need for them in a Singleton.
	private int instanceNumber;
	private Date creationDate;

	// Counts instantiations. Should always be 0 or 1
	private static int numberOfInstances;

	private LazySingleton1() {
		instanceNumber = ++numberOfInstances;
		creationDate = new Date();
	}

	public static LazySingleton1 getInstance() {
		if (instance == null) {
			synchronized (LazySingleton1.class) {
				if (instance == null) {
					instance = new LazySingleton1();
				}
			}
		}
		return instance;
	}

	public String aboutMe() {
		return "Hi, I'm an instance of LazySingleton1.\n" + "My classloader is " + getClass().getClassLoader() + ".\n"
				+ "My identity hash code " + System.identityHashCode(this) + "\n"
				+ "So far, since the class was loaded, " + numberOfInstances + " instance"
				+ (numberOfInstances == 1 ? "" : "s") + " of this Singleton class "
				+ (numberOfInstances == 1 ? "has" : "have") + " been created.\nI'm instance number " + instanceNumber
				+ ".\n" + "I was created at " + creationDate + "\n"
				+ "If there's really only one instance of my class, "
				+ "these items will be constant for all instances of LazySingleton1.";
	}
}
