package com.javapatterns.builder;

public class Director {
	private Builder builder;

	public Director(Builder builder) {
		this.builder = builder;
	}

	public Product construct() {
		builder.buildPartHead();
		builder.buildPartTail();

		return builder.retrieveResult();
	}
}
