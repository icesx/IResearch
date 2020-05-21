/**
 * Program  : INodeService.java<br/>
 * Author   : i<br/>
 * Create   : 14 May 2020 23:20:12<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.core.manager;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.taocheng.activiti.driver.core.bean.Assginee;
import cn.taocheng.activiti.driver.core.bean.TaskInfo;
import cn.taocheng.activiti.driver.core.service.IActivitiService;
import cn.taocheng.activiti.driver.core.utils.ActionParams;
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
	 * to complate current task
	 * 
	 * @param params
	 *            that will send to activiti engine
	 */
	public final void complate(ActionParams params) {
		activitiService.completeTask(taskInfo.getTaskId(), params.params());
	}

	/**
	 * to complate current task
	 */
	public final void complate() {
		activitiService.completeTask(taskInfo.getTaskId());
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
		logger.info("to do some thing when task complate.");
	}

	/**
	 * will been call by activit driver when current task create event occure.
	 */
	protected void onCreate() {
		logger.info("to do some thing when task create.");
	}

	/**
	 * provide the assginee when this task oncreated.
	 * 
	 * @param taskInfo
	 * @return
	 */
	public abstract Assginee provideAssginee(TaskInfo taskInfo);

	protected final TaskInfo getTaskInfo() {
		return this.taskInfo;
	}

	protected final void setVariable(String variableName, Map<String, Object> variable) {
		this.activitiService.setVariable(this.taskInfo.getTaskId(), variableName, variable);
	}

	public abstract String taskDefineId();

	public abstract View view();

	@Override
	public String toString() {
		return "AbsTaskAction [taskInfo=" + taskInfo + "class=" + this.getClass().getName() + "]";
	}

	public void assginee(String assginee) {
		this.activitiService.claimTask(this.taskInfo.getTaskId(), assginee);
		logger.info("assginee task={} to assginee={}", this.taskInfo.getTaskId(), assginee);
	}

	public String explain() {
		return "no explain";
	}

}
