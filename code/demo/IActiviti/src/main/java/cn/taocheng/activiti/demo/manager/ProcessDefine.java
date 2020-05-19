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
import org.springframework.stereotype.Component;

import cn.taocheng.activiti.demo.modle.ProcessInstanceInfo;
import cn.taocheng.activiti.demo.process.IProcess;
import cn.taocheng.activiti.demo.process.ProcessInstance;
import cn.taocheng.activiti.demo.service.IActivitiService;
import cn.taocheng.activiti.demo.task.ActionParams;

@Component
class ProcessDefine implements IProcessDefine {

	private static final Logger logger = LoggerFactory.getLogger(ProcessDefine.class);

	private String bpmn;

	private IActivitiService activitiService;

	ProcessDefine(String classpath, IActivitiService activitiService) {
		this.bpmn = classpath;
		logger.info("create ProcessDefine with {}", this.bpmn);
		this.activitiService = activitiService;
		activitiService.deploy(this.bpmn);
		this.load();
	}

	private void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IProcess startProcess(String processDefineId, ActionParams params, Assginee assginee) {
		params.put(START_ASSIGNEE, assginee.getName());
		ProcessInstanceInfo pi = activitiService.startProcess(processDefineId, params.params());
		return new ProcessInstance(pi,activitiService);
	}

	@Override
	public IProcess getProcess(String processInstanceId) {
		// TODO Auto-generated method stub
		return null;
	}

}
