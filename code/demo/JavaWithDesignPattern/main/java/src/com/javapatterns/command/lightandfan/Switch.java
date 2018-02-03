package com.javapatterns.command.lightandfan;

public class Switch
{
    private Command upCommand;
    private Command downCommand;

    public Switch(Command up, Command down)
    {
        upCommand = up;
        downCommand = down;
    }

    void flipUp()
    {
        // invoker calls back concrete Command, which executes the Command on the receiver
        upCommand.execute();
    }

    void flipDown()
    {
        downCommand.execute();
    }
}
