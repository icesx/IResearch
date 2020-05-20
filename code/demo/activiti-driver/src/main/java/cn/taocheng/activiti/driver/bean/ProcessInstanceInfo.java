/**
 * Program  : ProcessInfo.java<br/>
 * Author   : i<br/>
 * Create   : Oct 25, 2019 9:53:55 AM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.bean;

import org.activiti.engine.runtime.ProcessInstance;

public class ProcessInstanceInfo {
	public ProcessInstanceInfo() {
	}

	private String id;

	private String name;

	private String processInstanceId;

	private String processDeployId;

	private String processDefinitionKey;

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

	public String getProcessDeployId() {
		return processDeployId;
	}

	public String getProcessDefinitionKey() {
		return processDefinitionKey;
	}

	private ProcessInstanceInfo(String id,
			String processInstanceId,
			String name,
			String processDeployId,
			String processDefinitionKey) {
		this.id = id;
		this.name = name;
		this.processInstanceId = processInstanceId;
		this.processDeployId = processDeployId;
		this.processDefinitionKey = processDefinitionKey;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private String id;

		private String name;

		private String processInstanceId;

		private String processDeployId;

		private String processDefinitionKey;

		public Builder withProcessInstance(ProcessInstance processInstance) {
			this.id = processInstance.getId();
			this.processInstanceId = processInstance.getProcessInstanceId();
			this.processDeployId = processInstance.getDeploymentId();
			this.name = processInstance.getName();
			this.processDefinitionKey = processInstance.getProcessDefinitionKey();
			return this;
		}

		public ProcessInstanceInfo build() {
			return new ProcessInstanceInfo(id, processInstanceId, name, processDeployId, processDefinitionKey);
		}

	}

	@Override
	public String toString() {
		return "ProcessInstanceInfo [id=" + id
				+ ", name="
				+ name
				+ ", processInstanceId="
				+ processInstanceId
				+ ", processDeployId="
				+ processDeployId
				+ ", processDefinitionKey="
				+ processDefinitionKey
				+ "]";
	}

}
