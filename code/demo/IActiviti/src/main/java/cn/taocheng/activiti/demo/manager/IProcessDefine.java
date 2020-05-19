/**
 * Program  : ITaskActionManager.java<br/>
 * Author   : i<br/>
 * Create   : 15 May 2020 18:02:33<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.manager;

import cn.taocheng.activiti.demo.bean.Assginee;
import cn.taocheng.activiti.demo.process.IProcess;
import cn.taocheng.activiti.demo.task.ActionParams;

public interface IProcessDefine {
	public static final String START_ASSIGNEE = "start_assignee";

	public IProcess startProcess(String processDefineId, ActionParams params, Assginee assginee);

	public IProcess getProcess(String processInstanceId);

}
