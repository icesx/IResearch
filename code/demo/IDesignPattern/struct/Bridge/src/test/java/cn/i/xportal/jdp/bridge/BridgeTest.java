/**
 * Program  : BridgeTest.java<br/>
 * Author   : i<br/>
 * Create   : Mar 28, 2017 3:16:44 PM<br/>
 *
 * Copyright 1997-2013 by III.cn ltd.,
 * All rights reserved.
 */
package cn.i.xportal.jdp.bridge;

import org.apache.log4j.Logger;

public class BridgeTest {
	private static Logger logger = Logger.getLogger(BridgeTest.class);

	public static void main(String[] args) {
		logger.info(new RefinedAbstraction(new ConcreteImplementorA()).operation());
		logger.info(new RefinedAbstraction(new ConcreteImplementorB()).operation());
	}
}
