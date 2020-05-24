package cn.i.xportal.jdp.factorymethod;

import org.apache.log4j.Logger;

public class Client {
	private static Logger logger = Logger.getLogger(Client.class);

	public static void main(String[] args) {
		Creator creator1 = new ConcreteCreator1();
		Product prod1 = creator1.factory();
		logger.info(prod1);
		Creator creator2 = new ConcreteCreator2();
		prod1 = creator2.factory();
		logger.info(prod1);
	}
}
