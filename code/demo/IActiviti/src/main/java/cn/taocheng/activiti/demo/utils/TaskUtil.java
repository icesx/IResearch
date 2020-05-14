/**
 * Program  : TaskUtil.java<br/>
 * Author   : i<br/>
 * Create   : Oct 25, 2019 11:30:47 AM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.utils;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.task.Task;

import cn.taocheng.activiti.demo.modle.TaskInfo;

public class TaskUtil {

	public static List<TaskInfo> TaskTrans(List<Task> list) {
		List<TaskInfo> taskInfos = new ArrayList<>();
		for (Task task : list) {
			taskInfos.add(taskTran(task));
		}
		return taskInfos;
	}

	public static TaskInfo taskTran(Task task) {
		return TaskInfo.builder().withId(task).build();
	}

}
