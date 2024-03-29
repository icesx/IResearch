/**
 * Program  : KryoTest.java<br/>
 * Author   : i<br/>
 * Create   : Jul 3, 2017 9:37:42 PM<br/>
 *
 * Copyright 1997-2013 by 0dog.cn ltd.,
 * All rights reserved.
 */
package cn.xportal.kryo.bean;

import org.apache.log4j.Logger;
import org.junit.Test;

import cn.i.xportal.kryo.register.BeanRegister;
import cn.i.xportal.kryo.register.KryoUtil;
import cn.i.xportal.kryo.stream.StreamProvide;
import cn.i.xportal.kryo.stream.StreamProvideFactory;

public class KryoTest {
	private static Logger logger = Logger.getLogger(KryoTest.class);

	@Test
	public void testBean() {
		CustomBean bean = new CustomBean();
		bean.setId("id");
		bean.setEge(10);
		logger.info(bean);
		StreamProvide unsafe = StreamProvideFactory.unsafe();
		byte[] bs = KryoUtil.serializa(bean, unsafe, new BeanRegister<>(CustomBean.class));
		logger.info(bs.length);
		Object bean2 = KryoUtil.unSerializa(bs, unsafe, new BeanRegister<>(CustomBean.class));
		logger.info(bean2);
	}
}
