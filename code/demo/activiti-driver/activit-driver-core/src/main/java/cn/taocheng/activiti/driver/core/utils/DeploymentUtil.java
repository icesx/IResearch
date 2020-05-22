/**
 * Program  : ProcessUtils.java<br/>
 * Author   : i<br/>
 * Create   : Oct 25, 2019 10:26:22 AM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.core.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.activiti.engine.repository.Deployment;

import cn.taocheng.activiti.driver.core.bean.DeploymentInfo;

public class DeploymentUtil {
	public static List<DeploymentInfo> processTrans(List<Deployment> list) {
		return list.stream().map(d -> processTran(d)).collect(Collectors.toList());
	}

	public static DeploymentInfo processTran(Deployment deployment) {
		return DeploymentInfo.builder().withDeployment(deployment).build();
	}
}
