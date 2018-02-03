/**
 * Program  : KryoTest.java<br/>
 * Author   : i<br/>
 * Create   : Jul 3, 2017 11:06:05 AM<br/>
 *
 * Copyright 1997-2013 by 0dog.cn ltd.,
 * All rights reserved.
 */
package cn.xportal.kryo.other;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.CollectionSerializer;
import com.esotericsoftware.kryo.serializers.JavaSerializer;
import com.esotericsoftware.kryo.serializers.MapSerializer;

import cn.xportal.kryo.bean.CustomBean;

public class KryoTest {
	private static Logger logger = Logger.getLogger(KryoTest.class);

	@Test
	public void testCopy() {
		Kryo kryo = new Kryo();
		CustomBean bean = new CustomBean();
		bean.setEge(100L).setId("idd");
		logger.info(bean);
		CustomBean beanCopyd = kryo.copy(bean);
		logger.info(beanCopyd);
	}

	@Test
	public void testObject() {
		CustomBean val = new CustomBean();
		val.setId("1");
		byte[] a = serializationObject(val);
		CustomBean newValue = deserializationObject(a, CustomBean.class);
		logger.info(newValue);
	}

	@Test
	public void testList() {
		List<CustomBean> lst = new ArrayList<CustomBean>();
		for (int i = 0; i < 10; i++) {
			CustomBean val = new CustomBean();
			val.setId("id");
			lst.add(val);
		}

		byte[] a = serializationList(lst, CustomBean.class);
		List<CustomBean> newValue = deserializationList(a, CustomBean.class);
		for (CustomBean customBean : newValue) {
			logger.info(customBean);
		}
	}

