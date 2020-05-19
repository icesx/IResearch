/**
 * Program  : Process.java<br/>
 * Author   : i<br/>
 * Create   : 19 May 2020 09:46:44<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.core.joran.spi.ActionException;
import cn.taocheng.activiti.driver.bean.Assginee;
import cn.taocheng.activiti.driver.bean.ProcessInstanceInfo;
import cn.taocheng.activiti.driver.bean.TaskInfo;
import cn.taocheng.activiti.driver.dao.ITaskActionDao;
import cn.taocheng.activiti.driver.entity.TaskActionEntity;
import cn.taocheng.activiti.driver.event.MyActivitiEventListener;
import cn.taocheng.activiti.driver.event.TaskActionEventHandler;
import cn.taocheng.activiti.driver.service.IActivitiService;

public class ProcessInstance implements IProcess {

	private static final Logger logger = LoggerFactory.getLogger(ProcessInstance.class);

	private Map<String, Class<?>> taskClassMap = new HashMap<>();

	private Map<String, AbsTaskAction> taskActionMap = new HashMap<String, AbsTaskAction>();

	private List<AbsTaskAction> actions = new ArrayList<>();

	private IActivitiService activitiService;

	private ProcessInstanceInfo processInstanceInfo;

	private ITaskActionDao taskActionDao;

	public ProcessInstance(ProcessInstanceInfo pi, IActivitiService activitiService2, ITaskActionDao taskActionDao) {
		this.processInstanceInfo = pi;
		this.activitiService = activitiService2;
		this.taskActionDao = taskActionDao;
		logger.info("create Process with {}", this.processInstanceInfo);
		MyActivitiEventListener
				.instance()
				.registHandle(this.processInstanceInfo.getId(), new TaskActionEventHandler(this));
		this.load();
	}

	private void load() {
		List<TaskActionEntity> entitis = taskActionDao.findAll();
		try {
			for (TaskActionEntity taskActionEntity : entitis) {
				this.taskClassMap.put(taskActionEntity.getDefineTaskId(), Class.forName(taskActionEntity.getClazz()));
			}
		} catch (ClassNotFoundException e) {
			logger.error(e.getMessage(), e);
		}

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
		try {
			AbsTaskAction action = instanceTaskAction(entry);
			this.taskActionMap.put(mapKey(entry), action);
			this.actions.add(action);
			entry.setAssignee(action.provideAssginee(action.getTaskInfo()).getName());
			action.onCreate();
		} catch (InstantiationException | IllegalAccessException e) {
			logger.error(e.getMessage(), e);
			throw new ActionException(e);
		}
	}

	private AbsTaskAction instanceTaskAction(TaskEntity entry) throws InstantiationException, IllegalAccessException {
		@SuppressWarnings("unchecked")
		Class<AbsTaskAction> clazz = (Class<AbsTaskAction>) this.taskClassMap.get(entry.getTaskDefinitionKey());
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
		return action;
	}

	@Override
	public <T extends AbsTaskAction> void registTaskAction(String defineTaskId, Class<T> clazz) {
		this.taskClassMap.put(defineTaskId, clazz);
		this.taskActionDao.save(new TaskActionEntity(defineTaskId, clazz.getName()));
	}

}
