/**
 * Program  : DefaultActivitiEventHandler.java<br/>
 * Author   : i<br/>
 * Create   : 14 May 2020 23:12:39<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.core.event;

import org.activiti.engine.delegate.event.ActivitiEntityEvent;
import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.taocheng.activiti.driver.core.bean.EventInfo;

public class DefaultCustomEventHandler implements ICustomEventHandler {
	private static final Logger logger = LoggerFactory.getLogger(DefaultCustomEventHandler.class);

	@Override
	public void jobExecutionSuccess(EventInfo eventInfo) {
		logger.debug(eventInfo.toString());
	}

	@Override
	public void jobExecutionFailure(EventInfo eventInfo) {
		logger.debug(eventInfo.toString());

	}

	@Override
	public void processStarted(ActivitiEntityEvent eventInfo) {
		logger.debug(eventInfo.toString());

	}

	@Override
	public void processCompleted(ActivitiEntityEvent eventInfo) {
		logger.debug(eventInfo.toString());

	}

	@Override
	public void processCancelled(ActivitiEntityEvent eventInfo) {
		logger.debug(eventInfo.toString());

	}

	@Override
	public void otherEvent(EventInfo eventInfo) {
		logger.debug(eventInfo.toString());

	}

	@Override
	public void taskAssigned(ActivitiEvent event, TaskEntity entry) {
		logger.debug("task assigned on entry {} with event{}", entry,event);
	}

	@Override
	public void taskCompleted(ActivitiEvent event, TaskEntity entry) {
		logger.debug("taskCompleted on entry {} with event {} ", entry, event);
	}

	@Override
	public void taskCreated(ActivitiEvent event, TaskEntity entry) {
		logger.debug("taskCreated on entry {} with event {}", entry, event);
	}

}
