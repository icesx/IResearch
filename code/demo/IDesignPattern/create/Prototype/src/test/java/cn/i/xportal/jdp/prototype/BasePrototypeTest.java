package cn.i.xportal.jdp.prototype;

import org.apache.log4j.Logger;

import cn.i.xportal.jdp.prototype.ConcretePrototype;
import cn.i.xportal.jdp.prototype.Prototype;

public class BasePrototypeTest {
	private static Logger logger = Logger.getLogger(BasePrototypeTest.class);

	public static void main(String[] args) {
		ConcretePrototype concretePrototype = new ConcretePrototype();
		Prototype prototype = (Prototype) concretePrototype.clone();
		logger.info(concretePrototype);
		logger.info(prototype);
	}
}
