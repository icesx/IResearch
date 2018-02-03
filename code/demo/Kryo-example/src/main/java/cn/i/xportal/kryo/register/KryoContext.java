/**
 * Program  : AbsKryoContext.java<br/>
 * Author   : i<br/>
 * Create   : Jul 3, 2017 8:13:35 PM<br/>
 *
 * Copyright 1997-2013 by 0dog.cn ltd.,
 * All rights reserved.
 */
package cn.i.xportal.kryo.register;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.FastInput;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.pool.KryoFactory;
import com.esotericsoftware.kryo.pool.KryoPool;

import cn.i.xportal.kryo.stream.StreamProvide;

public class KryoContext {
	private static Logger logger = Logger.getLogger(KryoContext.class);
	private static KryoContext instance;

	private KryoContext() {
		logger.info("init " + this.getClass());
		kryoPool = new KryoPool.Builder(factory).build();
	}

	public static synchronized KryoContext instance() {
		return instance = (instance == null) ? new KryoContext() : instance;
	}

	private static KryoFactory factory = new KryoFactory() {
		@Override
		public Kryo create() {
			Kryo kryo = new Kryo();
			return kryo;
		}
	};

	private KryoPool kryoPool;

	public <T> byte[] serializa(AbsRegisterProvide<T> regisProvide, T t, StreamProvide provide) {
		Kryo kryo = kryoPool.borrow();
		try {
			kryo.setReferences(false);
			kryo.register(t.getClass(), regisProvide.serializer(kryo));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			Output output = new Output(baos);
			kryo.writeClassAndObject(output, t);
			output.flush();
			output.close();
			byte[] b = baos.toByteArray();
			baos.flush();
			baos.close();
			return b;
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			kryoPool.release(kryo);
		}
	}

	public <T> Object unSerializa(AbsRegisterProvide<T> regisProvide, byte[] bs, StreamProvide provide) {
		Kryo kryo = kryoPool.borrow();
		try {
			FastInput fot = new FastInput(bs);
			Input input = provide.input(fot);
			kryo.setReferences(false);
			kryo.register(regisProvide.regClass(), regisProvide.serializer(kryo));
			Object obj = kryo.readClassAndObject(input);
			input.close();
			return obj;
		} finally {
			kryoPool.release(kryo);
		}
	}
}
