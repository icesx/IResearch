/**
 * Program  : ResponseError.java<br/>
 * Author   : i<br/>
 * Create   : Oct 25, 2019 2:55:20 PM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.core.web;

public class ResponseState {
	int code;

	String info;

	@Override
	public String toString() {
		return "ResponseError [code=" + code + ", info=" + info + "]";
	}

	public ResponseState(int code, String info) {
		this.code = code;
		this.info = info;
	}

	protected ResponseState() {
	}

	public int getCode() {
		return code;
	}

	public String getInfo() {
		return info;
	}

}
