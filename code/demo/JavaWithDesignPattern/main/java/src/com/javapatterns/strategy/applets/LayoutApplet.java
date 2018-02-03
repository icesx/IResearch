package com.javapatterns.strategy.applets;

import java.applet.Applet;
import java.awt.*;

public class LayoutApplet extends Applet
{
    private Button button1, button2, button3;

    public void init()
    {
        button1 = new Button("�� �� ��");
        button2 = new Button("�� �� �� ��");
        button3 = new Button("�� �� ��");
        add(button1);
        add(button2);
        add(button3);
    }
}
