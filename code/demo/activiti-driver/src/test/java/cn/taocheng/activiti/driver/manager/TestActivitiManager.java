/**
 * Program  : TestActivitiManager.java<br/>
 * Author   : i<br/>
 * Create   : 19 May 2020 18:28:12<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.manager;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

public class TestActivitiManager {
	@Autowired
	private IActivitiManager activitiManager;

	@PostConstruct
	private void init() {
		IProcessOperator process = activitiManager.getProcess("27501");
	}

}
