package cn.i.xportal.jdp.singleton.demos;

import java.util.HashMap;

public class RegSingleton {
	private static HashMap mRegistry = new HashMap();

	static {
		RegSingleton x = new RegSingleton();
		mRegistry.put(x.getClass().getName(), x);
	}

	protected RegSingleton() {
	}

	public static RegSingleton getInstance(String aName) {
		String name = aName;
		if (name == null) {
			name = "com.javapatterns.singleton.demos.RegSingleton";
		}

		System.out.println("From RegSingleton: requesting for " + name);

		if (mRegistry.get(name) == null) {
			try {
				mRegistry.put(name, Class.forName(name).newInstance());
			} catch (ClassNotFoundException e) {
				System.out.println("Class " + name + " is not found.");
			} catch (InstantiationException e) {
				System.out.println("Class " + name + " can not be instantiated.");
			} catch (IllegalAccessException e) {
				System.out.println("Class " + name + " can not be accessed.");
			}
		}
		return (RegSingleton) (mRegistry.get(name));
	}

	public String about() {
		return "Hello, I am RegSingleton.";
	}

}
