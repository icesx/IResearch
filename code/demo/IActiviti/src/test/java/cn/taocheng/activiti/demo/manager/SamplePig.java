/**
 * Program  : FlowManagerTest.java<br/>
 * Author   : i<br/>
 * Create   : 16 May 2020 20:57:11<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.manager;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ch.qos.logback.core.joran.spi.ActionException;
import cn.taocheng.activiti.demo.process.IProcess;
import cn.taocheng.activiti.demo.process.AbsTaskAction;
import cn.taocheng.activiti.demo.task.ActionParams;

public class SamplePig {
	private static final Logger logger = LoggerFactory.getLogger(SamplePig.class);

	@Autowired
	private IActivitiManager ActivitiManager;

	private IProcessDefine pig = ActivitiManager.registProcess("processes/pig.bpmn");

	public void registTaskAction() throws ActionException {

		Assginee farm001 = Assginee.fowName("farm-001");
		ActionParams empt = ActionParams.empty().put("v1", "001").put("v2", "002");
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
