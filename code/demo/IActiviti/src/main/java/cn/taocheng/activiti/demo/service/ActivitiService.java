/**
 * Program  : ActivitiService.java<br/>
 * Author   : i<br/>
 * Create   : Oct 23, 2019 3:59:24 PM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Event;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import cn.taocheng.activiti.demo.manager.TaskActionEventHandler;
import cn.taocheng.activiti.demo.modle.DeploymentInfo;
import cn.taocheng.activiti.demo.modle.ProcessInfo;
import cn.taocheng.activiti.demo.modle.ProcessInstanceInfo;
import cn.taocheng.activiti.demo.modle.TaskInfo;
import cn.taocheng.activiti.demo.service.event.IActivitiEventHandler;
import cn.taocheng.activiti.demo.service.event.MyActivitiEventListener;
import cn.taocheng.activiti.demo.utils.DeploymentUtil;
import cn.taocheng.activiti.demo.utils.ProcessUtil;
import cn.taocheng.activiti.demo.utils.TaskUtil;

@Service("activitiService")
@Transactional
public class ActivitiService implements IActivitiService {
	private static final Map<String, Object> VARIABLE_MAP = new HashMap<>();

	private static final Logger logger = LoggerFactory.getLogger(ActivitiService.class);

	public ActivitiService() {
		logger.info("init " + this.getClass());
	}

	@Resource
	private RuntimeService runtimeService;

	@Resource
	private RepositoryService repositoryService;

	@Resource
	private TaskService taskService;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		// Do any additional configuration here
		return builder.build();
	}

	public void setRuntimeService(RuntimeService runtimeService) {
		this.runtimeService = runtimeService;
		this.addEvent(new TaskActionEventHandler());
	}

	@Override
	public void addEvent(IActivitiEventHandler event) {
		runtimeService.addEventListener(new MyActivitiEventListener(event));
	}

	@Override
	public ProcessInstanceInfo startProcess(String processDefinitionKey, Map<String, Object> variableMap) {
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, variableMap);
		return ProcessInstanceInfo.builder().withProcessInstance(processInstance).build();
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
	public List<TaskInfo> listTasksFromProcessDefine(String processDefinitionId) {
		return TaskUtil.TaskTrans(taskService.createTaskQuery().processDefinitionId(processDefinitionId).list());
	}

	@Override
	public List<TaskInfo> listTasksFromProcess(String processInstanceId) {
		return TaskUtil.TaskTrans(taskService.createTaskQuery().processInstanceId(processInstanceId).list());
	}

	@Override
	public List<TaskInfo> listActiveTasksFromProcess(String processInstanceId) {
		return TaskUtil.TaskTrans(taskService.createTaskQuery().processInstanceId(processInstanceId).active().list());
	}

	@Override
	public List<TaskInfo> listTasksFromAssignee(String processInstanceId, String assignee) {
		return TaskUtil
				.TaskTrans(
						taskService
								.createTaskQuery()
								.processInstanceId(processInstanceId)
								.taskAssignee(assignee)
								.list());
	}

	@Override
	public ProcessInstanceInfo startProcess(String processDefinitionKey) {
		return startProcess(processDefinitionKey, VARIABLE_MAP);
	}

	@Override
	public List<DeploymentInfo> listDeployment() {
		List<Deployment> list = repositoryService.createDeploymentQuery().list();
		return DeploymentUtil.processTrans(list);
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
	public ProcessInfo process(String processDefinitionId) {
		return ProcessUtil
				.processTran(
						repositoryService
								.createProcessDefinitionQuery()
								.processDefinitionId(processDefinitionId)
								.singleResult());
	}

	@Override
	public Deployment deploy(String classpath) {
		return repositoryService.createDeployment().addClasspathResource(classpath).deploy();

	}

	@Override
	public void completeTask(String taskId) {
		taskService.complete(taskId);
	}

	@Override
	public void claimTask(String taskId, String userId) {
		taskService.claim(taskId, userId);
	}

	@Override
	public void delProcesseById(String id) {
		repositoryService.deleteDeployment(id);
	}

	@Override
	public void delProcesseAll() {
		List<Deployment> list = repositoryService.createDeploymentQuery().list();
		for (Deployment deployment : list) {
			repositoryService.deleteDeployment(deployment.getId());
		}
	}

	@Override
	public void completeTask(String taskI, Map<String, Object> map) {
		taskService.complete(taskI, map);
	}

	@Override
	public List<Event> allTaskEvent(String processInstanceId) {
		return runtimeService.getProcessInstanceEvents(processInstanceId);
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

}
