/**
 * Program  : BuildExtendTest.java<br/>
 * Author   : i<br/>
 * Create   : Mar 28, 2017 3:58:56 PM<br/>
 *
 * Copyright 1997-2013 by III.cn ltd.,
 * All rights reserved.
 */
package cn.i.xportal.jdp.builder;

import org.apache.log4j.Logger;

import com.javapatterns.builder.Director;
import com.javapatterns.builder.Product;
import com.javapatterns.builder.extended.ConcreteBuilder1;
import com.javapatterns.builder.extended.ConcreteBuilder2;

public class BuildExtendTest {
	private static Logger logger = Logger.getLogger(BuildExtendTest.class);

	public static void main(String[] args) {
		Product product = new Director(new ConcreteBuilder1()).construct();
		logger.info(product);
		Product product2 = new Director(new ConcreteBuilder2()).construct();
		logger.info(product2);
	}
}
