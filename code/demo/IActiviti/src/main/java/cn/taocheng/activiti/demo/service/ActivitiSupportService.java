/**
 * Program  : ActivitiSupportService.java<br/>
 * Author   : i<br/>
 * Create   : Oct 23, 2019 5:29:30 PM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.service;

import javax.annotation.Resource;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;

public class ActivitiSupportService implements IActivitSupportService {
	@Resource
	private HistoryService historyService;

	@Resource
	private ManagementService managementService;

	@Resource
	private IdentityService identityService;

	public void dd() {
		identityService.setAuthenticatedUserId("kitty");
	}
}
