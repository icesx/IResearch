package com.javapatterns.command.javaawt;

import java.awt.*;

public class ResetCommand extends Button implements CommandFromGod
{
    private Panel p;

    public ResetCommand(String caption, Panel pnl)
    {
        super(caption);
        p = pnl;
    }

    public void execute()
    {
        p.setBackground(Color.black);
    }
}

