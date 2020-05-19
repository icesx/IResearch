/**
 * Program  : ProcessInfo.java<br/>
 * Author   : i<br/>
 * Create   : Oct 25, 2019 9:53:55 AM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.bean;

import org.activiti.engine.runtime.ProcessInstance;

public class ProcessInstanceInfo {
	public ProcessInstanceInfo() {
	}

	private String id;

	private String name;

	private String processInstanceId;

	private String processDeployId;

	private String taskDeployKey;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getProcessDeployId() {
		return processDeployId;
	}

	public void setProcessDeployId(String processDeployId) {
		this.processDeployId = processDeployId;
	}

	public String getTaskDeployKey() {
		return taskDeployKey;
	}

	public void setTaskDeployKey(String taskDeployKey) {
		this.taskDeployKey = taskDeployKey;
	}

	ProcessInstanceInfo(String id, String processInstanceId, String name, String processDeployId, String taskDeployKey) {
		this.id = id;
		this.name = name;
		this.processInstanceId = processInstanceId;
		this.processDeployId = processDeployId;
		this.taskDeployKey = taskDeployKey;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private String id;

		private String name;

		private String processInstanceId;

		private String processDeployId;

		private String taskDeployKey;

		public Builder withProcessInstance(ProcessInstance processInstance) {
			this.id = processInstance.getId();
			this.processInstanceId = processInstance.getProcessInstanceId();
			this.processDeployId = processInstance.getDeploymentId();
			this.name = processInstance.getName();
			this.taskDeployKey = processInstance.getProcessDefinitionKey();
			return this;
		}

		public ProcessInstanceInfo build() {
			return new ProcessInstanceInfo(id, processInstanceId, name, processDeployId, taskDeployKey);
		}

	}

	@Override
	public String toString() {
		return "ProcessInstanceInfo [id=" + id + ", name=" + name + ", processInstanceId=" + processInstanceId + ", processDeployId=" + processDeployId + ", taskDeployKey=" + taskDeployKey + "]";
	}

}
