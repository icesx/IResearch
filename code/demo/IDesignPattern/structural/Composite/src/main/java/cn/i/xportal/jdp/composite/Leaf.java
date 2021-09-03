package cn.i.xportal.jdp.composite;

import org.apache.log4j.Logger;

public class Leaf implements Component {
	private static Logger logger = Logger.getLogger(Leaf.class);
	public Composite getComposite() {
		logger.info("leaf getComposite");
		return null;
	}

	public void sampleOperation() {
		logger.info("lef sampleOperation");
	}
}
