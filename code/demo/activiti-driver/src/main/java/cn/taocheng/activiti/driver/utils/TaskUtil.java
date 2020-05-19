/**
 * Program  : TaskUtil.java<br/>
 * Author   : i<br/>
 * Create   : Oct 25, 2019 11:30:47 AM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.activiti.engine.task.Task;

import cn.taocheng.activiti.driver.bean.TaskInfo;

public class TaskUtil {

	public static List<TaskInfo> TaskTrans(List<Task> list) {
		return list.stream().map(t -> taskTran(t)).collect(Collectors.toList());
	}

	public static TaskInfo taskTran(Task task) {
		return TaskInfo.builder().withTask(task).build();
	}

}
