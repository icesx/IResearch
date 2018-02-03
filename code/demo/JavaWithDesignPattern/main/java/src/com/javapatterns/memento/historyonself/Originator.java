package com.javapatterns.memento.historyonself;

public class Originator
{
    private String state;

    public Originator()
    {
    }

    public void changeState(String state)
    {
        this.state = state;
        System.out.println("State has been changed to: " + state);
    }

    public Memento createMemento()
    {
        return new Memento(this);
    }

    public void restoreMemento(MementoIF memento)
    {
        Memento m = (Memento)memento;
        state = m.getState();
    }

    class Memento implements MementoIF
    {
        private String state;

        private String getState()
        {
            return state;
        }

        private Memento(Originator orig)
        {
            this.state = orig.state;
        }
    }
}

