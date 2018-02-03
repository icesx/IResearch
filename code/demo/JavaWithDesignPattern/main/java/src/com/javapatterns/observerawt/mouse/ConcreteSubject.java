package com.javapatterns.observerawt.mouse;

import java.awt.*;
import java.awt.event.MouseListener;

public class ConcreteSubject extends Frame
{
    private static MouseListener m;

    public ConcreteSubject()
    {
    }

    public static void main(String[] argv)
    {
        ConcreteSubject subj = new ConcreteSubject();
        m = new ConcreteListener();
        subj.setBounds(100, 100, 100, 100);
        subj.addMouseListener(m);
        subj.show();
    }
}
