package com.javapatterns.command.stocktrader;

class SellStockCommand implements Command
{

    private StockMarket stock;

    //correction
    public SellStockCommand(StockMarket aStock)
    {
        stock = aStock;
    }

    public void execute()
    {
        stock.sell();
    }

}

