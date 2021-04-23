/**
 * Program  : TargetRunner.java<br/>
 * Author   : i<br/>
 * Create   : Nov 10, 2017 11:40:14 AM<br/>
 *
 * Copyright 1997-2013 by 0dog.cn ltd.,
 * All rights reserved.
 */
package cn.taocheng.base.concurrent.step;

class TargetRunner<T> implements Runnable {
	private IStepRunner<T> iTargetRunner;
	private T target;
	private Counter counter;

	TargetRunner(IStepRunner<T> iTargetRunner, T target, Counter counter) {
		this.iTargetRunner = iTargetRunner;
		this.target = target;
		this.counter = counter;

	}

	public void run() {
		iTargetRunner.run(target);
		synchronized (counter) {
			counter.plus();
			counter.notifyAll();
		}
	}
}