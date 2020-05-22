/**
 * Program  : TestTaskAction.java<br/>
 * Author   : i<br/>
 * Create   : 16 May 2020 15:37:10<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.sample;

import javax.annotation.Resource;

import cn.taocheng.activiti.driver.core.bean.Assginee;
import cn.taocheng.activiti.driver.core.bean.TaskInfo;
import cn.taocheng.activiti.driver.core.manager.BaseTaskAction;
import cn.taocheng.activiti.driver.core.web.View;
import cn.taocheng.activiti.driver.sample.entity.UserEntity;
import cn.taocheng.activiti.driver.sample.service.IUserService;

public class CLSQAction extends BaseTaskAction {

	@Resource
	private IUserService userService;

	public CLSQAction(TaskInfo taskInfo) {
		super(taskInfo);
	}

	@Override
	public View view() {
		return new View();
	}

	@Override
	protected void onComplate() {
		UserEntity user = userService.getUser(1l);
		super.setAssginee(user.getUserName());
	}

	@Override
	protected void onCreate() {
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
	public void setAssginee(String assginee) {
		super.setAssginee(assginee);
	}

	@Override
	public String explain() {
		return super.explain();
	}

}
