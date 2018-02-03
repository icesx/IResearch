package cn.xportal.java.base.concurrent.step;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

public class ConcurrentStep {
	private static final int POOL_SIZE = 100;
	private static ConcurrentStep instance;
	static Logger logger = Logger.getLogger(ConcurrentStep.class);
	private ExecutorService executors = Executors.newFixedThreadPool(POOL_SIZE);

	private ConcurrentStep() {
		logger.info("init " + this.getClass());
	}

	public static synchronized ConcurrentStep instance() {
		return instance = (instance == null) ? new ConcurrentStep() : instance;
	}

	public <T> void steps(final T target, StepRunners<T> runner) {
		List<IStepRunner<T>> runners = runner.listRunner();
		final int size = runners.size();
		Object finished = new Object();
		Counter counter = new Counter(size);
		new Thread(new State(counter, finished)).start();
		for (int i = 0; i < runners.size(); i++) {
			final IStepRunner<T> stepRunner = runners.get(i);
			executors.execute(new TargetRunner<T>(stepRunner, target, counter));
		}
		synchronized (finished) {
			try {
				finished.wait();
			} catch (InterruptedException e) {
				logger.error(e, e);
			}
		}
	}
}
