/**
 * Program  : ActivitiException.java<br/>
 * Author   : i<br/>
 * Create   : 18 May 2020 12:20:27<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.core;

public class ActivitiException extends RuntimeException {

	public ActivitiException(String string) {
		super(string);
	}

	public ActivitiException(Exception e) {
		super(e);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
