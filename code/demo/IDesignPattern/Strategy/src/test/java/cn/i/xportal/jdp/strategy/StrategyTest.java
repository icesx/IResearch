/**
 * Program  : StrategyTest.java<br/>
 * Author   : i<br/>
 * Create   : Mar 31, 2017 10:41:43 AM<br/>
 *
 * Copyright 1997-2013 by III.cn ltd.,
 * All rights reserved.
 */
package cn.i.xportal.jdp.strategy;

public class StrategyTest {
	public static void main(String[] args) {
		Context context=new Context(new ConcreteStrategy());
		context.contextInterface();
	}
}
