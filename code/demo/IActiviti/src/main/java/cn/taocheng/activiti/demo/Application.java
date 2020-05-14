/**
 * Program  : Application.java<br/>
 * Author   : i<br/>
 * Create   : Oct 22, 2019 7:07:33 PM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "cn.taocheng.activiti.demo.rest", "cn.taocheng.activiti.demo.service" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}