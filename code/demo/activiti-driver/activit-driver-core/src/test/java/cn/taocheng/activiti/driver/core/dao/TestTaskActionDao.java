/**
 * Program  : TestDao.java<br/>
 * Author   : i<br/>
 * Create   : 21 May 2020 17:39:13<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.core.dao;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import cn.taocheng.activiti.driver.core.entity.TaskActionEntity;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@RunWith(SpringRunner.class)
@SpringBootTest
@Configuration
@EnableAutoConfiguration
@ActiveProfiles("activit-driver-core")
@EnableJpaRepositories("cn.taocheng.activiti.driver.core.dao")
@ComponentScan(basePackages = { "cn.taocheng.activiti.driver.core", "cn.taocheng.activiti.driver.sample" })

public class TestTaskActionDao {
	private static final Logger logger = LoggerFactory.getLogger(TestTaskActionDao.class);

	@Autowired
	private ITaskActionDao actionDao;

	@Test
	public void listTaskAction() {
		actionDao.findAll().forEach(x -> logger.info(x.toString()));
	}

	@Test
	public void saveTaskAction() {
		actionDao.save(new TaskActionEntity("",""));
	}
}
