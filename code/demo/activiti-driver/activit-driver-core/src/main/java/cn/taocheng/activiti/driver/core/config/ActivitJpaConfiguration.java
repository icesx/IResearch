/**
 * Program  : JpaConfiguration.java<br/>
 * Author   : i<br/>
 * Create   : 21 May 2020 14:05:11<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.core.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
		"cn.taocheng.activiti.driver.core.dao" }, entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager")
public class ActivitJpaConfiguration {
	@Primary
	@Bean(name = "activiti-jpa-properties")
	@ConfigurationProperties(prefix = "spring.activiti-jpa")
	public JpaProperties jpaProperties() {
		return new JpaProperties();
	}

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			@Qualifier("activiti-datasource") DataSource primaryDataSource,
			@Qualifier("activiti-jpa-properties") JpaProperties jpaProperties,
			EntityManagerFactoryBuilder builder) {
		return builder
				// 设置数据源
				.dataSource(primaryDataSource)
				// 设置jpa配置
				// .properties(jpaProperties.getHibernateProperties(new HibernateSettings()))
				// 设置实体包名
				.packages("cn.taocheng.activiti.driver.core.entity")
				// 设置持久化单元名，用于@PersistenceContext注解获取EntityManager时指定数据源
				.persistenceUnit("activitiPersistenceUnit")
				.build();
	}

	@Bean(name = "entityManager")
	public EntityManager entityManager(@Qualifier("entityManagerFactory") EntityManagerFactory factory) {
		return factory.createEntityManager();
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("entityManagerFactory") EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}
}
