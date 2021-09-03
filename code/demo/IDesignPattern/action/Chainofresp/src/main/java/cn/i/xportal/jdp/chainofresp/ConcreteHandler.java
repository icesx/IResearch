package cn.i.xportal.jdp.chainofresp;

import org.apache.log4j.Logger;

public class ConcreteHandler extends Handler {
	private static Logger logger = Logger.getLogger(ConcreteHandler.class);

	public void handleRequest() {
		logger.info("The request is passed to " + this);
	}
}
