/**
 * Program  : BuilderTest.java<br/>
 * Author   : i<br/>
 * Create   : Mar 28, 2017 3:48:43 PM<br/>
 *
 * Copyright 1997-2013 by III.cn ltd.,
 * All rights reserved.
 */
package cn.i.xportal.jdp.builder;

import org.apache.log4j.Logger;

import com.javapatterns.builder.Builder;
import com.javapatterns.builder.ConcreteBuilder;
import com.javapatterns.builder.Director;

public class BuilderTest {
	private static Logger logger = Logger.getLogger(BuilderTest.class);

	public static void main(String[] args) {
		Builder builder=new ConcreteBuilder();
		Director director = new Director(builder);
		logger.info(director.construct());
	}
}
