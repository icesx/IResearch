/**
 * Program  : SCJYBGAction.java<br/>
 * Author   : i<br/>
 * Create   : 18 May 2020 10:45:29<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.sample;

import cn.taocheng.activiti.driver.core.bean.Assginee;
import cn.taocheng.activiti.driver.core.bean.TaskInfo;
import cn.taocheng.activiti.driver.core.manager.BaseTaskAction;
import cn.taocheng.activiti.driver.core.web.View;

public class SCJYBGAction extends BaseTaskAction {

	public SCJYBGAction(TaskInfo taskInfo) {
		super(taskInfo);
	}

	@Override
	public View view() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Assginee provideAssginee(TaskInfo taskInfo) {
		return Assginee.fowName("lisi");
	}

}
