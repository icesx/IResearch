package cn.i.xportal.jdp.bridge;

public abstract class Abstraction {
	protected Implementor imp;

	public Abstraction(Implementor implementor) {
		imp=implementor;
	}

	public abstract String operation();
}
