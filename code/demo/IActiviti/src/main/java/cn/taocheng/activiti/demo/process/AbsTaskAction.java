/**
 * Program  : INodeService.java<br/>
 * Author   : i<br/>
 * Create   : 14 May 2020 23:20:12<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.process;

import java.util.Map;

import cn.taocheng.activiti.demo.manager.Assginee;
import cn.taocheng.activiti.demo.modle.TaskInfo;
import cn.taocheng.activiti.demo.service.IActivitiService;
import cn.taocheng.activiti.demo.task.ActionParams;
import cn.taocheng.activiti.demo.task.View;

public abstract class AbsTaskAction {
	private IActivitiService activitiService;

	private TaskInfo taskInfo;

	public AbsTaskAction() {
	}

	public final void complate(ActionParams params) {
		activitiService.completeTask(taskInfo.getTaskId());
	}

	protected final Object getVariable(String variableName) {
		return this.activitiService.getVariable(this.taskInfo.getTaskId(), variableName);
	}

	protected void onComplate() {

	}

	protected void onCreate() {
	}

	public abstract Assginee provideAssginee(TaskInfo taskInfo);

	protected final void setActiviti(IActivitiService activitiService) {
		this.activitiService = activitiService;
	}

	protected final void setTaskInfo(TaskInfo taskInfo) {
		this.taskInfo = taskInfo;
	}

	protected final void setVariable(String variableName, Map<String, Object> variable) {
		this.activitiService.setVariable(this.taskInfo.getTaskId(), variableName, variable);
	}

	public abstract String taskDefineId();

	public abstract View view();

}