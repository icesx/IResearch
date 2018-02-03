/**
 * Program  : BuilderConstract.java<br/>
 * Author   : i<br/>
 * Create   : Mar 28, 2017 5:22:05 PM<br/>
 *
 * Copyright 1997-2013 by III.cn ltd.,
 * All rights reserved.
 */
package cn.i.xportal.jdp.builder;

import org.apache.log4j.Logger;

import com.javapatterns.builder.constract.Person;

public class BuilderConstract {
	private static Logger logger = Logger.getLogger(BuilderConstract.class);

	public static void main(String[] args) {
		logger.info(Person.builder().name("choudan").city("beijing").sex("man").eage("8").build());
	}
}
