package cn.i.xportal.adapter.objectadapter;

import cn.i.xportal.adapter.Target;

public class Adapter implements Target {

	private Adaptee adaptee;

	public Adapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}

	public String sampleOperation1() {
		return  adaptee.sampleOperation1();
	}

	public String sampleOperation2() {
		return "adapter's sampleOperation2";
	}
}
