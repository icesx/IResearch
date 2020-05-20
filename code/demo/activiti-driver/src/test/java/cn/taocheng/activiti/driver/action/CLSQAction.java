/**
 * Program  : TestTaskAction.java<br/>
 * Author   : i<br/>
 * Create   : 16 May 2020 15:37:10<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.action;

import cn.taocheng.activiti.driver.bean.Assginee;
import cn.taocheng.activiti.driver.bean.TaskInfo;
import cn.taocheng.activiti.driver.manager.AbsTaskAction;
import cn.taocheng.activiti.driver.web.View;

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
	protected void onComplate() {
		// TODO Auto-generated method stub
		super.onComplate();
	}

	@Override
	protected void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}

	@Override
	public Assginee provideAssginee(TaskInfo taskInfo) {
		return selectGfsy(super.getVariable("v1"));
	}

	private Assginee selectGfsy(Object object) {
		return Assginee.fowName((String) object);
	}

	@Override
	public void assginee(String assginee) {
		super.assginee(assginee);
	}

	@Override
	public String explain() {
		return super.explain();
	}

}
