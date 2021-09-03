package cn.i.xportal.jdp.strategy.sortarray;

public class Sorter {
	private SortStrategy sortStrategy;

	public void sort() {
		sortStrategy.sort();
	}

	public void setSortStrategy(SortStrategy aSortStrategy) {
		this.sortStrategy = aSortStrategy;
	}

}
