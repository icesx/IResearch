package com.javapatterns.abstractfactory.exercise1;

public class MacProducer extends ComputerProducer
{
    public Cpu createCpu()
    {
        return new MacCpu();
    }

    public Ram createRam()
    {
        return new MacRam();
    }
}
