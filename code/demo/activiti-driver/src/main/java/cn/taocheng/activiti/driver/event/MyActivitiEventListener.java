/**
 * Program  : BaseEvent.java<br/>
 * Author   : i<br/>
 * Create   : 14 May 2020 22:38:44<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.event;

import org.activiti.engine.delegate.event.ActivitiEntityEvent;
import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.engine.delegate.event.impl.ActivitiEntityEventImpl;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.taocheng.activiti.driver.bean.EventInfo;

public class MyActivitiEventListener implements ActivitiEventListener {
	private static final Logger logger = LoggerFactory.getLogger(MyActivitiEventListener.class);

	private static MyActivitiEventListener instance;

	private ICustomEventHandler handler;

	private MyActivitiEventListener(ICustomEventHandler handler) {
		logger.info("init " + this.getClass());
		logger.info("registHandle handler={}", handler);
		this.handler = handler;
	}

	public static synchronized MyActivitiEventListener instance(ICustomEventHandler handler) {
		return instance = (instance == null) ? new MyActivitiEventListener(handler) : instance;
	}
	public static synchronized MyActivitiEventListener instance() {
		return instance = (instance == null) ? new MyActivitiEventListener(new TaskActionEventHandler()) : instance;
	}
	@Override
	public void onEvent(ActivitiEvent event) {
		EventInfo eventInfo = new EventInfo(event);
		logger.debug("onEvent for processInstance={}", event.getProcessDefinitionId());
		switch (event.getType()) {
		case JOB_EXECUTION_SUCCESS:
			handler.jobExecutionSuccess(eventInfo);
			break;

		case JOB_EXECUTION_FAILURE:
			handler.jobExecutionFailure(eventInfo);
			break;
		case TASK_CREATED:
			handler.taskCreated(event, taskEntry(event));
			break;
		case TASK_COMPLETED:
			handler.taskCompleted(event, taskEntry(event));
			break;
		case TASK_ASSIGNED:
			handler.taskAssigned(event, taskEntry(event));
			break;
		case PROCESS_STARTED:
			handler.processStarted((ActivitiEntityEvent) event);
			break;
		case PROCESS_CANCELLED:
			handler.processCancelled((ActivitiEntityEvent) event);
			break;
		case PROCESS_COMPLETED:
			handler.processCompleted((ActivitiEntityEvent) event);
			break;
		default:
			handler.otherEvent(eventInfo);
		}
	}

	private TaskEntity taskEntry(ActivitiEvent event) {
		ActivitiEntityEventImpl evt = (ActivitiEntityEventImpl) event;
		TaskEntity entity = (TaskEntity) evt.getEntity();
		return entity;
	}

	@Override
	public boolean isFailOnException() {
		logger.warn("isFailOnException return false.");
		return false;
	}
}
