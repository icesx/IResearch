package com.javapatterns.builder;

public abstract class Builder {
	public abstract void buildPartHead();

	public abstract void buildPartTail();

	public abstract Product retrieveResult();
}
