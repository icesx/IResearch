/**
 * Program  : IProcess.java<br/>
 * Author   : i<br/>
 * Create   : 19 May 2020 09:46:34<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.core.manager;

import java.util.List;

import cn.taocheng.activiti.driver.core.bean.Assginee;
import cn.taocheng.activiti.driver.core.bean.ProcessInstanceInfo;
import cn.taocheng.activiti.driver.core.bean.TaskInfo;

public interface IProcessOperator {
	List<BaseTaskAction> listTaskAction();

	<T extends BaseTaskAction> void registTaskAction(String defineTaskId, Class<T> clazz);

	List<BaseTaskAction> currentTaskAction(Assginee assignee);

	BaseTaskAction findTaskAction(TaskInfo taskInfo);

	ProcessInstanceInfo getProcessInstanceInfo();

}
