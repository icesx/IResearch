/**
 * Program  : IRegisterProvide.java<br/>
 * Author   : i<br/>
 * Create   : Jul 3, 2017 8:57:39 PM<br/>
 *
 * Copyright 1997-2013 by 0dog.cn ltd.,
 * All rights reserved.
 */
package cn.i.xportal.kryo.register;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;

public abstract class AbsRegisterProvide<T> {

	protected Class<T> regClass;

	public AbsRegisterProvide(Class<T> regClass) {
		this.regClass = regClass;
	}

	Class<T> regClass() {
		return this.regClass;
	}

	abstract Serializer<?> serializer(Kryo kryo);

}
