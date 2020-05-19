/**
 * Program  : IProcess.java<br/>
 * Author   : i<br/>
 * Create   : 19 May 2020 09:46:34<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.process;

import java.util.List;

import org.activiti.engine.impl.persistence.entity.TaskEntity;

import ch.qos.logback.core.joran.spi.ActionException;
import cn.taocheng.activiti.demo.manager.Assginee;

public interface IProcess {
	List<AbsTaskAction> listTaskAction();

	<T extends AbsTaskAction> void registTaskAction(String defineTaskId, Class<T> clazz);

	void onCreatedTask(TaskEntity entry) throws ActionException;

	void onComplateTask(TaskEntity entry) throws ActionException;

	List<AbsTaskAction> currentTaskAction(Assginee assignee) throws ActionException;

}