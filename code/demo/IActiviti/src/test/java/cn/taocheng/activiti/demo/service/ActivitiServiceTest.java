/**
 * Program  : ActivitiServiceTest.java<br/>
 * Author   : i<br/>
 * Create   : 14 May 2020 16:36:54<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.task.Event;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.taocheng.activiti.demo.modle.DeploymentInfo;
import cn.taocheng.activiti.demo.modle.ProcessInfo;
import cn.taocheng.activiti.demo.modle.ProcessInstanceInfo;
import cn.taocheng.activiti.demo.modle.TaskInfo;
import cn.taocheng.activiti.demo.service.event.DefaultActivitiEventHandler;
import cn.taocheng.activiti.demo.service.event.IActivitiEventHandler;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ActivitiServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(ActivitiServiceTest.class);

	@Autowired
	private IActivitiService activitiService;

	@Test
	public void activeTasksFromProcess() {
		List<TaskInfo> tasks = activitiService.listActiveTasksFromProcess("pigtwo:1:7");
		for (TaskInfo taskInfo : tasks) {
			logger.info(taskInfo.toString());
		}
	}

	@Test
	public void addEvent() {
		IActivitiEventHandler event = new DefaultActivitiEventHandler();
		activitiService.addEvent(event);
	}

	@Test
	public void assgineeTask() {
		activitiService.claimTask("", "iii");
	}

	@Test
	public void deleteDeploy() {
		activitiService.deleteDeployment("2501");
	}

	@Test
	public void getEvents() {
		addEvent();
		List<Event> events = activitiService.allTaskEvent("pigtwo:1:7");
		for (Event event : events) {
			logger.info(event.toString());
		}
	}

	@Test
	public void listDeployment() {
		List<DeploymentInfo> ps = activitiService.listDeployment();
		for (DeploymentInfo deploymentInfo : ps) {
			logger.info(deploymentInfo.toString());
		}
	}

	@Test
	public void listProcessInfo() {
		List<ProcessInfo> ad = activitiService.listProcessInfo();
		for (ProcessInfo deployment : ad) {
			logger.info(deployment.toString());
		}
	}

	@Test
	public void listProcessInstance() {
		List<ProcessInstanceInfo> ps = activitiService.listProcessInstance();
		for (ProcessInstanceInfo deploymentInfo : ps) {
			logger.info(deploymentInfo.toString());
		}
	}

	@Test
	public void listTaskAssginee() {
		List<TaskInfo> tasks = activitiService.listTasksFromAssignee("pigtwo:1:7", "iii");
		for (TaskInfo taskInfo : tasks) {
			logger.info(taskInfo.toString());
		}
	}

	@Test
	public void listTasksFromProcess() {
		List<TaskInfo> tasks = activitiService.listTasksFromProcess("17508");
		for (TaskInfo taskInfo : tasks) {
			logger.info(taskInfo.toString());
		}
	}

	@Test
	public void startProcess() {
		Map<String, Object> map = new HashMap<>();
		map.put("temp", true);
		ProcessInstanceInfo processInfo = activitiService.startProcess("pigtwo", map);
		logger.info(processInfo.toString());
	}

	@Test
	public void testDeploy() {
		activitiService.deploy("processes/pig2.bpmn");
	}

}