	public void testBean() {
		List<CustomBean> lst = new ArrayList<CustomBean>();
		CustomBean val = new CustomBean();
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 10; i++) {
				val.setId("id");
			}
			for (int i = 0; i < 10; i++) {
				val.setId("ID");
			}
			for (int i = 0; i < 10; i++) {
				val.setId("ID");
			}
			lst.add(val);
		}

		byte[] a = serializationList(lst, CustomBean.class);
	}

	public void testMap() {
		Map<String, CustomBean> map = new HashMap<String, CustomBean>();
		for (int i = 0; i < 10; i++) {
			CustomBean val = new CustomBean();
			val.setId("id");
			map.put(val.getId(), val);
		}

		byte[] a = serializationMap(map, CustomBean.class);
		Map<String, CustomBean> newValue = deserializationMap(a, CustomBean.class);
	}

	public void testSet() {
		Set<CustomBean> set = new HashSet<CustomBean>();
		for (int i = 0; i < 10; i++) {
			CustomBean val = new CustomBean();
			val.setId("id");
			set.add(val);
		}

		byte[] a = serializationSet(set, CustomBean.class);
		Set<CustomBean> newValue = deserializationSet(a, CustomBean.class);
	}

	private <T extends Serializable> byte[] serializationObject(T obj) {
		Kryo kryo = new Kryo();
		kryo.setReferences(false);
		kryo.register(obj.getClass(), new JavaSerializer());

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Output output = new Output(baos);
		kryo.writeClassAndObject(output, obj);
		output.flush();
		output.close();

		byte[] b = baos.toByteArray();
		try {
			baos.flush();
			baos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	private <T extends Serializable> T deserializationObject(byte[] obj, Class<T> clazz) {
		Kryo kryo = new Kryo();
		kryo.setReferences(false);
		kryo.register(clazz, new JavaSerializer());
		ByteArrayInputStream bais = new ByteArrayInputStream(obj);
		Input input = new Input(bais);
		return (T) kryo.readClassAndObject(input);
	}

	private <T extends Serializable> byte[] serializationList(List<T> obj, Class<T> clazz) {
		Kryo kryo = new Kryo();
		kryo.setReferences(false);
		kryo.setRegistrationRequired(true);

		CollectionSerializer serializer = new CollectionSerializer();
		serializer.setElementClass(clazz, new JavaSerializer());
		serializer.setElementsCanBeNull(false);

		kryo.register(clazz, new JavaSerializer());
		kryo.register(ArrayList.class, serializer);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Output output = new Output(baos);
		kryo.writeObject(output, obj);
		output.flush();
		output.close();

		byte[] b = baos.toByteArray();
		try {
			baos.flush();
			baos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return b;
	}

	@SuppressWarnings("unchecked")
	private <T extends Serializable> List<T> deserializationList(byte[] obj, Class<T> clazz) {
		Kryo kryo = new Kryo();
		kryo.setReferences(false);
		kryo.setRegistrationRequired(true);
		CollectionSerializer serializer = new CollectionSerializer();
		serializer.setElementClass(clazz, new JavaSerializer());
		serializer.setElementsCanBeNull(false);
		kryo.register(clazz, new JavaSerializer());
		kryo.register(ArrayList.class, serializer);

		ByteArrayInputStream bais = new ByteArrayInputStream(obj);
		Input input = new Input(bais);
		return (List<T>) kryo.readObject(input, ArrayList.class, serializer);
	}

	private <T extends Serializable> byte[] serializationMap(Map<String, T> obj, Class<T> clazz) {
		Kryo kryo = new Kryo();
		kryo.setReferences(false);
		kryo.setRegistrationRequired(true);

		MapSerializer serializer = new MapSerializer();
		serializer.setKeyClass(String.class, new JavaSerializer());
		serializer.setKeysCanBeNull(false);
		serializer.setValueClass(clazz, new JavaSerializer());
		serializer.setValuesCanBeNull(true);

		kryo.register(clazz, new JavaSerializer());
		kryo.register(HashMap.class, serializer);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Output output = new Output(baos);
		kryo.writeObject(output, obj);
		output.flush();
		output.close();

		byte[] b = baos.toByteArray();
		try {
			baos.flush();
			baos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return b;
	}

	@SuppressWarnings("unchecked")
	private <T extends Serializable> Map<String, T> deserializationMap(byte[] obj, Class<T> clazz) {
		Kryo kryo = new Kryo();
		kryo.setReferences(false);
		kryo.setRegistrationRequired(true);

		MapSerializer serializer = new MapSerializer();
		serializer.setKeyClass(String.class, new JavaSerializer());
		serializer.setKeysCanBeNull(false);
		serializer.setValueClass(clazz, new JavaSerializer());
		serializer.setValuesCanBeNull(true);

		kryo.register(clazz, new JavaSerializer());
		kryo.register(HashMap.class, serializer);

		ByteArrayInputStream bais = new ByteArrayInputStream(obj);
		Input input = new Input(bais);
		return (Map<String, T>) kryo.readObject(input, HashMap.class, serializer);
	}

	public static <T extends Serializable> byte[] serializationSet(Set<T> obj, Class<T> clazz) {
		Kryo kryo = new Kryo();
		kryo.setReferences(false);
		kryo.setRegistrationRequired(true);

		CollectionSerializer serializer = new CollectionSerializer();
		serializer.setElementClass(clazz, new JavaSerializer());
		serializer.setElementsCanBeNull(false);

		kryo.register(clazz, new JavaSerializer());
		kryo.register(HashSet.class, serializer);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Output output = new Output(baos);
		kryo.writeObject(output, obj);
		output.flush();
		output.close();

		byte[] b = baos.toByteArray();
		try {
			baos.flush();
			baos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return b;
	}

	@SuppressWarnings("unchecked")
	public static <T extends Serializable> Set<T> deserializationSet(byte[] obj, Class<T> clazz) {
		Kryo kryo = new Kryo();
		kryo.setReferences(false);
		kryo.setRegistrationRequired(true);
		CollectionSerializer serializer = new CollectionSerializer();
		serializer.setElementClass(clazz, new JavaSerializer());
		serializer.setElementsCanBeNull(false);

		kryo.register(clazz, new JavaSerializer());
		kryo.register(HashSet.class, serializer);

		ByteArrayInputStream bais = new ByteArrayInputStream(obj);
		Input input = new Input(bais);
		return (Set<T>) kryo.readObject(input, HashSet.class, serializer);
	}
}
