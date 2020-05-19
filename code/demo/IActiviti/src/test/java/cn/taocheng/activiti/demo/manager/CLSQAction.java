/**
 * Program  : TestTaskAction.java<br/>
 * Author   : i<br/>
 * Create   : 16 May 2020 15:37:10<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.manager;

import cn.taocheng.activiti.demo.modle.TaskInfo;
import cn.taocheng.activiti.demo.process.AbsTaskAction;
import cn.taocheng.activiti.demo.task.View;

public class CLSQAction extends AbsTaskAction {

	@Override
	public View view() {
		return new View();
	}

	@Override
	public String taskDefineId() {
		return "XZQSDJCZ";
	}

	@Override
	public Assginee provideAssginee(TaskInfo taskInfo) {
		return selectGfsy(super.getVariable("v1"));
	}

	private Assginee selectGfsy(Object object) {
		return Assginee.fowName((String) object);
	}

}
