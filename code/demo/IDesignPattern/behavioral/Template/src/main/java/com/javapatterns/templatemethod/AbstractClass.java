package com.javapatterns.templatemethod;

import org.apache.log4j.Logger;

public abstract class AbstractClass {
	private static Logger logger = Logger.getLogger(AbstractClass.class);

	public void templateMethod() {
		doOperation1();

		doOperation2();

		doOperation3();
	}

	protected abstract void doOperation1();

	protected abstract void doOperation2();

	private final void doOperation3() {
		logger.info("doOperation3");
	}
}
