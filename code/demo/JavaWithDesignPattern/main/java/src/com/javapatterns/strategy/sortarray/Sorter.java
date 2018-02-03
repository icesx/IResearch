package com.javapatterns.strategy.sortarray;

public class Sorter
{
    private SortStrategy sortStrategy;

    public void sort()
    {
        sortStrategy.sort();
    }

    //correction
    public void setSortStrategy(SortStrategy aSortStrategy)
    {
        this.sortStrategy = aSortStrategy;
    }

}
