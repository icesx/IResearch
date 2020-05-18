/**
 * Program  : IActivitiService.java<br/>
 * Author   : i<br/>
 * Create   : Oct 23, 2019 4:19:32 PM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.service;

import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.task.Event;

import cn.taocheng.activiti.demo.modle.DeploymentInfo;
import cn.taocheng.activiti.demo.modle.ProcessInfo;
import cn.taocheng.activiti.demo.modle.ProcessInstanceInfo;
import cn.taocheng.activiti.demo.modle.TaskInfo;
import cn.taocheng.activiti.demo.service.event.IActivitiEventHandler;

public interface IActivitiService {

	void addEvent(IActivitiEventHandler event);

	List<Event> allTaskEvent(String processInstanceId);

	void claimTask(String taskId, String userId);

	void completeTask(String taskId);

	void completeTask(String taskId, Map<String, Object> map);

	void delProcesseAll();

	void delProcesseById(String id);

	Deployment deploy(String classpath);

	TaskInfo getTasks(String assignee);

	List<ProcessInstanceInfo> listProcessInstance();

	List<TaskInfo> listActiveTasksFromProcess(String processInstanceId);

	List<DeploymentInfo> listDeployment();

	List<ProcessInfo> listProcessInfo();

	List<TaskInfo> listTasksFromAssignee(String processInstanceId, String assignee);

	List<TaskInfo> listTasksFromProcess(String processDefinitionId);

	List<TaskInfo> listTasksFromProcessDefine(String processDefinitionId);

	ProcessInfo process(String processDefinitionId);

	ProcessInstanceInfo startProcess(String processDefinitionKey);

	ProcessInstanceInfo startProcess(String processDefinitionKey, Map<String, Object> variableMap);

	boolean deleteDeployment(String deploymentId);

}
