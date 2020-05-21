/**
 * Program  : ActionParams.java<br/>
 * Author   : i<br/>
 * Create   : 15 May 2020 17:39:20<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.core.utils;

import java.util.HashMap;
import java.util.Map;

public class ActionParams {
	private Map<String, Object> params;

	public ActionParams() {
		params = new HashMap<>();
	}

	public ActionParams put(String key, Object value) {
		params.put(key, value);
		return this;
	}

	public Map<String, Object> params() {
		return this.params;
	}

	public static ActionParams empty() {
		return new ActionParams();
	}
}
