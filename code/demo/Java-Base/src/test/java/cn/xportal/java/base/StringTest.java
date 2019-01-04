/**
 * Program  : StringTest.java<br/>
 * Author   : i<br/>
 * Create   : May 23, 2017 10:29:50 AM<br/>
 *
 * Copyright 1997-2013 by 0dog.cn ltd.,
 * All rights reserved.
 */
package cn.xportal.java.base;

import org.apache.log4j.Logger;
import org.junit.Test;

public class StringTest {
	private static Logger logger = Logger.getLogger(StringTest.class);

	@Test
	public void formart() {
		String fomart = "hello,%s";
		long time = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			String.format(fomart, "xxx");
		}
		logger.info("used " + (System.currentTimeMillis() - time));
		time = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			new StringBuilder().append("hello,").append("xxx");
		}
		logger.info("used " + (System.currentTimeMillis() - time));
	}

	@Test
	public void testCompare() {
		String[] strs = "1,11,123,123,4,中午,".split(",");
		String[] comp = "1,2,3".split(",");
		for (String string : strs) {
			for (String com : comp) {
				logger.info(string + " compare with " + com + " result is " + string.compareTo(com));
			}
		}
	}
}
