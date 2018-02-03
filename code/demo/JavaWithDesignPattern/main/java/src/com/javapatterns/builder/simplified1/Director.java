package com.javapatterns.builder.simplified1;

public abstract class Director
{
    private ConcreteBuilder builder;

    public void construct()
    {
        builder.buildPart1();
        builder.buildPart2();

        Product product = builder.getResult();
    }
}
