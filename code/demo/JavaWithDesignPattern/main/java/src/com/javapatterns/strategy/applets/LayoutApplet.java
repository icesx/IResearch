package com.javapatterns.strategy.applets;

import java.applet.Applet;
import java.awt.*;

public class LayoutApplet extends Applet
{
    private Button button1, button2, button3;

    public void init()
    {
        button1 = new Button("我 爱 你");
        button2 = new Button("我 不 爱 你");
        button3 = new Button("我 恨 你");
        add(button1);
        add(button2);
        add(button3);
    }
}
