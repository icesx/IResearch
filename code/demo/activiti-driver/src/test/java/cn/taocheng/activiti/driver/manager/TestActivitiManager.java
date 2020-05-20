/**
 * Program  : TestActivitiManager.java<br/>
 * Author   : i<br/>
 * Create   : 19 May 2020 18:28:12<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.manager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestActivitiManager {
	private static final Logger logger = LoggerFactory.getLogger(TestActivitiManager.class);

	@Autowired
	private IActivitiManager activitiManager;

	@Test
	public void getProcess() {
		IProcessOperator process = activitiManager.getProcess("75005");
		logger.info(process.toString());
	}

}