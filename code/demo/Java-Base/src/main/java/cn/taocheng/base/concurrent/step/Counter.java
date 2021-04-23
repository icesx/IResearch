/**
 * Program  : Counter.java<br/>
 * Author   : i<br/>
 * Create   : Nov 10, 2017 11:40:35 AM<br/>
 *
 * Copyright 1997-2013 by 0dog.cn ltd.,
 * All rights reserved.
 */
package cn.taocheng.base.concurrent.step;

class Counter {
	private int size;
	private int count = 0;

	public Counter(int size) {
		this.size = size;
	}

	public boolean notFull() {
		return size > count;
	}

	public void plus() {
		count++;
	}

}