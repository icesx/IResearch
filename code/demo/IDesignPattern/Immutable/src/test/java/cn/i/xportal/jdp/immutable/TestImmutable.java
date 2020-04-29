/**
 * Program  : Test.java<br/>
 * Author   : i<br/>
 * Create   : Jan 9, 2020 12:43:58 PM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.i.xportal.jdp.immutable;

public class TestImmutable {
	public static void main(String[] args) {
		Person alice = new Person("Alice", 10);
		new PrintPersonThread(alice).start();
		new PrintPersonThread(alice).start();
		new PrintPersonThread(alice).start();
	}
}
