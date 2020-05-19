/**
 * Program  : TaskRepresentation.java<br/>
 * Author   : i<br/>
 * Create   : Oct 23, 2019 4:48:12 PM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.bean;

import org.activiti.engine.task.Task;

public class TaskInfo {

	// 任务节点id
	private String taskId;

	// 流程实例id
	private String processInstanceId;

	private String name;

	private String definitionKey;

	private String assginee;

	public TaskInfo(String taskId, String name, String definitionKey, String processInstanceId, String assignee) {
		this.taskId = taskId;
		this.processInstanceId = processInstanceId;
		this.name = name;
		this.definitionKey = definitionKey;
		this.assginee = assignee;
	}

	public String getTaskId() {
		return taskId;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public String getName() {
		return name;
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
		return "TaskInfo [taskId=" + taskId
				+ ", processInstanceId="
				+ processInstanceId
				+ ", name="
				+ name
				+ ", definitionKey="
				+ definitionKey
				+ ", assginee="
				+ assginee
				+ "]";
	}

	public static class Builder {
		private String taskId;

		private String name;

		private String processInstanceId;

		private String definitionKey;

		private String assignee;

		public Builder withId(String taskId) {
			this.taskId = taskId;
			return this;
		}

		public Builder withProcessInstanceId(String processInstanceId) {
			this.processInstanceId = processInstanceId;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withDefinitionKey(String definitionKey) {
			this.definitionKey = definitionKey;
			return this;
		}

		public Builder withAssignee(String assignee) {
			this.assignee = assignee;
			return this;
		}

		public TaskInfo build() {
			return new TaskInfo(taskId, name, definitionKey, processInstanceId, assignee);
		}

		public Builder withTask(Task task) {
			this.taskId = task.getId();
			this.processInstanceId = task.getProcessInstanceId();
			this.name = task.getName();
			this.definitionKey = task.getTaskDefinitionKey();
			this.assignee = task.getAssignee();
			return this;
		}

	}
}
