/**
 * Program  : BaseRegister.java<br/>
 * Author   : i<br/>
 * Create   : Jul 3, 2017 9:12:42 PM<br/>
 *
 * Copyright 1997-2013 by 0dog.cn ltd.,
 * All rights reserved.
 */
package cn.i.xportal.kryo.register;

import java.util.Map;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.serializers.MapSerializer;

class MapRegister<T extends Map<?, ?>> extends AbsRegisterProvide<T> {
	public MapRegister(Class<T> regClass) {
		super(regClass);
	}

	private MapSerializer serializer = new MapSerializer();

	@Override
	public Serializer<?> serializer(Kryo kryo) {
		return serializer;
	}

}
