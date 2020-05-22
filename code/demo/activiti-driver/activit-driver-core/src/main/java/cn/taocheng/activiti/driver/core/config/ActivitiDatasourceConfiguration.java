/**
 * Program  : SomeConfig.java<br/>
 * Author   : i<br/>
 * Create   : 21 May 2020 11:47:12<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.core.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ActivitiDatasourceConfiguration {
	@Primary
	@Bean(name = "activiti-datasource-properties")
	@ConfigurationProperties(prefix = "spring.activiti-datasource")
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}
	@Primary
	@Bean(name = "activiti-datasource")
	public DataSource dataSource(@Qualifier("activiti-datasource-properties") DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().build();
	}

	@Bean
	public JdbcTemplate jdbcTemplate(@Qualifier("activiti-datasource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
