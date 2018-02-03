package com.javapatterns.memento.blackbox;

class Memento implements MementoIF
{
    private String savedState;
    private Originator anOriginator;

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


