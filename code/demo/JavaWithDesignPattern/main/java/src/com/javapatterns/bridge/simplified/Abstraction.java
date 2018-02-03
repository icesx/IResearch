package com.javapatterns.bridge.simplified;

public abstract class Abstraction
{
    private ConcreteImplementor impl;

    public void operation()
    {
        impl.operationImp();
    }
}
