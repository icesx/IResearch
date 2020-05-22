/**
 * Program  : IActivitiService.java<br/>
 * Author   : i<br/>
 * Create   : Oct 23, 2019 4:19:32 PM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.core.service;

import java.util.List;
import java.util.Map;

import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.task.Event;

import cn.taocheng.activiti.driver.core.bean.DeploymentInfo;
import cn.taocheng.activiti.driver.core.bean.HistoryTaskInfo;
import cn.taocheng.activiti.driver.core.bean.ProcessInfo;
import cn.taocheng.activiti.driver.core.bean.ProcessInstanceInfo;
import cn.taocheng.activiti.driver.core.bean.TaskInfo;

public interface IActivitiService {

	void addEvent(ActivitiEventListener event);

	List<Event> allTaskEvent(String processInstanceId);

	TaskInfo claimTask(String taskId, String userId);

	TaskInfo completeTask(String taskId);

	void completeTask(String taskId, Map<String, Object> map);

	boolean deleteDeployment(String deploymentId);

	void delProcesseAll();

	void delProcesseById(String id);

	void deleteProcessInstance(String id, String reason);

	Deployment deploy(String classpath);

	Object getVariable(String taskId, String variableName);

	List<TaskInfo> listActiveTasks();

	List<TaskInfo> listActiveTasksFromProcess(String processInstanceId);

	List<DeploymentInfo> listDeployment();

	List<HistoryTaskInfo> listHistoryTasks();

	List<HistoryTaskInfo> listHistoryTasks(String processInstanceId);

	List<ProcessInfo> listProcessInfo();

	List<ProcessInstanceInfo> listProcessInstance();

	List<TaskInfo> listTasksFromAssignee(String name);

	List<TaskInfo> listTasksFromAssignee(String processInstanceId, String assignee);

	List<TaskInfo> listTasksFromProcess(String processInstanceId);

	List<TaskInfo> listTasksFromProcessDefine(String processDefinitionId);

	ProcessInfo process(String processDefinitionId);

	ProcessInstanceInfo processInstance(String processInstanceId);

	TaskInfo setVariable(String taskId, String variableName, Object value);

	ProcessInstanceInfo startProcess(String processDefinitionKey);

	ProcessInstanceInfo startProcess(String processDefinitionKey, Map<String, Object> variableMap);

	TaskInfo getTask(String taskId);

	TaskInfo setAssginee(String taskId, String userId);
}
