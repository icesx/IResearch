/**
 * Program  : StrategyTest.java<br/>
 * Author   : i<br/>
 * Create   : Mar 31, 2017 10:33:19 AM<br/>
 *
 * Copyright 1997-2013 by III.cn ltd.,
 * All rights reserved.
 */
package cn.i.xportal.jdp.strategy;

import cn.i.xportal.jdp.strategy.sortarray.BinSort;
import cn.i.xportal.jdp.strategy.sortarray.HeapSort;
import cn.i.xportal.jdp.strategy.sortarray.QuickSort;
import cn.i.xportal.jdp.strategy.sortarray.Sorter;

public class StrategySortTest {
	public static void main(String[] args) {
		Sorter sorter = new Sorter();
		sorter.setSortStrategy(new BinSort());
		sorter.sort();
		sorter.setSortStrategy(new HeapSort());
		sorter.sort();
		sorter.setSortStrategy(new QuickSort());
		sorter.sort();
	}
}
