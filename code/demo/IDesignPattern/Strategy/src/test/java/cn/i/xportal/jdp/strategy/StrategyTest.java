/**
 * Program  : StrategyTest.java<br/>
 * Author   : i<br/>
 * Create   : Mar 31, 2017 10:41:43 AM<br/>
 *
 * Copyright 1997-2013 by III.cn ltd.,
 * All rights reserved.
 */
package cn.i.xportal.jdp.strategy;

import cn.i.xportal.jdp.strategy.ConcreteStrategy;
import cn.i.xportal.jdp.strategy.Context;

public class StrategyTest {
	public static void main(String[] args) {
		Context context=new Context(new ConcreteStrategy());
		context.contextInterface();
	}
}
