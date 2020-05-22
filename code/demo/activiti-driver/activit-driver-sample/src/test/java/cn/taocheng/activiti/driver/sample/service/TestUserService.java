/**
 * Program  : TestUserService.java<br/>
 * Author   : i<br/>
 * Create   : 22 May 2020 09:23:17<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.sample.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Configuration
@MapperScan("cn.taocheng.activiti.driver.sample.mapper")
@ComponentScan(basePackages = { "cn.taocheng.activiti.driver.core", "cn.taocheng.activiti.driver.sample" })

public class TestUserService {
	private static final Logger logger = LoggerFactory.getLogger(TestUserService.class);

	@Resource
	private IUserService userService;

	@Test
	public void listUser() {
		userService.getUsers().forEach(u -> logger.info(u.toString()));
	}
}
