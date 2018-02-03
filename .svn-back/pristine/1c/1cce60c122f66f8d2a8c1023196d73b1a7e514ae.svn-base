package com.javapatterns.builder;

import org.apache.log4j.Logger;

public class ConcreteBuilder extends Builder {
	private Product product = new Product() {
	};
	private static Logger logger = Logger.getLogger(ConcreteBuilder.class);

	public void buildPartHead() {
		logger.info("buildPartHead");
	}

	public void buildPartTail() {
		logger.info("buildPartTail");
	}

	public Product retrieveResult() {
		return product;
	}
}
