/**
 * Program  : Process.java<br/>
 * Author   : i<br/>
 * Create   : 19 May 2020 09:46:44<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.core.manager;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.taocheng.activiti.driver.core.bean.Assginee;
import cn.taocheng.activiti.driver.core.bean.ProcessInstanceInfo;
import cn.taocheng.activiti.driver.core.bean.TaskInfo;

class ProcessOperator implements IProcessOperator {

	private static final Logger logger = LoggerFactory.getLogger(ProcessOperator.class);

	private static ProcessOperatorCentor ppo = ProcessOperatorCentor.instance();

	@Override
	public ProcessInstanceInfo getProcessInstanceInfo() {
		return processInstanceInfo;
	}

	public String toString() {
		return "ProcessOperator [processInstanceInfo=" + processInstanceInfo + ", hashCode()=" + hashCode() + "]";
	}

	private ProcessOperator(ProcessInstanceInfo pi) {
		this.processInstanceInfo = pi;
		logger.info("create Process with {}", this.processInstanceInfo);
	}

	public static ProcessOperator newInstance(ProcessInstanceInfo pi) {
		ProcessOperator processOperator = new ProcessOperator(pi);
		ppo.load(pi);
		return processOperator;
	}

	private ProcessInstanceInfo processInstanceInfo;

	@Override
	public List<BaseTaskAction> listTaskAction() {
		return ppo.listTaskAction(processInstanceInfo);
	}

	@Override
	public <T extends BaseTaskAction> void registTaskAction(String defineTaskId, Class<T> clazz) {
		ppo.registTaskAction(defineTaskId, clazz);
	}

	@Override
	public List<BaseTaskAction> currentTaskAction(Assginee assignee) {
		return ppo.currentTaskAction(processInstanceInfo, assignee);
	}

	@Override
	public BaseTaskAction findTaskAction(TaskInfo taskInfo) {
		return ppo.findTaskAction(taskInfo);
	}

}
