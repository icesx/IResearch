/**
 * Program  : ProcessUtils.java<br/>
 * Author   : i<br/>
 * Create   : Oct 25, 2019 10:26:22 AM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.utils;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.repository.Deployment;

import cn.taocheng.activiti.demo.bean.DeploymentInfo;

public class DeploymentUtil {
	public static List<DeploymentInfo> processTrans(List<Deployment> list) {
		List<DeploymentInfo> deployInfos = new ArrayList<DeploymentInfo>();
		for (Deployment deploy : list) {
			deployInfos.add(processTran(deploy));
		}
		return deployInfos;
	}

	public static DeploymentInfo processTran(Deployment deployment) {
		return DeploymentInfo.builder().withDeployment(deployment).build();
	}
}
