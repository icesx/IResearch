package cn.i.xportal.jdp.adapter.classadapter;

import cn.i.xportal.jdp.adapter.Target;

public class Adapter extends Adaptee implements Target {
	/** Class Adaptee doesn't contain operation sampleOperation2. */
	public String sampleOperation2() {
		return "adapter's sampleOperation";
	}
}
