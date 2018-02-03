package com.javapatterns.memento.whiteboxenhanced;

public class Caretaker
{
    private Originator orig;
    private Memento memento;

    public Caretaker(Originator orig)
    {
        this.orig = orig;
    }

    public void restoreMemento()
    {
        this.orig.restoreMemento(this.memento);
    }

    public void createMemento()
    {
        this.memento = this.orig.createMemento();
    }
}
