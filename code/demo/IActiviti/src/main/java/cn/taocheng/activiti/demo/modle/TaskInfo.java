/**
 * Program  : TaskRepresentation.java<br/>
 * Author   : i<br/>
 * Create   : Oct 23, 2019 4:48:12 PM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.modle;

import org.activiti.engine.task.Task;

public class TaskInfo {

	// 任务节点id
	private String taskId;

	// 流程实例id
	private String processInstanceId;

	private String name;

	private String definitionKey;

	public TaskInfo(String taskId, String name, String definitionKey, String processInstanceId) {
		this.taskId = taskId;
		this.processInstanceId = processInstanceId;
		this.name = name;
		this.definitionKey = definitionKey;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDefinitionKey() {
		return definitionKey;
	}

	public void setDefinitionKey(String definitionKey) {
		this.definitionKey = definitionKey;
	}

	public static Builder builder() {
		return new Builder();
	}

	@Override
	public String toString() {
		return "TaskInfo [taskId=" + taskId + ", processInstanceId=" + processInstanceId + ", name=" + name + ", definitionKey=" + definitionKey + "]";
	}

	public static class Builder {
		private String taskId;

		private String name;

		private String processInstanceId;

		private String definitionKey;

		public Builder withId(Task task) {
			this.taskId = task.getId();
			this.processInstanceId = task.getProcessInstanceId();
			this.name = task.getName();
			this.definitionKey = task.getTaskDefinitionKey();
			return this;
		}

		public TaskInfo build() {
			return new TaskInfo(taskId, name, definitionKey, processInstanceId);
		}
	}
}
