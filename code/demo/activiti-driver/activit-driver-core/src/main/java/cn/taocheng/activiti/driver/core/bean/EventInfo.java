/**
 * Program  : EventInfo.java<br/>
 * Author   : i<br/>
 * Create   : 14 May 2020 22:48:09<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.core.bean;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventType;

public class EventInfo {

	private ActivitiEventType eventType;

	private String executionId;

	private String processDefinitionId;

	private String processInstanceId;

	public EventInfo(ActivitiEvent event) {
		executionId = event.getExecutionId();
		processDefinitionId = event.getProcessDefinitionId();
		processInstanceId = event.getProcessInstanceId();
		eventType = event.getType();
	}

	public ActivitiEventType getEventType() {
		return eventType;
	}

	public String getExecutionId() {
		return executionId;
	}

	public String getProcessDefinitionId() {
		return processDefinitionId;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	@Override
	public String toString() {
		return "EventInfo [eventType=" + eventType
				+ ", executionId="
				+ executionId
				+ ", processDefinitionId="
				+ processDefinitionId
				+ ", processInstanceId="
				+ processInstanceId
				+ "]";
	}

}
