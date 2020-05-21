/**
 * Program  : TaskActionEventHandler.java<br/>
 * Author   : i<br/>
 * Create   : 15 May 2020 17:51:57<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.core.event;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.impl.persistence.entity.TaskEntity;

import cn.taocheng.activiti.driver.core.manager.IProcessEventHandler;
import cn.taocheng.activiti.driver.core.manager.ProcessOperatorCentor;

public class TaskActionEventHandler extends DefaultCustomEventHandler {

	private static IProcessEventHandler process = ProcessOperatorCentor.instance();

	public TaskActionEventHandler() {
	}

	@Override
	public void taskCompleted(ActivitiEvent event, TaskEntity entry) {
		super.taskCompleted(event, entry);
		process.onComplateTask(entry);
	}

	@Override
	public void taskCreated(ActivitiEvent event, TaskEntity entry) {
		super.taskCreated(event, entry);
		process.onCreatedTask(entry);
	}

}
