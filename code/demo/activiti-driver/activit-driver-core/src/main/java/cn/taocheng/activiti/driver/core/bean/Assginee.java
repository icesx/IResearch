/**
 * Program  : ActivitiUser.java<br/>
 * Author   : i<br/>
 * Create   : 15 May 2020 17:44:15<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.core.bean;

public class Assginee {
	private String name;

	Assginee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static Assginee fowName(String id) {
		return new Assginee(id);
	}

}
