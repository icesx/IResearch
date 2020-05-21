/**
 * Program  : Application.java<br/>
 * Author   : i<br/>
 * Create   : Oct 22, 2019 7:07:33 PM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@SpringBootApplication
@EnableAutoConfiguration
@EntityScan("cn.taocheng.activiti.driver.core.entity")
@EnableJpaRepositories("cn.taocheng.activiti.driver.core.dao")
@ComponentScan(basePackages = { "cn.taocheng.activiti.driver.core.**", "cn.taocheng.activiti.driver.sample" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}