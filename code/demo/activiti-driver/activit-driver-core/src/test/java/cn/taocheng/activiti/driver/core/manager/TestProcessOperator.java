/**
 * Program  : TestProcessOperator.java<br/>
 * Author   : i<br/>
 * Create   : 20 May 2020 14:44:11<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.core.manager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.taocheng.activiti.driver.core.manager.IActivitiManager;
import cn.taocheng.activiti.driver.core.manager.IProcessOperator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProcessOperator {
	private static final Logger logger = LoggerFactory.getLogger(TestProcessOperator.class);

	@Autowired
	private IActivitiManager activitiManager;

	private IProcessOperator getProcess() {
		return activitiManager.getProcess("97505");
	}

	@Test
	public void listTaskAction() {
		getProcess().listTaskAction().stream().forEach(task -> logger.info(task.toString()));
	}
}
