/**
 * Program  : ActivitiService.java<br/>
 * Author   : i<br/>
 * Create   : Oct 23, 2019 3:59:24 PM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Event;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import cn.taocheng.activiti.driver.bean.DeploymentInfo;
import cn.taocheng.activiti.driver.bean.HistoryTaskInfo;
import cn.taocheng.activiti.driver.bean.ProcessInfo;
import cn.taocheng.activiti.driver.bean.ProcessInstanceInfo;
import cn.taocheng.activiti.driver.bean.TaskInfo;
import cn.taocheng.activiti.driver.utils.DeploymentUtil;
import cn.taocheng.activiti.driver.utils.ProcessUtil;
import cn.taocheng.activiti.driver.utils.TaskUtil;

@Component
@Transactional
public class ActivitiService implements IActivitiService {
	private static final Map<String, Object> VARIABLE_MAP = new HashMap<>();

	private static final Logger logger = LoggerFactory.getLogger(ActivitiService.class);

	@Resource
	private RuntimeService runtimeService;

	@Resource
	private RepositoryService repositoryService;

	@Resource
	private HistoryService historyService;

	@Resource
	private TaskService taskService;

	public ActivitiService() {
		logger.info("init " + this.getClass());
	}

	@Override
	public void addEvent(ActivitiEventListener event) {
		runtimeService.addEventListener(event);
		logger.info("addEvent {}", event);
	}

	@Override
	public List<Event> allTaskEvent(String processInstanceId) {
		return runtimeService.getProcessInstanceEvents(processInstanceId);
	}

	@Override
	public void claimTask(String taskId, String userId) {
		taskService.claim(taskId, userId);
		logger.info("claimTask taskId={},userId={}", taskId, userId);
	}

	@Override
	public void completeTask(String taskId) {
		taskService.complete(taskId);
		logger.info("completeTask taskId={}", taskId);
	}

	@Override
	public void completeTask(String taskId, Map<String, Object> map) {
		taskService.complete(taskId, map);
		logger.info("completeTask taskId={} variable={}", taskId, map);
	}

	@Override
	public boolean deleteDeployment(String deploymentId) {
		try {
			this.repositoryService.deleteDeployment(deploymentId);
			logger.info("deleteDeployment {} finished.", deploymentId);
			return true;
		} catch (RuntimeException e) {
			logger.error("deployment {} is runtime or history process instances or jobs.");
			logger.error(e.getMessage(), e);
			return false;
		}
	}

	@Override
	public void deleteProcessInstance(String processInstanceId, String deleteReason) {
		this.runtimeService.deleteProcessInstance(processInstanceId, deleteReason);
	}

	@Override
	public void delProcesseAll() {
		List<Deployment> list = repositoryService.createDeploymentQuery().list();
		for (Deployment deployment : list) {
			delProcesseById(deployment.getId());
		}
	}

	@Override
	public void delProcesseById(String id) {
		repositoryService.deleteDeployment(id);
		logger.info("delProcesseById deploymentId={}", id);
	}

	@Override
	public Deployment deploy(String classpath) {
		Deployment deploy = repositoryService.createDeployment().addClasspathResource(classpath).deploy();
		logger.info("deploy for {}", classpath);
		return deploy;
	}

	@Override
	public TaskInfo getTasks(String id) {
		Task task = taskService.createTaskQuery().processInstanceId(id).singleResult();
		if (task != null) {
			return TaskUtil.taskTran(taskService.createTaskQuery().processInstanceId(id).singleResult());
		} else {
			return null;
		}
	}

	@Override
	public Object getVariable(String taskId, String variableName) {
		return taskService.getVariable(taskId, variableName);
	}

	@Override
	public List<TaskInfo> listActiveTasks() {
		return TaskUtil.taskTrans(taskService.createTaskQuery().active().list());
	}

	@Override
	public List<TaskInfo> listActiveTasksFromProcess(String processInstanceId) {
		return TaskUtil.taskTrans(taskService.createTaskQuery().processInstanceId(processInstanceId).active().list());
	}

	@Override
	public List<DeploymentInfo> listDeployment() {
		List<Deployment> list = repositoryService.createDeploymentQuery().list();
		return DeploymentUtil.processTrans(list);
	}

	@Override
	public List<HistoryTaskInfo> listHistoryTasks() {
		List<HistoricTaskInstance> historyTasks = historyService.createHistoricTaskInstanceQuery().finished().list();
		return TaskUtil.historyTaskTrans(historyTasks);
	}

	@Override
	public List<HistoryTaskInfo> listHistoryTasks(String processInstanceId) {
		List<HistoricTaskInstance> historyTasks =
				historyService.createHistoricTaskInstanceQuery().processInstanceId(processInstanceId).finished().list();
		return TaskUtil.historyTaskTrans(historyTasks);
	}

	@Override
	public List<ProcessInfo> listProcessInfo() {
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().latestVersion().list();
		return ProcessUtil.processTrans(list);
	}

	@Override
	public List<ProcessInstanceInfo> listProcessInstance() {
		List<ProcessInstance> pis = this.runtimeService.createProcessInstanceQuery().list();
		return pis
				.stream()
				.map(pi -> ProcessInstanceInfo.builder().withProcessInstance(pi).build())
				.collect(Collectors.toList());
	}

	@Override
	public List<TaskInfo> listTasksFromAssignee(String assignee) {
		return TaskUtil.taskTrans(taskService.createTaskQuery().taskAssignee(assignee).list());
	}

	@Override
	public List<TaskInfo> listTasksFromAssignee(String processInstanceId, String assignee) {
		return TaskUtil
				.taskTrans(taskService
						.createTaskQuery()
						.processInstanceId(processInstanceId)
						.taskAssignee(assignee)
						.list());
	}

	@Override
	public List<TaskInfo> listTasksFromProcess(String processInstanceId) {
		return TaskUtil.taskTrans(taskService.createTaskQuery().processInstanceId(processInstanceId).list());
	}

	@Override
	public List<TaskInfo> listTasksFromProcessDefine(String processDefinitionId) {
		return TaskUtil.taskTrans(taskService.createTaskQuery().processDefinitionId(processDefinitionId).list());
	}

	@Override
	public ProcessInfo process(String processDefinitionId) {
		return ProcessUtil
				.processTran(repositoryService
						.createProcessDefinitionQuery()
						.processDefinitionId(processDefinitionId)
						.singleResult());
	}

	@Override
	public ProcessInstanceInfo processInstance(String processInstanceId) {
		ProcessInstance processInstance = runtimeService
				.createProcessInstanceQuery()
				.active()
				.processInstanceId(processInstanceId)
				.singleResult();
		if (processInstance == null) {
			logger.warn("cannot get ProcessInstance for processInstanceId={}", processInstanceId);
			return null;
		}
		return ProcessInstanceInfo.builder().withProcessInstance(processInstance).build();
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		// Do any additional configuration here
		return builder.build();
	}

	public void setRuntimeService(RuntimeService runtimeService) {
		this.runtimeService = runtimeService;
	}

	@Override
	public void setVariable(String taskId, String variableName, Object value) {
		taskService.setVariable(taskId, variableName, value);
		logger.info("setVariable for taskId={},variablename={},value={}", taskId, variableName, value);
	}

	@Override
	public ProcessInstanceInfo startProcess(String processDefinitionKey) {
		return startProcess(processDefinitionKey, VARIABLE_MAP);
	}

	@Override
	public ProcessInstanceInfo startProcess(String processDefinitionKey, Map<String, Object> variableMap) {
		logger.info("startProcess processDefinitionKey={}", processDefinitionKey);
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, variableMap);
		logger.info("startProcess processInstance={}", processInstance.getProcessInstanceId());
		ProcessInstanceInfo pii = ProcessInstanceInfo.builder().withProcessInstance(processInstance).build();
		logger.info("startProcess ProcessInstanceInfo={}", pii);
		return pii;
	}

}
