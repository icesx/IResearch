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

import javax.annotation.Resource;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import cn.taocheng.activiti.demo.modle.DeploymentInfo;
import cn.taocheng.activiti.demo.modle.ProcessInfo;
import cn.taocheng.activiti.demo.modle.ProcessInstanceInfo;
import cn.taocheng.activiti.demo.modle.TaskInfo;
import cn.taocheng.activiti.demo.utils.DeploymentUtil;
import cn.taocheng.activiti.demo.utils.ProcessUtil;
import cn.taocheng.activiti.demo.utils.TaskUtil;

@Service("activitiService")
@Transactional
public class ActivitiService implements IActivitiService {
	private static final Map<String, Object> VARIABLE_MAP = new HashMap<>();

	private static final Logger logger = LoggerFactory.getLogger(ActivitiService.class);

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
	public List<TaskInfo> listTasksFromProcess(String processDefinitionId) {
		return TaskUtil.TaskTrans(taskService.createTaskQuery().processDefinitionId(processDefinitionId).list());
	}

	@Override
	public ProcessInstanceInfo startProcess(String processDefinitionKey) {
		return startProcess(processDefinitionKey, VARIABLE_MAP);
	}

	@Override
	public List<DeploymentInfo> listProcess() {
		List<Deployment> list = repositoryService.createDeploymentQuery().list();

		return DeploymentUtil.processTrans(list);
	}

	@Override
	public List<ProcessInfo> listProcessInfo() {
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().latestVersion().list();
		return ProcessUtil.processTrans(list);
	}

	@Override
	public List<ProcessInfo> listActivedProcess() {
		return ProcessUtil.processTrans(repositoryService.createProcessDefinitionQuery().active().list());
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
		// taskService.getIdentityLinksForTask(taskId);
		taskService.complete(taskId);
	}

	@Override
	public void claimTask(String taskId, String assginee) {
		taskService.claim(taskId, assginee);
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

}
