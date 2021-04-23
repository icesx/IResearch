package cn.taocheng.base.concurrent.step;

import java.util.ArrayList;
import java.util.List;

public class StepRunners<T> {
	private List<IStepRunner<T>> runners = new ArrayList<IStepRunner<T>>();

	public StepRunners<T> append(IStepRunner<T> stepRunner) {
		runners.add(stepRunner);
		return this;
	}

	public List<IStepRunner<T>> listRunner() {
		return runners;
	}

}
