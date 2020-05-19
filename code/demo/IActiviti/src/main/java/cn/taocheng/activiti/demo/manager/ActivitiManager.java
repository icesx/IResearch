/**
 * Program  : ActivitiManager.java<br/>
 * Author   : i<br/>
 * Create   : 18 May 2020 10:38:45<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActivitiManager implements IActivitiManager {
	private static final Logger logger = LoggerFactory.getLogger(ActivitiManager.class);

	private static ActivitiManager instance;

	private ActivitiManager() {
		logger.info("init " + this.getClass());

	}

	public static synchronized IActivitiManager instance() {
		return instance = (instance == null) ? new ActivitiManager() : instance;
	}

	@Override
	public IProcessDefine registProcess(String classpath) {
		return new ProcessDefine(classpath);
	}

}
