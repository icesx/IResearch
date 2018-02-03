package com.javapatterns.memento.blackbox;

public class Originator
{
    private String state;

    public Originator() { }

    public MementoIF createMemento()
    {
        return new Memento(this.state);
    }

    public void restoreMemento(MementoIF memento)
    {
        Memento aMemento = (Memento)memento;

        this.setState(aMemento.getState());
    }

    public String getState()
    {
        return this.state;
    }

    public void setState(String state)
    {
        this.state = state;
        System.out.println("state = " + state);
    }

    class Memento implements MementoIF
    {
        private String savedState;

        private Memento(String someState)
        {
            savedState = someState;
        }

        private void setState(String someState)
        {
            savedState = someState;
        }

        private String getState()
        {
            return savedState;
        }
    }
}
