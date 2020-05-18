/**
 * Program  : TestTaskAction.java<br/>
 * Author   : i<br/>
 * Create   : 16 May 2020 15:37:10<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.manager;

import cn.taocheng.activiti.demo.task.ActionParams;
import cn.taocheng.activiti.demo.task.ITaskActionEvent;
import cn.taocheng.activiti.demo.task.View;

public class CLSQAction extends ITaskAction {

	@Override
	public View view() {
		return new View();
	}

	@Override
	public void complate(Assginee assginee, ActionParams params) {
		// TODO Auto-generated method stub

	}

	@Override
	public String taskDefineId() {
		return "XZQSDJCZ";
	}

	@Override
	public ITaskActionEvent event() {
		return new ITaskActionEvent() {

		};
	}

}
