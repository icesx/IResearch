/**
 * Program  : TaskActionModle.java<br/>
 * Author   : i<br/>
 * Create   : 19 May 2020 15:12:11<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "task_action")
public class TaskActionEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String defineTaskId;

	private String clazz;

	public TaskActionEntity() {
	}

	public TaskActionEntity(String defineTaskId2, String clazz2) {
		this.defineTaskId = defineTaskId2;
		this.clazz = clazz2;
	}

	public String getDefineTaskId() {
		return defineTaskId;
	}

	public void setDefineTaskId(String defineTaskId) {
		this.defineTaskId = defineTaskId;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

}