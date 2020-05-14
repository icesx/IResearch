/**
 * Program  : ResponseUtil.java<br/>
 * Author   : i<br/>
 * Create   : Oct 25, 2019 2:40:27 PM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.utils;

import cn.taocheng.activiti.demo.web.ResponseInfo;

public class ResponseUtil {

	private static final int _200 = 200;

	public static <T> ResponseInfo<T> response(T startProcess) {
		return ResponseInfo.<T>builder().withData(startProcess).withCode(_200).withInfo("OK").build();
	}

}
