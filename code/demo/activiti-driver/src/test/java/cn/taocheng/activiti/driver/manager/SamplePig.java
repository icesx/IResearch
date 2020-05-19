/**
 * Program  : FlowManagerTest.java<br/>
 * Author   : i<br/>
 * Create   : 16 May 2020 20:57:11<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.manager;

import java.util.List;

import javax.annotation.PostConstruct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ch.qos.logback.core.joran.spi.ActionException;
import cn.taocheng.activiti.driver.bean.Assginee;
import cn.taocheng.activiti.driver.process.AbsTaskAction;
import cn.taocheng.activiti.driver.process.IProcess;
import cn.taocheng.activiti.driver.utils.ActionParams;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SamplePig {
	private static final Logger logger = LoggerFactory.getLogger(SamplePig.class);

	@Autowired
	private IActivitiManager activitiManager;

	private IProcessDefine pig;

	@PostConstruct
	public void init() {
		pig = activitiManager.registProcess("processes/pig.bpmn");
	}

	@Test
	public void registTaskAction() throws ActionException {

		Assginee farm001 = Assginee.fowName("farm-001");
		ActionParams empt = ActionParams.empty().put("v1", "001").put("v2", "002").put("temp", "farm");
		IProcess pi = pig.startProcess("pigone", empt, farm001);
		pi.registTaskAction("CLSQ", CLSQAction.class);
		pi.registTaskAction("SCJYBG", SCJYBGAction.class);
		pi.registTaskAction("XZCL", XZCLAction.class);
		logger.info("start process {}", pi);
		List<AbsTaskAction> ta = pi.currentTaskAction(farm001);
		for (AbsTaskAction absTaskAction : ta) {
			logger.info("current task is {} ", ta);
			absTaskAction.complate(empt);
		}

	}
}