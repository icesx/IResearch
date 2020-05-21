/**
 * Program  : ActivitiSupportService.java<br/>
 * Author   : i<br/>
 * Create   : Oct 23, 2019 5:29:30 PM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.core.service;

import javax.annotation.Resource;

import org.activiti.engine.IdentityService;

public class ActivitiUserService implements IActivitSupportService {

	@Resource
	private IdentityService identityService;

}
