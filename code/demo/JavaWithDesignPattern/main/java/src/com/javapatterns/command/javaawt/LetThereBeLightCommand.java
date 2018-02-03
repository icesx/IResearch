package com.javapatterns.command.javaawt;

import java.awt.*;

public class LetThereBeLightCommand extends Button implements CommandFromGod
{
    private Panel p;

    public LetThereBeLightCommand(String caption, Panel pnl)
    {
        super(caption);
        p = pnl;
    }

    public void execute()
    {
        p.setBackground(Color.white);
    }
}

