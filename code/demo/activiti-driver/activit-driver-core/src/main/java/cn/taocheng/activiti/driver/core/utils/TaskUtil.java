/**
 * Program  : TaskUtil.java<br/>
 * Author   : i<br/>
 * Create   : Oct 25, 2019 11:30:47 AM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.core.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.task.Task;

import cn.taocheng.activiti.driver.core.bean.HistoryTaskInfo;
import cn.taocheng.activiti.driver.core.bean.TaskInfo;

public class TaskUtil {

	public static List<TaskInfo> taskTrans(List<Task> list) {
		return list.stream().map(t -> taskTran(t)).collect(Collectors.toList());
	}

	public static TaskInfo taskTran(Task task) {
		return TaskInfo.builder().withTask(task).build();
	}

	public static HistoryTaskInfo historyTaskTran(HistoricTaskInstance task) {
		return HistoryTaskInfo.historyBuilder().withTask(task).build();
	}

	public static List<HistoryTaskInfo> historyTaskTrans(List<HistoricTaskInstance> historyTasks) {
		return historyTasks.stream().map(x -> historyTaskTran(x)).collect(Collectors.toList());
	}

}
