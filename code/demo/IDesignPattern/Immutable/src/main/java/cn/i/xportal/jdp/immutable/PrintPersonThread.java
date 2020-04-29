/**
 * Program  : UserThread.java<br/>
 * Author   : i<br/>
 * Create   : Jan 9, 2020 12:40:12 PM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.i.xportal.jdp.immutable;

import org.apache.log4j.Logger;

public class PrintPersonThread extends Thread {
	private static Logger logger = Logger.getLogger(PrintPersonThread.class);

	private Person person;

	public PrintPersonThread(Person person) {
		this.person = person;
	}

	public void run() {
		logger.info(Thread.currentThread().getName() + " prints " + person.name);
	}
}
