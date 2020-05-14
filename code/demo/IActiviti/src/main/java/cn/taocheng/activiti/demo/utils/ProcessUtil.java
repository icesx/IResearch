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

import org.activiti.engine.repository.ProcessDefinition;

import cn.taocheng.activiti.demo.modle.ProcessInfo;

public class ProcessUtil {
	public static List<ProcessInfo> processTrans(List<ProcessDefinition> list) {
		List<ProcessInfo> processInfos = new ArrayList<ProcessInfo>();
		for (ProcessDefinition processDefinition : list) {
			processInfos.add(processTran(processDefinition));
		}
		return processInfos;
	}

	public static ProcessInfo processTran(ProcessDefinition processDefinition) {
		return ProcessInfo.builder().withProcessDefine(processDefinition).build();
	}
}
