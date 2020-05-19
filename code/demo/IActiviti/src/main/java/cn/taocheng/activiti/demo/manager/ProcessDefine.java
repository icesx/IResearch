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

import cn.taocheng.activiti.demo.bean.Assginee;
import cn.taocheng.activiti.demo.bean.ProcessInstanceInfo;
import cn.taocheng.activiti.demo.dao.ITaskActionDao;
import cn.taocheng.activiti.demo.process.IProcess;
import cn.taocheng.activiti.demo.process.ProcessInstance;
import cn.taocheng.activiti.demo.service.IActivitiService;
import cn.taocheng.activiti.demo.task.ActionParams;

class ProcessDefine implements IProcessDefine {

	private static final Logger logger = LoggerFactory.getLogger(ProcessDefine.class);

	private String bpmn;

	private IActivitiService activitiService;

	private ITaskActionDao taskActionDao;
 
	ProcessDefine(String classpath, IActivitiService activitiService, ITaskActionDao dao) {
		this.taskActionDao = dao;
		this.bpmn = classpath;
		logger.info("create ProcessDefine with {}", this.bpmn);
		this.activitiService = activitiService;
		activitiService.deploy(this.bpmn);
		this.load();
	}

	private void load() {
		//TODO 
	}

	@Override
	public IProcess startProcess(String processDefineId, ActionParams params, Assginee assginee) {
		params.put(START_ASSIGNEE, assginee.getName());
		ProcessInstanceInfo pi = activitiService.startProcess(processDefineId, params.params());
		return new ProcessInstance(pi, activitiService,taskActionDao);
	}

	@Override
	public IProcess getProcess(String processInstanceId) {
		// TODO Auto-generated method stub
		return null;
	}

}
