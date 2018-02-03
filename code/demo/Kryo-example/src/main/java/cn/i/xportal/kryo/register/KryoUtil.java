/**
 * Program  : KryoUtil.java<br/>
 * Author   : i<br/>
 * Create   : Jul 3, 2017 8:54:54 PM<br/>
 *
 * Copyright 1997-2013 by 0dog.cn ltd.,
 * All rights reserved.
 */
package cn.i.xportal.kryo.register;

import cn.i.xportal.kryo.stream.StreamProvide;

public class KryoUtil {
	private static KryoContext context = KryoContext.instance();

	public static <T> byte[] serializa(T t, StreamProvide provide, AbsRegisterProvide<T> registerProvide) {
		return context.serializa(registerProvide, t, provide);
	}

	public static <T> Object unSerializa(byte[] bs, StreamProvide provide,AbsRegisterProvide<T> registerProvide) {
		return context.unSerializa(registerProvide,bs, provide);
	}

}
