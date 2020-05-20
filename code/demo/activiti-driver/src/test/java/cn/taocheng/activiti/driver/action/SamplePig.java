/**
 * Program  : FlowManagerTest.java<br/>
 * Author   : i<br/>
 * Create   : 16 May 2020 20:57:11<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.action;

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
import cn.taocheng.activiti.driver.manager.AbsTaskAction;
import cn.taocheng.activiti.driver.manager.IActivitiManager;
import cn.taocheng.activiti.driver.manager.IProcessOperator;
import cn.taocheng.activiti.driver.utils.ActionParams;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SamplePig {
	private static final Logger logger = LoggerFactory.getLogger(SamplePig.class);

	@Autowired
	private IActivitiManager activitiManager;

	@PostConstruct
	public void init() {
		activitiManager.deployProcess("processes/pig.bpmn");
	}

	@Test
	public void pigTaskAction() throws ActionException {

		Assginee farm001 = Assginee.fowName("farm-001");
		ActionParams empt = ActionParams.empty().put("v1", "001").put("v2", "002").put("temp", "farm");
		IProcessOperator pi = activitiManager.startProcess("pigone", empt, farm001);
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

	@Test
	public void listTaskAction() {
		IProcessOperator po = activitiManager.getProcess("97505");
		List<AbsTaskAction> tasks = po.listTaskAction();
		for (AbsTaskAction absTaskAction : tasks) {
			logger.info(absTaskAction.toString());
			absTaskAction.assginee("zhangsan");
		}
	}

	@Test
	public void mineTaskAction() {
		IProcessOperator po = activitiManager.getProcess("97505");
		List<AbsTaskAction> task = po.currentTaskAction(Assginee.fowName("zhangsan"));
		for (AbsTaskAction absTaskAction : task) {
			logger.info(absTaskAction.toString());
		}
	}

	@Test
	public void currentTaskAction() throws ActionException {
		Assginee farm001 = Assginee.fowName("farm-001");
		IProcessOperator process = activitiManager.getProcess("27501");
		List<AbsTaskAction> ta = process.currentTaskAction(farm001);
		ActionParams empt = ActionParams.empty().put("v1", "001").put("v2", "002").put("temp", "farm");
		for (AbsTaskAction absTaskAction : ta) {
			logger.info("current task is {} ", ta);
			absTaskAction.complate(empt);
		}
	}
}
