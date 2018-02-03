package com.javapatterns.memento.whiteboxcheckpoints;

import java.util.Vector;

public class Caretaker
{
    private Originator orig;
    private Vector mementos = new Vector();
    private int current;
    private Memento aMemento;

    public Caretaker(Originator orig)
    {
        this.orig = orig;
        current = 0;
    }

    public int createMemento()
    {
        Memento memento = orig.createMemento();
        mementos.addElement(memento);
        return current++;
    }

    public void restoreMemento(int index)
    {
        Memento memento = (Memento)mementos.elementAt(index);
        orig.restoreMemento(memento);
    }

    public void removeMemento(int index)
    {
        mementos.removeElementAt(index);
    }
}
