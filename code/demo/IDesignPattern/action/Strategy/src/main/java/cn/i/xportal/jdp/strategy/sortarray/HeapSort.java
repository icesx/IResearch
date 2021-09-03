package cn.i.xportal.jdp.strategy.sortarray;

import org.apache.log4j.Logger;

public class HeapSort extends SortStrategy {
	private static Logger logger = Logger.getLogger(HeapSort.class);
	public void sort() {
		logger.info(this);
	}
}
