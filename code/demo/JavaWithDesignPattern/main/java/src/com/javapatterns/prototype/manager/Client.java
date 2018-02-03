package com.javapatterns.prototype.manager;

public class Client
{
    public void registerPrototype()
    {
        prototype = new ConcretePrototype();

        Prototype copytype = (Prototype)prototype.clone();

        mgr.add(copytype);
    }

    private PrototypeManager mgr;
    private Prototype prototype;

}
