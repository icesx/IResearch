package com.javapatterns.observerawt.mouse2;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ConcreteSubject extends Frame
{
    private MouseListener aMouseListener = null;

    public ConcreteSubject()
    {
    }

    public static void main(String[] argv)
    {
        ConcreteSubject subj = new ConcreteSubject();

        subj.setBounds(100, 100, 100, 100);
        subj.addMouseListener(
            new MouseListener()
            {

                public void mouseClicked(MouseEvent e)
                {
                    System.out.println(e.getWhen());
                }

                public void mousePressed(MouseEvent e) { }

                public void mouseReleased(MouseEvent e) { }

                public void mouseEntered(MouseEvent e) { }

                public void mouseExited(MouseEvent e) { }

            });
        subj.show();
    }

}
