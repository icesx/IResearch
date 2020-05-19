/**
 * Program  : ActivitiRest.java<br/>
 * Author   : i<br/>
 * Create   : Oct 23, 2019 4:00:39 PM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.RepositoryService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.taocheng.activiti.driver.bean.DeploymentInfo;
import cn.taocheng.activiti.driver.bean.ProcessInfo;
import cn.taocheng.activiti.driver.bean.TaskInfo;
import cn.taocheng.activiti.driver.service.IActivitiService;
import cn.taocheng.activiti.driver.utils.ResponseUtil;
import cn.taocheng.activiti.driver.web.ResponseInfo;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class ActivitiRest {
	private static final Logger logger = LoggerFactory.getLogger(ActivitiRest.class);

	@Autowired
	private IActivitiService activitiService;

	@Resource
	private RepositoryService repositoryService;

	/**
	 * 查询已部署流程详细信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/processesInfo", method = RequestMethod.GET)
	@ResponseBody
	public ResponseInfo<List<ProcessInfo>> processesInfo() {
		logger.info("查询已部署流程详细信息");
		return ResponseUtil.response(activitiService.listProcessInfo());
	}

	/**
	 * 查询已部署流程
	 * 
	 * @return
	 */
	@RequestMapping(value = "/processes", method = RequestMethod.GET)
	@ResponseBody
	public ResponseInfo<List<DeploymentInfo>> processes() {
		logger.info("查询已部署流程信息");
		return ResponseUtil.response(activitiService.listDeployment());
	}

	/**
	 * 删除已部署流程
	 * 
	 * @param isAll
	 *            是否删除全部
	 * @param ids
	 *            单个删除id
	 */
	@RequestMapping(value = "/delprocesse", method = RequestMethod.GET)
	public Object delProcesse(@RequestParam(name = "isAll") Boolean isAll, @RequestParam(name = "id") String id) {
		if (isAll) {
			activitiService.delProcesseAll();
		} else {
			activitiService.delProcesseById(id);
		}
		return ResponseUtil.response("删除成功");
	}


	/**
	 * 根据流程实例id 返回当前节点信息
	 * 
	 * @param processInstanceId
	 * @return
	 */
	@RequestMapping(value = "/onTask", method = RequestMethod.GET)
	@ResponseBody
	public ResponseInfo<TaskInfo> onTask(@RequestParam(name = "processInstanceId") String processInstanceId) {
		logger.info("查询流程实例当前任务节点" + processInstanceId);
		return ResponseUtil.<TaskInfo> response(activitiService.getTasks(processInstanceId));
	}

	/**
	 * 根据taskid完成节点，并返回下一节点信息
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/completeTask", method = RequestMethod.GET)
	@ResponseBody
	public ResponseInfo<Object> completeTask(@RequestParam(name = "processInstanceId") String processInstanceId, @RequestParam(name = "temp", required = false, defaultValue = "true") String temp) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("temp", temp);
		TaskInfo tasks = activitiService.getTasks(processInstanceId);
		if (tasks == null) {
			return ResponseUtil.response("未找到对应的流程实例");
		}
		logger.info("完成任务节点是 \"{}\" param is {}", tasks.getTaskId());
		activitiService.completeTask(tasks.getTaskId(), map);
		TaskInfo taskInfo = activitiService.getTasks(processInstanceId);
		if (taskInfo == null) {
			taskInfo = new TaskInfo("", "结束", "END", "","");
		}
		return ResponseUtil.<Object> response(taskInfo);
	}
	
	/**
	 * 合证并切跳过选证节点
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/completeTaskList", method = RequestMethod.GET)
	@ResponseBody
	public ResponseInfo<Object> completeTaskList(@RequestParam(name = "processInstanceId") String processInstanceId, @RequestParam(name = "temp", required = false, defaultValue = "true") String temp) {

		logger.info("流程系统批量执行id:"+processInstanceId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("temp", temp);
		List<TaskInfo> tasksList = new ArrayList<>();
		if(StringUtils.isBlank(processInstanceId)){
			return ResponseUtil.response("未找到对应的流程实例");
		}
		String[] processInstanceIds = processInstanceId.split(",");
		for (String id : processInstanceIds) {
			TaskInfo tasks = activitiService.getTasks(id);
			tasksList.add(tasks);
		}
		if (tasksList.size()!=processInstanceIds.length) {
			return ResponseUtil.response("未找到对应的流程实例");
		}
		logger.info("完成任务节点是 \"{}\" param is {}", tasksList.toString());
		for (TaskInfo taskInfo : tasksList) {
			activitiService.completeTask(taskInfo.getTaskId(), map);
		}
		TaskInfo taskInfo = activitiService.getTasks(processInstanceIds[0]);
		if (taskInfo == null) {
			taskInfo = new TaskInfo("", "结束", "END", "","");
		}
		return ResponseUtil.<Object> response(new TaskInfo("", "", taskInfo.getDefinitionKey(), "",""));
	}

}
