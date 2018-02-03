package com.javapatterns.command.stocktrader;

// Invoker. Invoker.java
public class Broker
{
    private Command buyCommand;
    private Command sellCommand;

    //correction
    public Broker(Command aBuyCommand, Command aSellCommand)
    {
        buyCommand = aBuyCommand;
        sellCommand = aSellCommand;
    }

    void buy()
    {
        buyCommand.execute();
    }

    void sell()
    {
        sellCommand.execute();
    }
}
