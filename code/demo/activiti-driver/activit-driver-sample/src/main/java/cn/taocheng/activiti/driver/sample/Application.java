/**
 * Program  : Application.java<br/>
 * Author   : i<br/>
 * Create   : Oct 22, 2019 7:07:33 PM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.sample;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@MapperScan("cn.taocheng.activiti.driver.sample.mapper")
@ComponentScan(basePackages = { "cn.taocheng.activiti.driver.core", "cn.taocheng.activiti.driver.sample" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}