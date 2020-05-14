/**
 * Program  : ActivitiServiceTest.java<br/>
 * Author   : i<br/>
 * Create   : 14 May 2020 16:36:54<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.service;

import java.util.List;

import org.activiti.engine.repository.Deployment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.taocheng.activiti.demo.modle.DeploymentInfo;
import cn.taocheng.activiti.demo.modle.ProcessInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ActivitiServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(ActivitiServiceTest.class);

	@Autowired
	private IActivitiService activitiService;

	@Test
	public void testDeploy() {
		activitiService.deploy("processes/pig2.bpmn");
	}

	@Test
	public void testListProcessInfo() {
		List<ProcessInfo> ad = activitiService.listProcessInfo();
		for (ProcessInfo deployment : ad) {
			logger.info(deployment.toString());
		}
	}

	@Test
	public void listProcess() {
		List<DeploymentInfo> ps = activitiService.listProcess();
		for (DeploymentInfo deploymentInfo : ps) {
			logger.info(deploymentInfo.toString());
		}
	}

}
