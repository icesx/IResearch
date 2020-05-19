/**
 * Program  : FlowManager.java<br/>
 * Author   : i<br/>
 * Create   : 15 May 2020 08:26:22<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.taocheng.activiti.demo.modle.ProcessInstanceInfo;
import cn.taocheng.activiti.demo.process.IProcess;
import cn.taocheng.activiti.demo.process.ProcessInstance;
import cn.taocheng.activiti.demo.service.IActivitiService;
import cn.taocheng.activiti.demo.task.ActionParams;

@Component
class ProcessDefine implements IProcessDefine {

	private static final Logger logger = LoggerFactory.getLogger(ProcessDefine.class);

	private static ProcessDefine instance;

	public static synchronized ProcessDefine instance() {
		return instance = (instance == null) ? new ProcessDefine() : instance;
	}

	private String bpmn;

	@Autowired
	private IActivitiService activitiService;

	private ProcessDefine() {
		logger.info("init " + this.getClass());
	}

	public ProcessDefine(String classpath) {
		this.bpmn = classpath;
		logger.info("create processManager with {}", this.bpmn);
	}

	@Override
	public IProcess startProcess(String processDefineId, ActionParams params, Assginee assginee) {
		params.put(START_ASSIGNEE, assginee.getName());
		ProcessInstanceInfo pi = activitiService.startProcess(processDefineId, params.params());
		return new ProcessInstance(pi);
	}

	@Override
	public IProcess getProcess(String processInstanceId) {
		// TODO Auto-generated method stub
		return null;
	}

}
