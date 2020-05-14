/**
 * Program  : ProcessUtils.java<br/>
 * Author   : i<br/>
 * Create   : Oct 25, 2019 10:26:22 AM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.utils;

import org.activiti.engine.runtime.ProcessInstance;

import cn.taocheng.activiti.demo.modle.ProcessInstanceInfo;

/**
 * 流程实例
 * 
 * @author zhangjiaji
 */
public class ProcessInstanceUtil {

	public static ProcessInstanceInfo processTran(ProcessInstance instance) {
		return ProcessInstanceInfo.builder().withProcessInstance(instance).build();
	}
}
