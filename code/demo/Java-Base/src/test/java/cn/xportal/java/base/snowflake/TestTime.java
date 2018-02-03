/**
 * Program  : TestTime.java<br/>
 * Author   : i<br/>
 * Create   : Dec 27, 2017 8:36:39 AM<br/>
 *
 * Copyright 1997-2013 by 0dog.cn ltd.,
 * All rights reserved.
 */
package cn.xportal.java.base.snowflake;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.text.NumberFormat;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestTime {
	private static Logger logger = Logger.getLogger(TestTime.class);

	@Test
	public void test41TimeLenght() {
		long tl = (long) Math.pow(2D, 43D);
		logger.info(tl + "=" + tl / 1000 / 60 / 60 / 24 / 365);
		NumberFormat nf = NumberFormat.getInstance();
		nf.setGroupingUsed(false);
		logger.info(nf.format(Long.MAX_VALUE));
		logger.info(nf.format(Float.MAX_VALUE));
		logger.info(nf.format(Float.MAX_VALUE - 10000));
		logger.info(nf.format(Double.MAX_VALUE));
	}

	@Test
	public void testUUID() {
		for (int i = 0; i < 1000000; i++) {
			generateUniqueId();
		}
	}

	private float generateUniqueId() {
		long val = -1;
		do {
			final UUID uid = UUID.randomUUID();
			val=uid.getMostSignificantBits();
			
		}
		// We also make sure that the ID is in positive space, if its not we simply
		// repeat the process
		while (val < 0);
		return val;
	}
}
