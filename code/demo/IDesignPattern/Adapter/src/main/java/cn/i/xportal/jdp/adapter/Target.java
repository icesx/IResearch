package cn.i.xportal.jdp.adapter;

public interface Target {
	/** Class Adaptee contains operation sampleOperation1. */
	String sampleOperation1();

	/** Class Adaptee doesn't contain operation sampleOperation2. */
	String sampleOperation2();
}
