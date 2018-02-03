package com.javapatterns.abstractfactory.farm;

public class TropicalGardener implements Gardener
{
    public Fruit createFruit(String name)
    {
        return new TropicalFruit(name);
    }

    public Veggie createVeggie(String name)
    {
        return new TropicalVeggie(name);
    }
}
