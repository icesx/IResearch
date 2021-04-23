/**
 * Program  : State.java<br/>
 * Author   : i<br/>
 * Create   : Nov 10, 2017 11:40:53 AM<br/>
 *
 * Copyright 1997-2013 by 0dog.cn ltd.,
 * All rights reserved.
 */
package cn.taocheng.base.concurrent.step;

class State implements Runnable {
	private Counter counter;
	private Object finished;

	State(Counter counter, Object finished) {
		this.counter = counter;
		this.finished = finished;
	}

	public void run() {
		synchronized (counter) {
			while (counter.notFull()) {
				try {
					counter.wait();
				} catch (InterruptedException e) {
					ConcurrentStep.logger.error(e, e);
				}
			}
		}
		synchronized (finished) {
			finished.notifyAll();
		}
	}

}