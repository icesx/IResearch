/**
 * Program  : BeanRegister.java<br/>
 * Author   : i<br/>
 * Create   : Jul 3, 2017 9:00:32 PM<br/>
 *
 * Copyright 1997-2013 by 0dog.cn ltd.,
 * All rights reserved.
 */
package cn.i.xportal.kryo.register;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.serializers.BeanSerializer;

public class BeanRegister<T> extends AbsRegisterProvide<T> {

	public BeanRegister(Class<T> regClass) {
		super(regClass);
	}

	@Override
	public Serializer<T> serializer(Kryo kryo) {
		return new BeanSerializer<T>(kryo, regClass);
	}

}
