/**
 * Program  : HistoryTaskInfo.java<br/>
 * Author   : i<br/>
 * Create   : 20 May 2020 15:19:57<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.core.bean;

import java.util.Date;

import org.activiti.engine.history.HistoricTaskInstance;

public class HistoryTaskInfo extends TaskInfo {

	public HistoryTaskInfo(String taskId,
			String name,
			String definitionKey,
			String processInstanceId,
			String assignee) {
		super(taskId, name, definitionKey, processInstanceId, assignee);
	}

	private Date startTime;

	private Date endTime;

	private Long durationInMillis;

	private Long workTimeInMillis;

	private Date claimTime;

	@Override
	public String toString() {
		return "HistoryTaskInfo [super.toString()=" + super.toString()
				+ ", startTime="
				+ startTime
				+ ", endTime="
				+ endTime
				+ ", durationInMillis="
				+ durationInMillis
				+ ", workTimeInMillis="
				+ workTimeInMillis
				+ ", claimTime="
				+ claimTime
				+ "]";
	}

	private HistoryTaskInfo(Builder builder) {
		super(builder.taskId, builder.name, builder.definitionKey, builder.processInstanceId, builder.assignee);
		this.startTime = builder.startTime;
		this.endTime = builder.endTime;
		this.durationInMillis = builder.durationInMillis;
		this.workTimeInMillis = builder.workTimeInMillis;
		this.claimTime = builder.claimTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public Long getDurationInMillis() {
		return durationInMillis;
	}

	public Long getWorkTimeInMillis() {
		return workTimeInMillis;
	}

	public Date getClaimTime() {
		return claimTime;
	}

	public static Builder historyBuilder() {
		return new Builder();
	}

	public static final class Builder extends TaskInfo.Builder {

		private Date startTime;

		private Date endTime;

		private Long durationInMillis;

		private Long workTimeInMillis;

		private Date claimTime;

		private Builder() {
		}

		public Builder withStartTime(Date startTime) {
			this.startTime = startTime;
			return this;
		}

		public Builder withEndTime(Date endTime) {
			this.endTime = endTime;
			return this;
		}

		public Builder withDurationInMillis(Long durationInMillis) {
			this.durationInMillis = durationInMillis;
			return this;
		}

		public Builder withWorkTimeInMillis(Long workTimeInMillis) {
			this.workTimeInMillis = workTimeInMillis;
			return this;
		}

		public Builder withClaimTime(Date claimTime) {
			this.claimTime = claimTime;
			return this;
		}

		public HistoryTaskInfo build() {
			return new HistoryTaskInfo(this);
		}

		public Builder withTask(HistoricTaskInstance task) {
			super.withTask(task);
			this.claimTime = task.getClaimTime();
			this.workTimeInMillis = task.getWorkTimeInMillis();
			this.durationInMillis = task.getDurationInMillis();
			this.endTime = task.getEndTime();
			this.startTime = task.getStartTime();
			return this;
		}
	}

}
