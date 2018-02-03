package cn.xportal.java.base.mt;

import org.apache.log4j.Logger;

import cn.xportal.java.base.concurrent.step.ConcurrentStep;
import cn.xportal.java.base.concurrent.step.IStepRunner;
import cn.xportal.java.base.concurrent.step.StepRunners;

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
				logger.info("run1");
				target.setAge("16");
			}
		}).append(new IStepRunner<Target>() {

			public void run(Target target) {
				logger.info("run2");
				target.setName("aobm");
			}
		}));
		logger.info(target);
		System.exit(0);
	}
}
