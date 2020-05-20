/**
 * Program  : IActivitiManager.java<br/>
 * Author   : i<br/>
 * Create   : 18 May 2020 10:37:58<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.manager;

import java.util.List;

import org.activiti.engine.repository.Deployment;

import cn.taocheng.activiti.driver.bean.Assginee;
import cn.taocheng.activiti.driver.utils.ActionParams;

public interface IActivitiManager {

	IProcessOperator getProcess(String processInstanceId);

	List<IProcessOperator> listProcesses(Assginee assginee);

	Deployment deployProcess(String classpath);

	IProcessOperator startProcess(String processId, ActionParams params, Assginee assginee);

	List<AbsTaskAction> listTaskAction(Assginee assginee);

	List<AbsTaskAction> listTaskAction();

	List<IProcessOperator> listProcesses();

}
