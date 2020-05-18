/**
 * Program  : ITaskActionManager.java<br/>
 * Author   : i<br/>
 * Create   : 15 May 2020 18:02:33<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.manager;

import java.util.List;

import org.activiti.engine.impl.persistence.entity.TaskEntity;

import ch.qos.logback.core.joran.spi.ActionException;
import cn.taocheng.activiti.demo.modle.ProcessInstanceInfo;
import cn.taocheng.activiti.demo.task.ActionParams;

public interface IProcessContext {
	public ProcessInstanceInfo startProcess(String processDefineId, ActionParams params, Assginee assginee);

	List<ITaskAction> listTaskAction();

	ITaskAction currentTaskAction(Assginee user) throws ActionException;

	<T extends ITaskAction> void registTaskAction(String defineTaskId, Class<T> clazz);

	void onCreatedEntry(TaskEntity entry) throws ActionException;
}
