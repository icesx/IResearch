/**
 * Program  : FlowManager.java<br/>
 * Author   : i<br/>
 * Create   : 15 May 2020 08:26:22<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.manager;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

import cn.taocheng.activiti.driver.bean.Assginee;
import cn.taocheng.activiti.driver.bean.ProcessInstanceInfo;
import cn.taocheng.activiti.driver.process.IProcess;
import cn.taocheng.activiti.driver.process.ProcessInstance;
import cn.taocheng.activiti.driver.service.IActivitiService;
import cn.taocheng.activiti.driver.utils.ActionParams;

class ProcessDefine implements IProcessDefine {

	private static final Logger logger = LoggerFactory.getLogger(ProcessDefine.class);

	private String bpmn;

	@Autowired
	private IActivitiService activitiService;

	@Autowired
	private AutowireCapableBeanFactory beanFactory;

	ProcessDefine(String classpath) {
		this.bpmn = classpath;
		logger.info("create ProcessDefine with {}", this.bpmn);
		this.load();
	}

	@PostConstruct
	private void init() {
		activitiService.deploy(this.bpmn);
	}

	private void load() {
		// TODO
	}

	@Override
	public IProcess startProcess(String processDefineId, ActionParams params, Assginee assginee) {
		params.put(START_ASSIGNEE, assginee.getName());
		ProcessInstanceInfo pi = activitiService.startProcess(processDefineId, params.params());
		ProcessInstance processInstance = new ProcessInstance(pi);
		beanFactory.autowireBean(processInstance);
		return processInstance;
	}

	@Override
	public IProcess getProcess(String processInstanceId) {
		// TODO Auto-generated method stub
		return null;
	}

}
