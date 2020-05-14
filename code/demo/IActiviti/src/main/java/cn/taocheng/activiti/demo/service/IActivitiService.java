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

import cn.taocheng.activiti.demo.modle.DeploymentInfo;
import cn.taocheng.activiti.demo.modle.ProcessInfo;
import cn.taocheng.activiti.demo.modle.ProcessInstanceInfo;
import cn.taocheng.activiti.demo.modle.TaskInfo;

public interface IActivitiService {

	TaskInfo getTasks(String assignee);

	Deployment deploy(String classpath);

	List<ProcessInfo> listProcessInfo();

	ProcessInstanceInfo startProcess(String processDefinitionKey, Map<String, Object> variableMap);

	ProcessInstanceInfo startProcess(String processDefinitionKey);

	List<ProcessInfo> listActivedProcess();

	List<DeploymentInfo> listProcess();

	ProcessInfo process(String processDefinitionId);

	List<TaskInfo> listTasksFromProcess(String processDefinitionId);

	void completeTask(String taskI, Map<String, Object> map);

	void completeTask(String taskI);

	void claimTask(String taskId, String assginee);

	void delProcesseAll();

	void delProcesseById(String id);

}
