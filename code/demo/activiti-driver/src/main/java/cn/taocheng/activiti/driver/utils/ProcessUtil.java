/**
 * Program  : ProcessUtils.java<br/>
 * Author   : i<br/>
 * Create   : Oct 25, 2019 10:26:22 AM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.activiti.engine.repository.ProcessDefinition;

import cn.taocheng.activiti.driver.bean.ProcessInfo;

public class ProcessUtil {
	public static List<ProcessInfo> processTrans(List<ProcessDefinition> list) {
		return list.stream().map(pd -> processTran(pd)).collect(Collectors.toList());
	}

	public static ProcessInfo processTran(ProcessDefinition processDefinition) {
		return ProcessInfo.builder().withProcessDefine(processDefinition).build();
	}
}
