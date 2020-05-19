/**
 * Program  : ActivitiManager.java<br/>
 * Author   : i<br/>
 * Create   : 18 May 2020 10:38:45<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.activiti.engine.delegate.event.ActivitiEntityEvent;
import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.engine.repository.Deployment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

import cn.taocheng.activiti.driver.ActivitiException;
import cn.taocheng.activiti.driver.bean.Assginee;
import cn.taocheng.activiti.driver.bean.ProcessInstanceInfo;
import cn.taocheng.activiti.driver.event.MyActivitiEventListener;
import cn.taocheng.activiti.driver.service.IActivitiService;
import cn.taocheng.activiti.driver.utils.ActionParams;

@Component
public class ActivitiManager implements IActivitiManager {
	private static final Logger logger = LoggerFactory.getLogger(ActivitiManager.class);

	private static final String START_ASSIGNEE = "start_assignee";

	@Autowired
	private IActivitiService activitiService;

	@Autowired
	private AutowireCapableBeanFactory beanFactory;

	private Map<String, IProcessOperator> map = new HashMap<String, IProcessOperator>();

	public ActivitiManager() {
		logger.info("init " + this.getClass());
	}

	@PostConstruct
	public void init() {
		activitiService.addEvent(MyActivitiEventListener.instance());
		activitiService.addEvent(new ActivitiEventListener() {

			@Override
			public void onEvent(ActivitiEvent event) {
				switch (event.getType()) {
				case PROCESS_STARTED:
					String instanceId = ((ActivitiEntityEvent) event).getProcessInstanceId();
					getProcess(instanceId);
					break;
				case PROCESS_CANCELLED:
				case PROCESS_COMPLETED:
					removeProcessInstance(((ActivitiEntityEvent) event).getProcessInstanceId());
					break;
				default:
				}
			}

			@Override
			public boolean isFailOnException() {
				return false;
			}
		});
		load();
	}

	private void removeProcessInstance(String instanceId) {
		map.remove(instanceId);
	}

	private void load() {
		List<ProcessInstanceInfo> list = activitiService.listProcessInstance();
		for (ProcessInstanceInfo processInstanceInfo : list) {
			map.put(processInstanceInfo.getProcessInstanceId(), createOperator(processInstanceInfo));
		}
	}

	private IProcessOperator createOperator(ProcessInstanceInfo processInstanceInfo) {
		return new ProcessOperator(processInstanceInfo);
	}

	@Override
	public Deployment deployProcess(String classpath) {
		return this.activitiService.deploy(classpath);
	}

	@Override
	public IProcessOperator startProcess(String processDefineId, ActionParams params, Assginee assginee) {
		params.put(START_ASSIGNEE, assginee.getName());
		ProcessInstanceInfo pi = activitiService.startProcess(processDefineId, params.params());
		ProcessOperator operator = new ProcessOperator(pi);
		beanFactory.autowireBean(operator);
		this.map.put(pi.getProcessInstanceId(), operator);
		return operator;
	}

	@Override
	public IProcessOperator getProcess(String processInstanceId) {
		IProcessOperator pio = this.map.get(processInstanceId);
		if (pio == null) {
			ProcessInstanceInfo pi = activitiService.processInstance(processInstanceId);
			if (pi != null) {
				pio = createOperator(pi);
				map.put(processInstanceId, pio);
			} else {
				throw new ActivitiException("cannto get Process from processInstanceId:" + processInstanceId);
			}
		}
		return pio;
	}
}
