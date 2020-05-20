/**
 * Program  : PublicProcessOperator.java<br/>
 * Author   : i<br/>
 * Create   : 20 May 2020 18:02:55<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

import cn.taocheng.activiti.driver.ActivitiException;
import cn.taocheng.activiti.driver.bean.Assginee;
import cn.taocheng.activiti.driver.bean.ProcessInstanceInfo;
import cn.taocheng.activiti.driver.bean.TaskInfo;
import cn.taocheng.activiti.driver.dao.ITaskActionDao;
import cn.taocheng.activiti.driver.entity.TaskActionEntity;
import cn.taocheng.activiti.driver.service.IActivitiService;

public class PublicProcessOperator implements IProcessEventHandler {

	private static final Logger logger = LoggerFactory.getLogger(PublicProcessOperator.class);

	private static PublicProcessOperator instance;

	private PublicProcessOperator() {
		logger.info("init " + this.getClass());
	}

	public static synchronized PublicProcessOperator instance() {
		return instance = (instance == null) ? new PublicProcessOperator() : instance;
	}

	private Map<String, AbsTaskAction> taskActionMap = new HashMap<String, AbsTaskAction>();

	@Autowired
	private ITaskActionDao taskActionDao;

	@Autowired
	private AutowireCapableBeanFactory beanFactory;

	@Autowired
	private IActivitiService activitiService;

	private Map<String, Class<?>> taskClassMap = new HashMap<>();

	public List<AbsTaskAction> currentTaskAction(ProcessInstanceInfo processInstanceInfo, Assginee assignee) {
		List<TaskInfo> tasks =
				activitiService.listTasksFromAssignee(processInstanceInfo.getProcessInstanceId(), assignee.getName());
		return tasks.stream().map(t -> findTaskAction(t)).filter(t -> t != null).collect(Collectors.toList());
	}

	private AbsTaskAction findTaskAction(String mapKey) {
		AbsTaskAction action = this.taskActionMap.get(mapKey);
		if (action == null) {
			logger.warn("this entry {} is created but not find in this.taskActionMap,this is some problom in logic");
		}
		return action;
	}

	private AbsTaskAction findTaskAction(TaskEntity entry) {
		return findTaskAction(mapKey(entry));
	}

	public AbsTaskAction findTaskAction(TaskInfo taskInfo) {
		return findTaskAction(mapKey(taskInfo.getProcessInstanceId(), taskInfo.getTaskId()));
	}

	private AbsTaskAction instanceTaskAction(TaskEntity entry) throws InstantiationException, IllegalAccessException {
		TaskInfo taskInfo = TaskInfo
				.builder()
				.withId(entry.getId())
				.withDefinitionKey(entry.getTaskDefinitionKey())
				.withName(entry.getName())
				.withProcessInstanceId(entry.getProcessDefinitionId())
				.build();
		return instanceTaskAction(taskInfo);
	}

	private AbsTaskAction instanceTaskAction(TaskInfo taskInfo) {
		try {
			@SuppressWarnings("unchecked")
			Class<AbsTaskAction> clazz = (Class<AbsTaskAction>) this.taskClassMap.get(taskInfo.getDefinitionKey());
			if (clazz == null) {
				logger.error("cannot get AbsTaskAction for {},please check your code ", taskInfo);
				return null;
			} else {
				AbsTaskAction action = clazz.newInstance();
				action.setTaskInfo(taskInfo);
				beanFactory.autowireBean(action);
				logger.info("instance taskaction {} for {}", clazz, taskInfo);
				return action;
			}

		} catch (Exception e) {
			logger.error("instanceTaskAction error for {} ", taskInfo);
			logger.error(e.getMessage(), e);
		}
		return null;

	}

	public List<AbsTaskAction> listTaskAction(ProcessInstanceInfo processInstanceInfo) {
		List<TaskInfo> tasks = this.activitiService.listTasksFromProcess(processInstanceInfo.getProcessInstanceId());
		return tasks
				.stream()
				.map(t -> this.taskActionMap.get(this.mapKey(t.getProcessInstanceId(), t.getTaskId())))
				.collect(Collectors.toList());
	}

	void load(ProcessInstanceInfo processInstanceInfo) {
		logger.info("ProcessOperation {} load data from DB", processInstanceInfo);
		loadTaskActionClass();
		List<TaskInfo> tasks = activitiService.listTasksFromProcess(processInstanceInfo.getProcessInstanceId());
		for (TaskInfo taskInfo : tasks) {
			this.taskActionMap
					.put(mapKey(taskInfo.getProcessInstanceId(), taskInfo.getTaskId()), instanceTaskAction(taskInfo));
		}

	}

	void loadTaskActionClass() {
		List<TaskActionEntity> entitis = taskActionDao.findAll();
		try {
			for (TaskActionEntity taskActionEntity : entitis) {
				this.taskClassMap.put(taskActionEntity.getDefineTaskId(), Class.forName(taskActionEntity.getClazz()));
			}
		} catch (ClassNotFoundException e) {
			logger.error(e.getMessage());
		}
	}

	private String mapKey(String processInstanceId, String entyId) {
		return processInstanceId + "_" + entyId;
	}

	private String mapKey(TaskEntity entry) {
		return mapKey(entry.getProcessInstanceId(), entry.getId());
	}

	@Override
	public void onComplateTask(TaskEntity entry) {
		findTaskAction(entry).onComplate();
	}

	@Override
	public void onCreatedTask(TaskEntity entry) {
		try {
			logger.info("onCreatedTask {}", entry.toString());
			AbsTaskAction action = instanceTaskAction(entry);
			if (action == null) {
				String error = "cannot instance TaskAction for entry=" + entry.getId();
				logger.error(error);
				throw new ActivitiException(error);
			}
			this.taskActionMap.put(mapKey(entry), action);
			Assginee provideAssginee = action.provideAssginee(action.getTaskInfo());
			if (provideAssginee != null) {
				logger
						.info("setAssignee for taskId={},assginee={}",
								action.getTaskInfo().getTaskId(),
								provideAssginee.getName());
				entry.setAssignee(provideAssginee.getName());
			} else {
				logger.warn("cannot setAssignee from action={},please make sure you didnot need assginee..", action);
			}
			action.onCreate();
		} catch (InstantiationException | IllegalAccessException e) {
			logger.error(e.getMessage(), e);
			throw new ActivitiException(e);
		}
	}

	public <T extends AbsTaskAction> void registTaskAction(String defineTaskId, Class<T> clazz) {
		this.taskClassMap.put(defineTaskId, clazz);
		logger.info("regist taskAction {} for {} ", clazz, defineTaskId);
		this.taskActionDao.save(new TaskActionEntity(defineTaskId, clazz.getName()));
	}

}
