/**
 * Program  : DefaultActivitiEventHandler.java<br/>
 * Author   : i<br/>
 * Create   : 14 May 2020 23:12:39<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.service.event;

import org.activiti.engine.delegate.event.ActivitiEntityEvent;
import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.taocheng.activiti.demo.modle.EventInfo;

public class DefaultActivitiEventHandler implements IActivitiEventHandler {
	private static final Logger logger = LoggerFactory.getLogger(DefaultActivitiEventHandler.class);

	@Override
	public void jobExecutionSuccess(EventInfo eventInfo) {
		logger.info(eventInfo.toString());
	}

	@Override
	public void jobExecutionFailure(EventInfo eventInfo) {
		logger.info(eventInfo.toString());

	}

	@Override
	public void processStarted(ActivitiEntityEvent eventInfo) {
		logger.info(eventInfo.toString());

	}

	@Override
	public void processCompleted(ActivitiEntityEvent eventInfo) {
		logger.info(eventInfo.toString());

	}

	@Override
	public void processCancelled(ActivitiEntityEvent eventInfo) {
		logger.info(eventInfo.toString());

	}

	@Override
	public void otherEvent(EventInfo eventInfo) {
		logger.info(eventInfo.toString());

	}

	@Override
	public boolean isFailOnException() {
		logger.warn("isFailOnException return false.");
		return false;
	}

	@Override
	public void taskAssigned(ActivitiEvent event, TaskEntity entry) {
		logger.info("task assigned on entry {} ", entry);
	}

	@Override
	public void taskCompleted(ActivitiEvent event, TaskEntity entry) {
		logger.info("taskCompleted on entry {} ", entry);
	}

	@Override
	public void taskCreated(ActivitiEvent event, TaskEntity entry) {
		logger.info("taskCreated on entry {} ", entry);
	}

}
