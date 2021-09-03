package cn.taocheng.dp.state;

import org.apache.log4j.Logger;

public class ConcreteState implements State {
	private static Logger logger = Logger.getLogger(ConcreteState.class);

	public void sampleOperation(Context context) {
		logger.info("state...");
		context.setState(this);
	}
}
