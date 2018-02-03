package com.javapatterns.memento.whiteboxenhanced;

public class Client
{
    private static Originator o = new Originator();

    //correction
    private static Caretaker c;

    public static void main(String[] args)
    {
        c = new Caretaker(o);
        o.setState("On");

        // Store internal state
        c.createMemento();

        // Continue changing originator
        o.setState("Off");

        // Restore saved state
        c.restoreMemento();

    }
}
