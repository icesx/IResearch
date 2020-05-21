/**
 * Program  : TestActivitiManager.java<br/>
 * Author   : i<br/>
 * Create   : 19 May 2020 18:28:12<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.core.manager;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import cn.taocheng.activiti.driver.core.bean.Assginee;

@RunWith(SpringRunner.class)
@SpringBootTest
@Configuration
@SpringBootApplication
@EnableAutoConfiguration
@ActiveProfiles("activit-driver-core") 
@EntityScan("cn.taocheng.activiti.driver.core.entity")
@EnableJpaRepositories("cn.taocheng.activiti.driver.core.dao")
@ComponentScan(basePackages = { "cn.taocheng.activiti.driver.core.**", "cn.taocheng.activiti.driver.sample" })
public class TestActivitiManager {
	private static final Logger logger = LoggerFactory.getLogger(TestActivitiManager.class);

	@Autowired
	private IActivitiManager activitiManager;

	@Test
	public void deploy() {
		activitiManager.deployProcess("processes/pig.bpmn");
	}

	@Test
	public void getProcess() {
		IProcessOperator process = activitiManager.getProcess("75005");
		logger.info(process.toString());
	}

	@Test
	public void getTaskAction() {
		List<BaseTaskAction> task = activitiManager.listTaskAction(Assginee.fowName("zhangsan"));
		for (BaseTaskAction absTaskAction : task) {
			logger.info(absTaskAction.toString());
		}
	}

	@Test
	public void listProcessAssginee() {
		List<IProcessOperator> task = activitiManager.listProcesses(Assginee.fowName("zhangsan"));
		for (IProcessOperator absTaskAction : task) {
			logger.info(absTaskAction.toString());
		}
	}

	@Test
	public void listProcess() {
		List<IProcessOperator> task = activitiManager.listProcesses();
		for (IProcessOperator absTaskAction : task) {
			logger.info(absTaskAction.toString());
		}
	}

	@Test
	public void listTaskAction() {
		activitiManager.listTaskAction().stream().forEach(x -> logger.info(x.toString()));
	}

	@Test
	public void deleteProcess() {
		activitiManager.deleteProcessInstance("115005", "test");
	}
}
