/**
 * Program  : MyBean.java<br/>
 * Author   : i<br/>
 * Create   : Jul 3, 2017 11:07:35 AM<br/>
 *
 * Copyright 1997-2013 by 0dog.cn ltd.,
 * All rights reserved.
 */
package cn.xportal.kryo.bean;

import java.io.Serializable;

public class CustomBean implements Serializable {
	private String name, id;
	private long ege;

	public String getName() {
		return name;
	}

	public CustomBean setName(String name) {
		this.name = name;
		return this;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getEge() {
		return ege;
	}

	public CustomBean setEge(long ege) {
		this.ege = ege;
		return this;
	}

	@Override
	public String toString() {
		return "MyBean [name=" + name + ", id=" + id + ", ege=" + ege + "]";
	}
}
