/**
 * Program  : INodeService.java<br/>
 * Author   : i<br/>
 * Create   : 14 May 2020 23:20:12<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.core.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.taocheng.activiti.driver.core.bean.Assginee;
import cn.taocheng.activiti.driver.core.bean.TaskInfo;
import cn.taocheng.activiti.driver.core.service.IActivitiService;
import cn.taocheng.activiti.driver.core.utils.ActionVariable;
import cn.taocheng.activiti.driver.core.web.View;

public abstract class BaseTaskAction {
	private static final Logger logger = LoggerFactory.getLogger(BaseTaskAction.class);

	@Autowired
	private IActivitiService activitiService;

	/**
	 * current usertask for this taskAction
	 */
	private TaskInfo taskInfo;

	public BaseTaskAction(TaskInfo taskInfo) {
		this.taskInfo = taskInfo;
	}

	/**
	 * to set current task to this assginee
	 * 
	 * @param assginee
	 */
	public void setAssginee(String assginee) {
		this.taskInfo = this.activitiService.setAssginee(this.taskInfo.getTaskId(), assginee);
		logger.info("setAssginee is {}", this.taskInfo);
	}

	/**
	 * to complate current task
	 */
	public final void complate() {
		activitiService.completeTask(taskInfo.getTaskId());
		logger.info("complateTask {}", this.taskInfo);
	}

	/**
	 * to complate current task
	 * 
	 * @param variables
	 *            that will send to activiti engine
	 */
	public final void complate(ActionVariable variables) {
		activitiService.completeTask(taskInfo.getTaskId(), variables.varables());
		logger.info("complateTask {} with variables {}", this.taskInfo, variables);
	}

	/**
	 * return explain info
	 * 
	 * @return
	 */
	public String explain() {
		return "no explain";
	}

	protected final TaskInfo getTaskInfo() {
		return this.taskInfo;
	}

	/**
	 * get variable from activit engine
	 * 
	 * @param variableName
	 *            the variable's name from activit engine
	 * @return
	 */
	protected final Object getVariable(String variableName) {
		return this.activitiService.getVariable(this.taskInfo.getTaskId(), variableName);
	}

	/**
	 * will been call by activit driver when current task complate event occure.
	 */
	protected void onComplate() {
		logger.info("to do some thing when task complate,task={} ", this.taskInfo);
	}

	/**
	 * will been call by activit driver when current task create event occure.
	 */
	protected void onCreate() {
		logger.info("to do some thing when task create,task={}", this.taskInfo);
	}

	/**
	 * provide the assginee when this task oncreated.
	 * 
	 * @param taskInfo
	 * @return
	 */
	public abstract Assginee provideAssginee(TaskInfo taskInfo);

	/**
	 * set variable to activiti engine
	 * 
	 * @param variableName
	 * @param variable
	 */
	protected final void setVariable(String variableName, ActionVariable variable) {
		this.taskInfo = this.activitiService.setVariable(this.taskInfo.getTaskId(), variableName, variable.varables());
		logger.info("setVariable for task {} variable={}", this.taskInfo, variable);
	}

	@Override
	public String toString() {
		return "AbsTaskAction [taskInfo=" + taskInfo + "class=" + this.getClass().getName() + "]";
	}

	/**
	 * @return
	 */
	public abstract View view();

}
