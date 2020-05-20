/**
 * Program  : IProcessEventHandler.java<br/>
 * Author   : i<br/>
 * Create   : 20 May 2020 12:23:25<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.manager;

import org.activiti.engine.impl.persistence.entity.TaskEntity;

public interface IProcessEventHandler {

	void onComplateTask(TaskEntity entry);

	void onCreatedTask(TaskEntity entry);

}
