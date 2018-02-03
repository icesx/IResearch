package com.javapatterns.abstractfactory.farm;

public interface Gardener
{
    Fruit createFruit(String name);

    Veggie createVeggie(String name);
}
