package com.javapatterns.observerawt.mouse1;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ConcreteSubject extends Frame implements MouseListener
{
    private static MouseListener m;

    public ConcreteSubject()
    {
    }

    public void mouseClicked(MouseEvent e)
    {
        System.out.println(e.getWhen());
    }

    public void mousePressed(MouseEvent e) { }

    public void mouseReleased(MouseEvent e) { }

    public void mouseEntered(MouseEvent e) { }

    public void mouseExited(MouseEvent e) { }

    public static void main(String[] argv)
    {
        ConcreteSubject subj = new ConcreteSubject();

        subj.setBounds(100, 100, 100, 100);
        subj.addMouseListener(subj);
        subj.show();
    }
}
