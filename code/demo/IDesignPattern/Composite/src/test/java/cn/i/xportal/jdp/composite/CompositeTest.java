/**
 * Program  : CompositeTest.java<br/>
 * Author   : i<br/>
 * Create   : Mar 29, 2017 9:33:00 AM<br/>
 *
 * Copyright 1997-2013 by III.cn ltd.,
 * All rights reserved.
 */
package cn.i.xportal.jdp.composite;

import cn.i.xportal.jdp.composite.Composite;
import cn.i.xportal.jdp.composite.Leaf;

public class CompositeTest {

	public static void main(String[] args) {
		Composite composite = new Composite();
		Composite composite2 = new Composite();
		Leaf leaf = new Leaf();
		composite.add(leaf);
		composite.add(composite2);
		composite2.add(leaf);
		composite.sampleOperation();
	}
}
