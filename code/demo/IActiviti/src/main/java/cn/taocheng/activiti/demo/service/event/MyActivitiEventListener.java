/**
 * Program  : BaseEvent.java<br/>
 * Author   : i<br/>
 * Create   : 14 May 2020 22:38:44<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.service.event;

import org.activiti.engine.delegate.event.ActivitiEntityEvent;
import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.engine.delegate.event.impl.ActivitiEntityEventImpl;
import org.activiti.engine.impl.persistence.entity.TaskEntity;

import cn.taocheng.activiti.demo.modle.EventInfo;

public class MyActivitiEventListener implements ActivitiEventListener {

	private IActivitiEventHandler myEvent;

	public MyActivitiEventListener(IActivitiEventHandler event) {
		this.myEvent = event;
	}

	@Override
	public void onEvent(ActivitiEvent event) {
		EventInfo eventInfo = new EventInfo(event);
		switch (event.getType()) {

		case JOB_EXECUTION_SUCCESS:
			myEvent.jobExecutionSuccess(eventInfo);
			break;

		case JOB_EXECUTION_FAILURE:
			myEvent.jobExecutionFailure(eventInfo);
			break;
		case TASK_CREATED:
			myEvent.taskCreated(event, entry(event));
			break;
		case TASK_COMPLETED:
			myEvent.taskCompleted(event,entry(event));
			break;
		case TASK_ASSIGNED:
			myEvent.taskAssigned(event,entry(event));
			break;
		case PROCESS_STARTED:
			myEvent.processStarted((ActivitiEntityEvent) event);
			break;
		case PROCESS_CANCELLED:
			myEvent.processCancelled((ActivitiEntityEvent) event);
			break;
		case PROCESS_COMPLETED:
			myEvent.processCompleted((ActivitiEntityEvent) event);
			break;
		default:
			myEvent.otherEvent(eventInfo);
		}
	}

	private TaskEntity entry(ActivitiEvent event) {
		ActivitiEntityEventImpl evt = (ActivitiEntityEventImpl) event;
		TaskEntity entity = (TaskEntity) evt.getEntity();
		return entity;
	}

	@Override
	public boolean isFailOnException() {
		return myEvent.isFailOnException();
	}
}
