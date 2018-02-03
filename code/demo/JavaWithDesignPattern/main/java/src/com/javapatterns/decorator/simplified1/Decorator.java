package com.javapatterns.decorator.simplified1;

public class Decorator extends ConcreteComponent
{
    private ConcreteComponent component;

    public Decorator(ConcreteComponent component)
    {
        this.component = component;
    }

    public Decorator()
    {
    }

    public void sampleOperation()
    {
        component.sampleOperation();
    }


}
