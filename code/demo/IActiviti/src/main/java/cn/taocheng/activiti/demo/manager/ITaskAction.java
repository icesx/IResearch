/**
 * Program  : INodeService.java<br/>
 * Author   : i<br/>
 * Create   : 14 May 2020 23:20:12<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.manager;

import cn.taocheng.activiti.demo.modle.TaskInfo;
import cn.taocheng.activiti.demo.service.IActivitiService;
import cn.taocheng.activiti.demo.task.ActionParams;
import cn.taocheng.activiti.demo.task.ITaskActionEvent;
import cn.taocheng.activiti.demo.task.View;

public abstract class ITaskAction {
	public ITaskAction() {
	}

	private IActivitiService activitiService;

	private TaskInfo taskInfo;

	public abstract View view();

	public final void complate(ActionParams params) {
		activitiService.completeTask(taskInfo.getTaskId());
	}

	public abstract Assginee onAssginee(TaskInfo taskInfo);

	public abstract ITaskActionEvent event();

	/**
	 * @return taskId from bpmn's <userTask/>
	 */
	public abstract String taskDefineId();

	final void setActiviti(IActivitiService activitiService) {
		this.activitiService = activitiService;
	}

	final void setTaskInfo(TaskInfo taskInfo) {
		this.taskInfo = taskInfo;
	}

}
