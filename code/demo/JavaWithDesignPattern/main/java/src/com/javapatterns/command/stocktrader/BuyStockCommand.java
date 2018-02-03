package com.javapatterns.command.stocktrader;

class BuyStockCommand implements Command
{

    private StockMarket stock;

    //correction
    public BuyStockCommand(StockMarket aStock)
    {
        stock = aStock;
    }

    public void execute()
    {
        stock.buy();
    }

}

