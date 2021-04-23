package cn.taocheng.base.concurrent.step;

import org.apache.log4j.Logger;

public class TestMultiThread {
	private static Logger logger = Logger.getLogger(TestMultiThread.class);

	public static void main(String[] args) {
		Target target = new Target();
		ConcurrentStep.instance().steps(target, new StepRunners<Target>().append(new IStepRunner<Target>() {

			public void run(Target target) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					logger.error(e, e);
				}
				target.setAge("16");
				logger.info("step1 to change target"+target);
			}
		}).append(new IStepRunner<Target>() {

			public void run(Target target) {
				target.setName("aobm");
				logger.info("setp2 to change target"+target);
			}
		}));
		logger.info(target);
		System.exit(0);
	}
}
