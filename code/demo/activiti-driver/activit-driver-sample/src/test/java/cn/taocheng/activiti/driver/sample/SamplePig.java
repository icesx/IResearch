/**
 * Program  : FlowManagerTest.java<br/>
 * Author   : i<br/>
 * Create   : 16 May 2020 20:57:11<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.sample;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import ch.qos.logback.core.joran.spi.ActionException;
import cn.taocheng.activiti.driver.core.bean.Assginee;
import cn.taocheng.activiti.driver.core.manager.BaseTaskAction;
import cn.taocheng.activiti.driver.core.manager.IActivitiManager;
import cn.taocheng.activiti.driver.core.manager.IProcessOperator;
import cn.taocheng.activiti.driver.core.utils.ActionVariable;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("cn.taocheng.activiti.driver.sample.mapper")
@ComponentScan(basePackages = { "cn.taocheng.activiti.driver.core", "cn.taocheng.activiti.driver.sample" })

public class SamplePig {
	private static final Logger logger = LoggerFactory.getLogger(SamplePig.class);

	@Autowired
	private IActivitiManager activitiManager;

	@Test
	public void init() {
		activitiManager.deployProcess("processes/pig.bpmn");
	}

	@Test
	public void pigTaskAction() throws ActionException {

		Assginee farm001 = Assginee.fowName("farm-001");
		ActionVariable empt = ActionVariable.empty().put("v1", "001").put("v2", "002").put("temp", "farm");
		IProcessOperator pi = activitiManager.startProcess("pigone", empt, farm001);
		pi.registTaskAction("CLSQ", CLSQAction.class);
		pi.registTaskAction("SCJYBG", SCJYBGAction.class);
		pi.registTaskAction("XZCL", XZCLAction.class);
		logger.info("start process {}", pi);
		List<BaseTaskAction> ta = pi.currentTaskAction(Assginee.fowName("001"));
		for (BaseTaskAction task : ta) {
			logger.info("current task is {} ", task);
			task.complate(empt);
			logger.info(task.view().toString());
			logger.info(task.explain());
		}
	}

	@Test
	public void listTaskAction() {
		IProcessOperator po = activitiManager.getProcess("97505");
		List<BaseTaskAction> tasks = po.listTaskAction();
		for (BaseTaskAction absTaskAction : tasks) {
			logger.info(absTaskAction.toString());
			absTaskAction.setAssginee("zhangsan");
		}
	}

	@Test
	public void mineTaskAction() {
		IProcessOperator po = activitiManager.getProcess("97505");
		List<BaseTaskAction> task = po.currentTaskAction(Assginee.fowName("zhangsan"));
		for (BaseTaskAction absTaskAction : task) {
			logger.info(absTaskAction.toString());
		}
	}

	@Test
	public void currentTaskAction() throws ActionException {
		Assginee farm001 = Assginee.fowName("farm-001");
		IProcessOperator process = activitiManager.getProcess("27501");
		List<BaseTaskAction> ta = process.currentTaskAction(farm001);
		ActionVariable empt = ActionVariable.empty().put("v1", "001").put("v2", "002").put("temp", "farm");
		for (BaseTaskAction absTaskAction : ta) {
			logger.info("current task is {} ", ta);
			absTaskAction.complate(empt);
		}
	}
}
