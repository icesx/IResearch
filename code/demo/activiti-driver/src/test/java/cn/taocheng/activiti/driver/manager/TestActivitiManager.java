/**
 * Program  : TestActivitiManager.java<br/>
 * Author   : i<br/>
 * Create   : 19 May 2020 18:28:12<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.manager;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.taocheng.activiti.driver.bean.Assginee;

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

	@Test
	public void getTaskAction() {
		List<AbsTaskAction> task = activitiManager.getTaskActionForAssginee(Assginee.fowName("zhangsan"));
		for (AbsTaskAction absTaskAction : task) {
			logger.info(absTaskAction.toString());
		}
	}
	@Test
	public void getProcessAction() {
		List<IProcessOperator> task = activitiManager.getProcesses(Assginee.fowName("zhangsan"));
		for (IProcessOperator absTaskAction : task) {
			logger.info(absTaskAction.toString());
		}
	}

}
