/**
 * Program  : UnsaftStreamFactory.java<br/>
 * Author   : i<br/>
 * Create   : Jul 3, 2017 8:06:06 PM<br/>
 *
 * Copyright 1997-2013 by 0dog.cn ltd.,
 * All rights reserved.
 */
package cn.i.xportal.kryo.stream;

import java.io.InputStream;
import java.io.OutputStream;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.io.UnsafeInput;
import com.esotericsoftware.kryo.io.UnsafeMemoryOutput;

class UnsaftStreamProvide extends StreamProvide {

	@Override
	public Input input(InputStream is) {
		return new UnsafeInput(is);
	}

	@Override
	public Output output(OutputStream os) {
		return new UnsafeMemoryOutput(os);
	}

}
