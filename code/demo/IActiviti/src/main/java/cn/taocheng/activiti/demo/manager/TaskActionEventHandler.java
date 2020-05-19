/**
 * Program  : TaskActionEventHandler.java<br/>
 * Author   : i<br/>
 * Create   : 15 May 2020 17:51:57<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.manager;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.core.joran.spi.ActionException;
import cn.taocheng.activiti.demo.process.IProcess;
import cn.taocheng.activiti.demo.service.event.DefaultActivitiEventHandler;

public class TaskActionEventHandler extends DefaultActivitiEventHandler {
	private static final Logger logger = LoggerFactory.getLogger(TaskActionEventHandler.class);

	private IProcessDefine processDefine;

	@Override
	public void taskCreated(ActivitiEvent event, TaskEntity entry) {
		try {
			getProcess(entry).onCreatedTask(entry);
		} catch (ActionException e) {
			logger.error(e.getLocalizedMessage(), e);
		}
	}

	@Override
	public void taskCompleted(ActivitiEvent event, TaskEntity entry) {
		try {
			getProcess(entry).onComplateTask(entry);
		} catch (ActionException e) {
			logger.error(e.getLocalizedMessage(), e);
		}
	}

	private IProcess getProcess(TaskEntity entry) {
		return processDefine.getProcess(entry.getProcessInstanceId());
	}

	public TaskActionEventHandler() {
		processDefine = ProcessDefine.instance();
	}

}
