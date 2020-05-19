/**
 * Program  : ActivitiManager.java<br/>
 * Author   : i<br/>
 * Create   : 18 May 2020 10:38:45<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.manager;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

import cn.taocheng.activiti.driver.event.MyActivitiEventListener;
import cn.taocheng.activiti.driver.service.IActivitiService;

@Component
public class ActivitiManager implements IActivitiManager {
	private static final Logger logger = LoggerFactory.getLogger(ActivitiManager.class);

	@Autowired
	private IActivitiService activitiService;

	@Autowired
	private AutowireCapableBeanFactory beanFactory;

	public ActivitiManager() {
		logger.info("init " + this.getClass());
	}

	@PostConstruct
	public void init() {
		activitiService.addEvent(MyActivitiEventListener.instance());
	}

	@Override
	public IProcessDefine registProcess(String classpath) {
		ProcessDefine processDefine = new ProcessDefine(classpath);
		beanFactory.autowireBean(processDefine);
		return processDefine;
	}

}
