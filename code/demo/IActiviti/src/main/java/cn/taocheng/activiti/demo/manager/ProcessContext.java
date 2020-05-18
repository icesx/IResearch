/**
 * Program  : FlowManager.java<br/>
 * Author   : i<br/>
 * Create   : 15 May 2020 08:26:22<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.qos.logback.core.joran.spi.ActionException;
import cn.taocheng.activiti.demo.modle.ProcessInstanceInfo;
import cn.taocheng.activiti.demo.modle.TaskInfo;
import cn.taocheng.activiti.demo.service.IActivitiService;
import cn.taocheng.activiti.demo.task.ActionParams;

@Component
class ProcessContext implements IProcessContext {
	private static final String START_ASSIGNEE = "start_assignee";

	private static final Logger logger = LoggerFactory.getLogger(ProcessContext.class);

	private static ProcessContext instance;

	public static synchronized ProcessContext instance() {
		return instance = (instance == null) ? new ProcessContext() : instance;
	}

	private String bpmn;

	private Map<String, Class<?>> taskClassMap = new HashMap<>();

	private Map<String, ITaskAction> usertaskActionMap = new HashMap<String, ITaskAction>();

	private Map<String, ITaskAction> currentActionMap = new HashMap<String, ITaskAction>();

	private List<ITaskAction> actions = new ArrayList<>();

	@Autowired
	private IActivitiService activitiService;

	private ProcessContext() {
		logger.info("init " + this.getClass());

	}

	public ProcessContext(String classpath) {
		this.bpmn = classpath;
		logger.info("create processManager with {}", this.bpmn);
	}

	@Override
	public ITaskAction currentTaskAction(Assginee assignee) throws ActionException {
		// List<TaskInfo> tasks =
		// activitiService.listTasksFromAssignee(processInstanceId, assignee.getName());
		// if (tasks.size() > 1) {
		// logger.warn("the task num for assginess {} is more than one .",
		// assignee.getName());
		// }
		// if (tasks.size() == 0) {
		// logger.warn("cannot list tasks from assignee {}", assignee.getName());
		// return null;
		// } else {
		// return taskAction(tasks.get(0));
		// }
	}

	@Override
	public List<ITaskAction> listTaskAction() {
		return actions;
	}

	@Override
	public void onCreatedEntry(TaskEntity entry) throws ActionException {
		@SuppressWarnings("unchecked")
		Class<ITaskAction> clazz = (Class<ITaskAction>) this.taskClassMap.get(entry.getTaskDefinitionKey());
		ITaskAction action;
		try {
			action = clazz.newInstance();
			action.setActiviti(this.activitiService);
			TaskInfo taskInfo = TaskInfo
					.builder()
					.withId(entry.getId())
					.withDefinitionKey(entry.getTaskDefinitionKey())
					.withName(entry.getName())
					.withProcessInstanceId(entry.getProcessDefinitionId())
					.build();
			action.setTaskInfo(taskInfo);
			entry.setAssignee(action.onAssginee(taskInfo).getName());
		} catch (InstantiationException | IllegalAccessException e) {
			logger.error(e.getMessage(), e);
			throw new ActionException(e);
		}
	}

	@Override
	public <T extends ITaskAction> void registTaskAction(String defineTaskId, Class<T> clazz) {
		// TODO 需要持久化
		this.taskClassMap.put(defineTaskId, clazz);
	}

	@Override
	public ProcessInstanceInfo startProcess(String processDefineId, ActionParams params, Assginee assginee) {
		params.put(START_ASSIGNEE, assginee.getName());
		ProcessInstanceInfo pi = activitiService.startProcess(processDefineId, params.params());
		return pi;
	}

}
