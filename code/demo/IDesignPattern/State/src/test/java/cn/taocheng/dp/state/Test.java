/**
 * Program  : Test.java<br/>
 * Author   : i<br/>
 * Create   : 26 May 2020 17:23:12<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.dp.state;

public class Test {
	public static void main(String[] args) {
		Context context = new Context();

		ConcreteState startState = new ConcreteState();
		startState.sampleOperation(context);

		System.out.println(context.getState().toString());

		ConcreteState2 stopState = new ConcreteState2();
		stopState.sampleOperation(context);

		System.out.println(context.getState().toString());
	}
}
