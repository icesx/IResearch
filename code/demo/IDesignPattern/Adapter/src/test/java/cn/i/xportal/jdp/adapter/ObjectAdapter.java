/**
 * Program  : ObjectAdapter.java<br/>
 * Author   : i<br/>
 * Create   : Mar 28, 2017 2:00:02 PM<br/>
 *
 * Copyright 1997-2013 by III.cn ltd.,
 * All rights reserved.
 */
package cn.i.xportal.jdp.adapter;

import org.apache.log4j.Logger;

import cn.i.xportal.jdp.adapter.classadapter.Adapter;

public class ObjectAdapter {
	private static Logger logger = Logger.getLogger(ObjectAdapter.class);

	public static void main(String[] args) {
		Target target = new Adapter();
		logger.info(target.sampleOperation1());
		logger.info(target.sampleOperation2());
	}
}
