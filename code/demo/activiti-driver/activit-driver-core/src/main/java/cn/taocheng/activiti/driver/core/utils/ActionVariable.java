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

public class ActionVariable {
	private Map<String, Object> variables;

	public ActionVariable() {
		variables = new HashMap<>();
	}

	public ActionVariable put(String key, Object value) {
		variables.put(key, value);
		return this;
	}

	public Map<String, Object> varables() {
		return this.variables;
	}

	public static ActionVariable empty() {
		return new ActionVariable();
	}

	@Override
	public String toString() {
		return "ActionVariable [variables=" + variables + "]";
	}
	
}
