/**
 * Program  : AbstractFactoryTest.java<br/>
 * Author   : i<br/>
 * Create   : Mar 28, 2017 12:08:45 PM<br/>
 *
 * Copyright 1997-2013 by III.cn ltd.,
 * All rights reserved.
 */
package cn.i.xportal.jdp.abstractfactory;

import org.apache.log4j.Logger;

import cn.i.xportal.jdp.abstractfactory.exercise.ComputerProducer;
import cn.i.xportal.jdp.abstractfactory.exercise.PcProducer;

public class AbstractFactoryTest {
	private static Logger logger = Logger.getLogger(AbstractFactoryTest.class);

	public static void main(String[] args) {
		PcProducer pcProducer = (PcProducer) ComputerProducer.getProducer("PC");
		logger.info(pcProducer.createCpu());
	}
}
