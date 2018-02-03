package com.javapatterns.abstractfactory.exercise1;

//correction
public abstract class ComputerProducer
{
    public static ComputerProducer getProducer(String which)
    {
        if (which.equalsIgnoreCase("PC"))
        {
            return new PcProducer();
        }
        else if (which.equalsIgnoreCase("Mac"))
        {
            return new MacProducer();
        }
        else
        {
            return null;
        }
    }
}
