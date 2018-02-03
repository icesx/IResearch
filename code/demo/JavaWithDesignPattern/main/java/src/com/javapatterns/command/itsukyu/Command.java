package com.javapatterns.command.itsukyu;

import java.awt.*;

public abstract class Command extends Button
{
    public Command(String caption)
    {
        super(caption);
    }

    public void execute() { }
}
