/**
 * Program  : Process.java<br/>
 * Author   : i<br/>
 * Create   : 19 May 2020 09:46:44<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.core.joran.spi.ActionException;
import cn.taocheng.activiti.demo.manager.Assginee;
import cn.taocheng.activiti.demo.modle.ProcessInstanceInfo;
import cn.taocheng.activiti.demo.modle.TaskInfo;
import cn.taocheng.activiti.demo.service.IActivitiService;
import cn.taocheng.activiti.demo.service.event.MyActivitiEventListener;
import cn.taocheng.activiti.demo.service.event.TaskActionEventHandler;

public class ProcessInstance implements IProcess {

	private static final Logger logger = LoggerFactory.getLogger(ProcessInstance.class);

	private Map<String, Class<?>> taskClassMap = new HashMap<>();

	private Map<String, AbsTaskAction> taskActionMap = new HashMap<String, AbsTaskAction>();

	private List<AbsTaskAction> actions = new ArrayList<>();

	private IActivitiService activitiService;

	private ProcessInstanceInfo processInstanceInfo;

	public ProcessInstance(ProcessInstanceInfo pi, IActivitiService activitiService2) {
		this.processInstanceInfo = pi;
		this.activitiService = activitiService2;
		logger.info("create Process with {}", this.processInstanceInfo);
		MyActivitiEventListener
				.instance()
				.registHandle(this.processInstanceInfo.getId(), new TaskActionEventHandler(this));
		this.load();
	}

	private void load() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<AbsTaskAction> currentTaskAction(Assginee assignee) throws ActionException {
		List<TaskInfo> tasks = activitiService.listTasksFromAssignee(processInstanceInfo.getId(), assignee.getName());
		return tasks.stream().map(t -> findTaskAction(t)).collect(Collectors.toList());
	}

	@Override
	public List<AbsTaskAction> listTaskAction() {
		return actions;
	}

	@Override
	public void onComplateTask(TaskEntity entry) throws ActionException {
		findTaskAction(entry).onComplate();
	}

	private AbsTaskAction findTaskAction(TaskInfo taskInfo) {
		return findTaskAction(mapKey(taskInfo.getProcessInstanceId(), taskInfo.getTaskId()));
	}

	private AbsTaskAction findTaskAction(TaskEntity entry) {
		return findTaskAction(mapKey(entry));
	}

	private String mapKey(TaskEntity entry) {
		return mapKey(entry.getProcessInstanceId(), entry.getId());
	}

	private AbsTaskAction findTaskAction(String mapKey) {
		AbsTaskAction action = this.taskActionMap.get(mapKey);
		if (action == null) {
			logger.warn("this entry {} is created but not find in this.taskActionMap,this is some problom in logic");
		}
		return action;
	}

	private String mapKey(String processInstanceId, String entyId) {
		return processInstanceId + "_" + entyId;
	}

	@Override
	public void onCreatedTask(TaskEntity entry) throws ActionException {
		@SuppressWarnings("unchecked")
		Class<AbsTaskAction> clazz = (Class<AbsTaskAction>) this.taskClassMap.get(entry.getTaskDefinitionKey());
		try {
			AbsTaskAction action = clazz.newInstance();
			action.setActiviti(this.activitiService);
			TaskInfo taskInfo = TaskInfo
					.builder()
					.withId(entry.getId())
					.withDefinitionKey(entry.getTaskDefinitionKey())
					.withName(entry.getName())
					.withProcessInstanceId(entry.getProcessDefinitionId())
					.build();
			action.setTaskInfo(taskInfo);
			entry.setAssignee(action.provideAssginee(taskInfo).getName());
			action.onCreate();
			this.taskActionMap.put(mapKey(entry), action);
		} catch (InstantiationException | IllegalAccessException e) {
			logger.error(e.getMessage(), e);
			throw new ActionException(e);
		}
	}

	@Override
	public <T extends AbsTaskAction> void registTaskAction(String defineTaskId, Class<T> clazz) {
		// TODO 需要持久化
		this.taskClassMap.put(defineTaskId, clazz);
	}

}
