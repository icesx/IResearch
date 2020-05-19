/**
 * Program  : MyActivitiEvent.java<br/>
 * Author   : i<br/>
 * Create   : 14 May 2020 22:43:34<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.event;

import org.activiti.engine.delegate.event.ActivitiEntityEvent;
import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.impl.persistence.entity.TaskEntity;

import cn.taocheng.activiti.driver.bean.EventInfo;

public interface ICustomEventHandler {

	void jobExecutionFailure(EventInfo eventInfo);

	void jobExecutionSuccess(EventInfo eventInfo);

	void otherEvent(EventInfo eventInfo);

	void processCancelled(ActivitiEntityEvent event);

	void processCompleted(ActivitiEntityEvent event);

	void processStarted(ActivitiEntityEvent event);

	void taskAssigned(ActivitiEvent event, TaskEntity entry);

	void taskCompleted(ActivitiEvent event, TaskEntity entry);

	void taskCreated(ActivitiEvent event, TaskEntity entry);

}
