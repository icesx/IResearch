package com.javapatterns.decorator.simplified2;

public class ConcreteDecorator implements Component
{
    private Component component;

    public ConcreteDecorator(Component component)
    {
        this.component = component;
    }

    public void sampleOperation()
    {
        component.sampleOperation();
    }
}
