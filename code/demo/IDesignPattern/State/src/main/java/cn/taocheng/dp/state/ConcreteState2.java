package cn.taocheng.dp.state;

import org.apache.log4j.Logger;

public class ConcreteState2 implements State {
	private static Logger logger = Logger.getLogger(ConcreteState2.class);

	public void sampleOperation(Context context) {
		logger.info("state2...");
	}
}
