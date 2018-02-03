/**
 * Program  : CollectionRegister.java<br/>
 * Author   : i<br/>
 * Create   : Jul 3, 2017 9:19:14 PM<br/>
 *
 * Copyright 1997-2013 by 0dog.cn ltd.,
 * All rights reserved.
 */
package cn.i.xportal.kryo.register;

import java.util.Collection;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.serializers.CollectionSerializer;

class CollectionRegister<T extends Collection<?>> extends AbsRegisterProvide<T> {

	public CollectionRegister(Class<T> regClass) {
		super(regClass);
	}

	private CollectionSerializer serializer = new CollectionSerializer();

	@Override
	Serializer<?> serializer(Kryo kryo) {
		return serializer;
	}

}
