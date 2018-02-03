package com.javapatterns.builder;

public class Director
{
    private Builder builder;

    public Director(Builder builder)
    {
        this.builder = builder;
    }

    public void construct()
    {
        builder = new ConcreteBuilder();

        builder.buildPart1();

        builder.buildPart2();

        builder.retrieveResult();

        //continue with other code
    }
}
