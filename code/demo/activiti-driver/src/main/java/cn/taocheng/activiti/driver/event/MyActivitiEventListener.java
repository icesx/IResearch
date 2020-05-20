/**
 * Program  : BaseEvent.java<br/>
 * Author   : i<br/>
 * Create   : 14 May 2020 22:38:44<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.event;

import java.util.HashMap;
import java.util.Map;

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

	private Map<String, ICustomEventHandler> myEvents = new HashMap<String, ICustomEventHandler>();

	private static MyActivitiEventListener instance;

	private MyActivitiEventListener() {
		logger.info("init " + this.getClass());
	}

	public void registHandle(String processInstanceId, ICustomEventHandler handle) {
		logger.info("registHandle for processInstanceId={},handler={}", processInstanceId, handle);
		this.myEvents.put(processInstanceId, handle);
	}

	public static synchronized MyActivitiEventListener instance() {
		return instance = (instance == null) ? new MyActivitiEventListener() : instance;
	}

	@Override
	public void onEvent(ActivitiEvent event) {
		EventInfo eventInfo = new EventInfo(event);
		ICustomEventHandler handler = this.myEvents.get(event.getProcessInstanceId());
		logger.info("onEvent for processInstance={}",event.getProcessInstanceId());
		if (handler != null) {
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
		} else {
			logger.warn("not regist event {} ", event);
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
