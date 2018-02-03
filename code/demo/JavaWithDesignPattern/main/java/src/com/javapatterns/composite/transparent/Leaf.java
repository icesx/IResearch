package com.javapatterns.composite.transparent;

import java.util.Enumeration;
import java.util.Vector;

public class Leaf implements Component
{
    private Vector componentVector = new java.util.Vector();

    public void sampleOperation()
    {
        // Write your code here
    }

    public void add(Component component)
    {
        componentVector.addElement(component);
    }

    public void remove(Component component)
    {
        componentVector.removeElement(component);
    }

    public Composite getComposite()
    {
        // Write your code here
        return null;
    }

    public Enumeration components()
    {
        // Write your code here
        return null;
    }

}
