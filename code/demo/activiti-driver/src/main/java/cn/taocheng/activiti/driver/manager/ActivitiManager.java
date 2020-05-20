/**
 * Program  : ActivitiManager.java<br/>
 * Author   : i<br/>
 * Create   : 18 May 2020 10:38:45<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.manager;

import java.util.List;
import java.util.stream.Collectors;

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

	public ActivitiManager() {
		logger.info("init " + this.getClass());
	}

	@PostConstruct
	public void init() {
		logger.info("init to add event");
		activitiService.addEvent(MyActivitiEventListener.instance());
		activitiService.addEvent(new ActivitiEventListener() {

			@Override
			public void onEvent(ActivitiEvent event) {
				switch (event.getType()) {
				case PROCESS_STARTED:
					String processInstanceId = processInstanceId(event);
					logger.info("processInstance={} is PROCESS_STARTED", processInstanceId);
					break;
				case PROCESS_CANCELLED:
					processInstanceId = processInstanceId(event);
					logger.info("processInstance={} is PROCESS_CANCELLED", processInstanceId);
					break;
				case PROCESS_COMPLETED:
					processInstanceId = processInstanceId(event);
					logger.info("processInstance={} is PROCESS_COMPLETED", processInstanceId);
					break;
				default:
				}
			}

			private String processInstanceId(ActivitiEvent event) {
				return ((ActivitiEntityEvent) event).getProcessInstanceId();
			}

			@Override
			public boolean isFailOnException() {
				return false;
			}
		});
	}

	private IProcessOperator createOperator(ProcessInstanceInfo processInstanceInfo) {
		ProcessOperator operator = ProcessOperator.newInstance(processInstanceInfo, this.beanFactory);
		beanFactory.autowireBean(operator);
		return operator;
	}

	@Override
	public Deployment deployProcess(String classpath) {
		return this.activitiService.deploy(classpath);
	}

	@Override
	public IProcessOperator startProcess(String processDefineId, ActionParams params, Assginee assginee) {
		params.put(START_ASSIGNEE, assginee.getName());
		ProcessInstanceInfo pi = activitiService.startProcess(processDefineId, params.params());
		ProcessOperator operator = ProcessOperator.newInstance(pi, beanFactory);
		operator.init();
		return operator;
	}

	@Override
	public IProcessOperator getProcess(String processInstanceId) {
		ProcessInstanceInfo pi = activitiService.processInstance(processInstanceId);
		if (pi != null) {
			IProcessOperator pio = createOperator(pi);
			return pio;
		} else {
			throw new ActivitiException("cannto get Process from processInstanceId:" + processInstanceId);
		}
	}

	@Override
	public List<AbsTaskAction> getTaskActionForAssginee(Assginee assginee) {
		return this.activitiService
				.listTasksFromAssignee(assginee.getName())
				.stream()
				.map(taskInfo -> this.getProcess(taskInfo.getProcessInstanceId()).findTaskAction(taskInfo))
				.collect(Collectors.toList());
	}

	@Override
	public List<IProcessOperator> getProcesses(Assginee assginee) {
		return this.activitiService
				.listTasksFromAssignee(assginee.getName())
				.stream()
				.map(taskInfo -> this.getProcess(taskInfo.getProcessInstanceId()))
				.collect(Collectors.toList());
	}

}
