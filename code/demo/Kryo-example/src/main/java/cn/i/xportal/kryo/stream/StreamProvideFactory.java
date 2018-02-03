/**
 * Program  : StreamProvideFactory.java<br/>
 * Author   : i<br/>
 * Create   : Jul 3, 2017 8:23:29 PM<br/>
 *
 * Copyright 1997-2013 by 0dog.cn ltd.,
 * All rights reserved.
 */
package cn.i.xportal.kryo.stream;

public class StreamProvideFactory {
	public static StreamProvide unsafe() {
		return new UnsaftStreamProvide();
	}
}
