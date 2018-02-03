package com.javapatterns.observerawt.mouse4;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConcreteSubject extends Frame
{
    public ConcreteSubject()
    {
    }

    public static void main(String[] argv)
    {
        ConcreteSubject subj = new ConcreteSubject();

        subj.setBounds(100, 100, 100, 100);
        subj.addMouseListener(
            new MouseAdapter()
            {

                public void mouseClicked(MouseEvent e)
                {
                    System.out.println(e.getWhen());
                }
            });
        subj.show();
    }
}
