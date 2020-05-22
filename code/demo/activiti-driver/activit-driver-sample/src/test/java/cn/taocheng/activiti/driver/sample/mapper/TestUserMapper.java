/**
 * Program  : TestUserMapper.java<br/>
 * Author   : i<br/>
 * Create   : 22 May 2020 14:17:08<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.sample.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import cn.taocheng.activiti.driver.sample.entity.UserEntity;
import cn.taocheng.activiti.driver.sample.entity.UserSexEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
@Configuration
@MapperScan("cn.taocheng.activiti.driver.sample.mapper")
@ComponentScan(basePackages = { "cn.taocheng.activiti.driver.core", "cn.taocheng.activiti.driver.sample" })
public class TestUserMapper {
	private static final Logger logger = LoggerFactory.getLogger(TestUserMapper.class);

	@Autowired
	private UserMapper UserMapper;

	@Test
	public void testInsert() throws Exception {
		UserMapper.insert(new UserEntity(1, "aa", "a123456", UserSexEnum.MAN));
		UserMapper.insert(new UserEntity(2, "bb", "b123456", UserSexEnum.WOMAN));
		UserMapper.insert(new UserEntity(3, "cc", "b123456", UserSexEnum.WOMAN));
		Assert.assertEquals(3, UserMapper.getAll().size());
	}

	@Test
	public void testQuery() throws Exception {
		UserMapper.getAll().forEach(u -> logger.info(u.toString()));
	}

	@Test
	public void testUpdate() throws Exception {
		UserEntity user = UserMapper.getOne(3l);
		System.out.println(user.toString());
		user.setNickName("neo");
		UserMapper.update(user);
		Assert.assertTrue(("neo".equals(UserMapper.getOne(3l).getNickName())));
	}

}