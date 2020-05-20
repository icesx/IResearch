/**
 * Program  : IProcess.java<br/>
 * Author   : i<br/>
 * Create   : 19 May 2020 09:46:34<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.manager;

import java.util.List;

import org.activiti.engine.impl.persistence.entity.TaskEntity;

import cn.taocheng.activiti.driver.bean.Assginee;

public interface IProcessOperator {
	List<AbsTaskAction> listTaskAction();

	<T extends AbsTaskAction> void registTaskAction(String defineTaskId, Class<T> clazz);

	void onCreatedTask(TaskEntity entry);

	void onComplateTask(TaskEntity entry);

	List<AbsTaskAction> currentTaskAction(Assginee assignee);

}
